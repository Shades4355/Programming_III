// File name:   ShapeDrawer
// Written by:  Shades Meyers
// Description: A driver class for drawing shapes
// Challenges:  Getting shapes to have teh right color.
//              Removing an event handler.
// Time Spent:  5 h 54 min +
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-30    SM      File created
// 2024-May-01      SM      Worked on rendering a Circle
// 2024-May-02      SM      continued first pass work


package smFinal.smFinal;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class ShapeDrawer extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // Variables
        int red = 0;
        int green = 0;
        int blue = 0;
        AtomicBoolean filled = new AtomicBoolean(false);
        // Using AtomicBoolean instead of Boolean to get around a lamda issue

        // create root scene
        BorderPane root = new BorderPane();

        // create GUI
        // Buttons
        Button clearBtn = new Button("Clear");
        Button undoBtn = new Button("Undo");
        Button exitBtn = new Button("Exit");
        // Button box
        HBox btnBox = new HBox(10);
        btnBox.getChildren().addAll(clearBtn, undoBtn, exitBtn);
        btnBox.setAlignment(Pos.CENTER);

        // add combo box
        ObservableList<String> shapes = FXCollections.observableArrayList(
                "Circle", "Oval", "Rectangle", "Square", "Line");
        ComboBox<String> shapeChooser = new ComboBox<String>();
        shapeChooser.setItems(shapes);
        shapeChooser.setValue("Circle");

        // add box for label and combo box
        BorderPane shapeChooserBox = new BorderPane();
        Label selectLabel = new Label("Select a Geometric Object");
        shapeChooserBox.setLeft(selectLabel);
        shapeChooserBox.setRight(shapeChooser);

        // Color chooser box
        HBox colorBox = new HBox(5);
        // Red slider
        VBox redBox = new VBox();
        Label redValue = new Label("0");
        redValue.setMinWidth(20);
        redValue.setAlignment(Pos.CENTER);
        Slider redSlider = new Slider(0, 255, 0);
        redSlider.setOrientation(Orientation.VERTICAL);
        redBox.getChildren().addAll(new Label("R"), redValue, redSlider);
        // Green slider
        VBox greenBox = new VBox();
        Label greenValue = new Label("0");
        greenValue.setMinWidth(20);
        greenValue.setAlignment(Pos.CENTER);
        Slider greenSlider = new Slider(0, 255, 0);
        greenSlider.setOrientation(Orientation.VERTICAL);
        greenBox.getChildren().addAll(new Label("G"), greenValue, greenSlider);
        // Blue slider
        VBox blueBox = new VBox();
        Label blueValue = new Label("0");
        blueValue.setMinWidth(20);
        blueValue.setAlignment(Pos.CENTER);
        Slider blueSlider = new Slider(0, 255, 0);
        blueSlider.setOrientation(Orientation.VERTICAL);
        blueBox.getChildren().addAll(new Label("B"), blueValue, blueSlider);
        // Combine Sliders
        colorBox.getChildren().addAll(redBox, greenBox, blueBox);
        // Color show box
        Pane colorPane = new Pane();
        colorPane.setMinWidth(50);
        Rectangle colorShow = new Rectangle();
        colorPane.getChildren().add(colorShow);
        colorShow.setX(0);
        colorShow.setY(0);
        colorShow.setWidth(70);
        colorShow.setHeight(35);
        colorShow.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
        // Filled checkbox
        CheckBox filledCheckbox = new CheckBox("Filled");
        // Combine checkbox, sliders, and color preview
        VBox colorOuterBox = new VBox(5);
        colorOuterBox.getChildren().addAll(filledCheckbox, colorBox, colorPane);

        // Canvas for drawing
        Canvas canvas = new Canvas(300, 300);

        // Box for center of screen
        BorderPane centerBox = new BorderPane();
        centerBox.setTop(shapeChooserBox);
        centerBox.setBottom(btnBox);
        centerBox.setRight(colorOuterBox);
        centerBox.setCenter(canvas);
        BorderPane.setMargin(centerBox, new Insets(5, 10, 5, 10));

        // Add centerBox to root
        root.setCenter(centerBox);

        // Add root scene to Stage
        Scene mainScene = new Scene(root);

        // Show Stage
        stage.setScene(mainScene);
        stage.show();

        // Event Handlers
            // Checkbox
        filledCheckbox.setOnAction((ActionEvent e) -> {filled.set(filledCheckbox.isSelected());});
            // Buttons
        exitBtn.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        undoBtn.setOnAction((ActionEvent e) -> {});
        clearBtn.setOnAction((ActionEvent e) -> {
            clear(redSlider, greenSlider, blueSlider, colorShow, filledCheckbox, filled, shapeChooser);
        });
            // Sliders
        redSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                redValue.setText(String.format("%d", newNum.intValue()));
                colorUpdater(redSlider, greenSlider, blueSlider, colorShow);
            }
        });
        greenSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                greenValue.setText(String.format("%d", newNum.intValue()));
                colorUpdater(redSlider, greenSlider, blueSlider, colorShow);
            }
        });
        blueSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                blueValue.setText(String.format("%d", newNum.intValue()));
                colorUpdater(redSlider, greenSlider, blueSlider, colorShow);
            }
        });

        // Draw events
        // Circle
        EventHandler<MouseEvent> drawShape = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent eventClick) {
                if (eventClick.getClickCount() > 1) {
                    GraphicsContext gc = canvas.getGraphicsContext2D();

                    // save initial X, Y values
                    double initX = eventClick.getX();
                    double initY = eventClick.getY();

                    // clear Canvas
                    gc.clearRect(0,0,300,300);

                    if (shapeChooser.getValue().equals("Circle")) {
                        // Create a Circle to pull info from
                        MyCircle circle = new MyCircle();

                        canvas.setOnMouseMoved(eventMove -> {
                            // Reset circle's radius based on mouse placement
                            double moveX = eventMove.getX();
                            double moveY = eventMove.getY();
                            double radius = Math.sqrt(((Math.abs(initX - moveX)) * (Math.abs(initX - moveX))) + ((Math.abs(initY - moveY) * (Math.abs(initY - moveY)))));

                            try {
                                circle.setRadius(radius);
                            } catch (InvalidRadiusException radEx) {
                                System.err.println(radEx.getMessage());
                                System.exit(1);
                            }

                            // Clear canvas
                            gc.clearRect(0, 0, 300, 300);

                            // Re-draw circle
                            if (filled.get()) { // If filled == true, fill in circle
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.fillOval(initX, initY, radius, radius);
                            } else { // If filled == false, draw outline only
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.strokeOval(initX, initY, radius, radius);
                            }

                            // TODO: remove mouse moved event handler
                            canvas.setOnMouseClicked(clickEvent -> {
                                System.out.println("Click"); // TODO: delete
                                System.out.println("This: " + this.toString());
                                canvas.removeEventHandler(MouseEvent.MOUSE_MOVED, this);
                            }); // End mouse cLick Event Handler
                        }); // End mouse moved Event Handler
                    } else if (shapeChooser.getValue().equals("Oval")) {
                        // Create MyOval
                        try {
                            MyOval oval = new MyOval(0, 0);
                        } catch (InvalidRadiusException radEx) {
                            System.err.println(radEx.getMessage());
                            System.exit(1);
                        }

                        canvas.setOnMouseMoved(eventMove -> {
                            // Create an Oval to pull information from
                            MyOval oval = new MyOval();
                            // Reset Oval's width and height based on mouse placement
                            double moveX = eventMove.getX();
                            double moveY = eventMove.getY();

                            double width = moveX - initX;
                            double height = moveY - initY;

                            // TODO: if width or height is <0, rotate and take absolute value


                            try {
                                oval.setWidth(width);
                                oval.setHeight(height);
                            } catch (InvalidRadiusException radEx) {
                                System.err.println(radEx.getMessage());
                                System.exit(1);
                            }

                            // Clear canvas
                            gc.clearRect(0, 0, 300, 300);

                            // Re-draw circle
                            if (filled.get()) { // If filled == true, fill in circle
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.fillOval(initX, initY, width, height);
                            } else { // If filled == false, draw outline only
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.strokeOval(initX, initY, width, height);
                            }

                            // TODO: remove mouse moved event handler
                            canvas.setOnMouseClicked(clickEvent -> {
                                System.out.println("Click"); // TODO: delete
                                System.out.println("This: " + this.toString()); // TODO: delete
                                canvas.removeEventHandler(MouseEvent.MOUSE_MOVED, this);
                            }); // End mouse cLick Event Handler
                        }); // End mouse moved Event Handler
                    } // End If/Else (shape)
                } // End If (double click)
            } // End handle Override
        }; // End drawCircle Event Handler

        // Oval
        EventHandler<MouseEvent> drawOval = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent eventClick) {
                if (eventClick.getClickCount() > 1) {
                    // set center point
                    double initX = eventClick.getX();
                    double initY = eventClick.getY();

                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    if (shapeChooser.getValue().equals("Circle")) {
                        // Clear canvas
                        gc.clearRect(0,0,300,300);

                        canvas.setOnMouseMoved(eventMove -> {
                            // Reset Oval's height and width based on mouse placement
                            double moveX = eventMove.getX();
                            double moveY = eventMove.getY();

                            // Clear canvas
                            gc.clearRect(0, 0, 300, 300);

                            // Re-draw circle
                            if (filled.get()) { // If filled == true, fill in circle
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.fillOval(initX, initY, Math.abs(initX - moveX), Math.abs(initY - moveY));
                            } else { // If filled == false, draw outline only
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.strokeOval(initX, initY, Math.abs(initX - moveX), Math.abs(initY - moveY));
                            }

                            // TODO: remove mouse moved event handler
                            canvas.setOnMouseClicked(clickEvent -> {
                                System.out.println("Click"); // TODO: delete
                                System.out.println("This: " + this.toString()); // TODO: delete
                                canvas.removeEventHandler(MouseEvent.MOUSE_MOVED, this);
                            }); // End mouse cLick Event Handler
                        }); // End mouse moved Event Handler
                    } // End If/Else (shape)
                } // End If (double click)
            } // End handle Override
        }; // End drawOval Event Handler

        // Initialize drawShape event handler
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, drawShape);
    } // end start method

    public void colorUpdater(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow) {
        int red = (int)redSlider.getValue();
        int green = (int)greenSlider.getValue();
        int blue = (int)blueSlider.getValue();

        colorShow.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
    } // end colorUpdater

    // Overloaded clear method
    public void clear(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow, CheckBox filledCheckbox, AtomicBoolean filled, ComboBox<String> shapeChooser) {
        // Reset color sliders
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);

        // Reset colorShow
        colorShow.setFill(Color.web("rgb(0, 0, 0)"));

        // Reset filled checkbox
        filledCheckbox.setSelected(false);
        filled.set(false);

        // Reset Shape Chooser
        shapeChooser.setValue("Circle");
    } // end clear
    public void clear(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow, CheckBox filledCheckbox, AtomicBoolean filled) {
        // Reset color Sliders
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);

        // Reset colorShow
        colorShow.setFill(Color.web("rgb(0, 0, 0)"));

        // Reset filled checkbox
        filledCheckbox.setSelected(false);
        filled.set(false);

    } // end clear
} // end program
