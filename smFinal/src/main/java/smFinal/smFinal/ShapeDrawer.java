// File name:   ShapeDrawer
// Written by:  Shades Meyers
// Description: A driver class for drawing shapes
// Challenges:  Getting shapes to have the right color (forgot to update rgb variables).
//              Removing an event handler.
// Time Spent:  9 h 03 min + 25 min
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-30    SM      File created
// 2024-May-01      SM      Continued first pass work
// 2024-May-02      SM      Continued first pass work
// 2024-May-03      SM      Continued first pass work
// 2024-May-05      SM      Fixed color drawing for shapes
//                          Continued first pass work


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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ShapeDrawer extends Application {
    // Variables
    int red = 255;
    int green = 255;
    int blue = 255;
    // Using Atomics instead of Boolean to get around a lamda issue
    AtomicBoolean filled = new AtomicBoolean(false);
    AtomicInteger lineWidth = new AtomicInteger(1);
    AtomicReference<Color> backgroundColor = new AtomicReference<>(Color.BLACK);

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
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

        // Textarea for bottom of page
        VBox bottonBox = new VBox(5);
        TextArea shapeInfo = new TextArea();
        shapeInfo.setEditable(false);
        bottonBox.getChildren().addAll(shapeInfo, btnBox);

        // Top box
        VBox topBox = new VBox(5);

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

        // Background picker
        HBox backgrounds = new HBox(5);
        ToggleGroup backgroundGroup = new ToggleGroup();
        RadioButton blackBackground = new RadioButton("Black");
        blackBackground.setToggleGroup(backgroundGroup);
        blackBackground.setSelected(true);
        RadioButton redBackground = new RadioButton("Red");
        redBackground.setToggleGroup(backgroundGroup);
        RadioButton blueBackground = new RadioButton("Blue");
        blueBackground.setToggleGroup(backgroundGroup);
        backgrounds.getChildren().addAll(blackBackground, redBackground, blueBackground);

        // lineThickness selector
        HBox lineBox = new HBox(5);
        ObservableList<String> lines = FXCollections.observableArrayList(
                "Small", "Medium", "Thick");
        ComboBox<String> lineThickness = new ComboBox<String>();
        lineThickness.setItems(lines);
        lineThickness.setValue("Small");
        lineBox.getChildren().addAll(new Label("Select Line Thickness: "), lineThickness);

        // Combine shapeChooser, backgroundChooser, and lineThickness into topBox
        topBox.getChildren().addAll(shapeChooserBox,backgrounds, lineBox);

        // Color chooser box
        HBox colorBox = new HBox(5);
        // Red slider
        VBox redBox = new VBox();
        Label redValue = new Label("0");
        redValue.setMinWidth(20);
        redValue.setAlignment(Pos.CENTER);
        Slider redSlider = new Slider(0, 255, 255);
        redSlider.setOrientation(Orientation.VERTICAL);
        redBox.getChildren().addAll(new Label("R"), redValue, redSlider);
        // Green slider
        VBox greenBox = new VBox();
        Label greenValue = new Label("0");
        greenValue.setMinWidth(20);
        greenValue.setAlignment(Pos.CENTER);
        Slider greenSlider = new Slider(0, 255, 255);
        greenSlider.setOrientation(Orientation.VERTICAL);
        greenBox.getChildren().addAll(new Label("G"), greenValue, greenSlider);
        // Blue slider
        VBox blueBox = new VBox();
        Label blueValue = new Label("0");
        blueValue.setMinWidth(20);
        blueValue.setAlignment(Pos.CENTER);
        Slider blueSlider = new Slider(0, 255, 255);
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
        centerBox.setTop(topBox);
        centerBox.setBottom(bottonBox);
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
        undoBtn.setOnAction((ActionEvent e) -> {
            GraphicsContext gcBtn = canvas.getGraphicsContext2D();
            gcBtn.clearRect(0,0,300,300);
            gcBtn.setFill(backgroundColor.get());
            gcBtn.fillRect(0, 0, 300, 300);
        });
        clearBtn.setOnAction((ActionEvent e) -> {
            clear(redSlider, greenSlider, blueSlider, colorShow, filledCheckbox, filled, blackBackground, lineThickness,
                    shapeInfo, shapeChooser);
        });
            // Combobox
        shapeChooser.setOnAction((ActionEvent e) -> {
            clear(redSlider, greenSlider, blueSlider, colorShow, filledCheckbox, filled, blackBackground, lineThickness,
                    shapeInfo);
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
            // Combo box - line thickness
        lineThickness.setOnAction((ActionEvent e) -> {
            if (lineThickness.getValue().equals("Small")) {
                lineWidth.set(1);
            } else if (lineThickness.getValue().equals("Medium")) {
                lineWidth.set(10);
            } else if (lineThickness.getValue().equals("Thick")) {
                lineWidth.set(25);
            }
        });
            // Radio buttons
        backgroundGroup.selectedToggleProperty().addListener((new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                // update canvas background
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.clearRect(0,0,300,300);
                if (newValue.toString().contains("Black")) {
                    backgroundColor.set(Color.BLACK);
                } else if (newValue.toString().contains("Red")) {
                    backgroundColor.set(Color.RED);
                } else if (newValue.toString().contains("Blue")) {
                    backgroundColor.set(Color.BLUE);
                }
                gc.setFill(backgroundColor.get());
                gc.fillRect(0, 0, 300, 300);
            }
        }));
            // Draw events
            // Mouse double click event
        EventHandler<MouseEvent> drawShape = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent eventClick) {
                if (eventClick.getClickCount() > 1) {
                    GraphicsContext gc = canvas.getGraphicsContext2D();

                    // save initial X, Y values
                    double initX = eventClick.getX();
                    double initY = eventClick.getY();

                    // Clear Canvas and reset background
                    gc.clearRect(0,0,300,300);
                    gc.setFill(backgroundColor.get());
                    gc.fillRect(0,0,300,300);

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
                                circle.setFilled(filled.get());
                                circle.setColor(red, green, blue);
                            } catch (InvalidRadiusException radEx) {
                                System.err.println(radEx.getMessage());
                                System.exit(1);
                            }

                            // Clear canvas
                            gc.clearRect(0, 0, 300, 300);
                            gc.setFill(backgroundColor.get());
                            gc.fillRect(0,0,300,300);

                            // determine far top point
                            double xVal = Math.min(initX, moveX);
                            // determine far left
                            double yVal = Math.min(initY, moveY);

                            // Re-draw circle
                            if (filled.get()) { // If filled == true, fill in circle
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.fillOval(xVal, yVal, radius, radius);
                            } else { // If filled == false, draw outline only
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.setLineWidth(lineWidth.get());
                                gc.strokeOval(xVal, yVal, radius, radius);
                            }

                            // update Textarea
                            shapeInfoUpdater(circle, shapeInfo, moveX, moveY);

                            // TODO: remove mouse moved event handler
                            canvas.setOnMouseClicked(clickEvent -> {
                                System.out.println("Click"); // TODO: delete
                                System.out.println("This: " + this.toString());
                                canvas.removeEventHandler(MouseEvent.MOUSE_MOVED, this);
                                }); // End mouse cLick Event Handler
                            }); // End mouse moved Event Handler
                    } else if (shapeChooser.getValue().equals("Oval")) {
                        // Create an Oval to pull information from
                        MyOval oval = new MyOval();

                        canvas.setOnMouseMoved(eventMove -> {
                            // Reset Oval's width and height based on mouse placement
                            double moveX = eventMove.getX();
                            double moveY = eventMove.getY();

                            double width = Math.abs(moveX - initX);
                            double height = Math.abs(moveY - initY);

                            try {
                                oval.setWidth(width);
                                oval.setHeight(height);
                            } catch (InvalidRadiusException radEx) {
                                System.err.println(radEx.getMessage());
                                System.exit(1);
                            }

                            // Clear canvas
                            gc.clearRect(0, 0, 300, 300);
                            gc.setFill(backgroundColor.get());
                            gc.fillRect(0,0,300,300);

                            // determine far top point
                            double xVal = Math.min(initX, moveX);
                            // determine far left
                            double yVal = Math.min(initY, moveY);

                            // Re-draw circle
                            if (filled.get()) { // If filled == true, fill in circle
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.fillOval(xVal, yVal, width, height);
                            } else { // If filled == false, draw outline only
                                gc.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                                gc.setLineWidth(lineWidth.get());
                                gc.strokeOval(xVal, yVal, width, height);
                            }

                            // Update Textarea
                            shapeInfoUpdater(oval, shapeInfo, moveX, moveY);

                            // TODO: remove mouse moved event handler
                            canvas.setOnMouseClicked(clickEvent -> {
                                System.out.println("Click"); // TODO: delete
                                System.out.println("This: " + this.toString()); // TODO: delete
                                canvas.removeEventHandler(MouseEvent.MOUSE_MOVED, this);
                            }); // End mouse cLick Event Handler
                        }); // End mouse moved Event Handler
                    } if (shapeChooser.getValue().equals("Square")) {
                      // TODO: draw a square
                    } if (shapeChooser.getValue().equals("Rectangle")) {
                        // TODO: draw a rectangle
                    } if (shapeChooser.getValue().equals("Line")) {
                        // TODO: draw a line
                    } // End If/Else (shape)
                } // End If (double click)
            } // End handle Override
        }; // End drawShape Event Handler

        // initialize background
        GraphicsContext gcInit = canvas.getGraphicsContext2D();
        gcInit.setFill(backgroundColor.get());
        gcInit.fillRect(0,0,300,300);

        // Initialize drawShape event handler
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, drawShape);
    } // end start method


    // Color preview updater
    public void colorUpdater(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow) {
        red = (int)redSlider.getValue();
        green = (int)greenSlider.getValue();
        blue = (int)blueSlider.getValue();

        colorShow.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
    } // end colorUpdater


    // Overloaded clear method
    public void clear(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow, CheckBox filledCheckbox,
                      AtomicBoolean filled, RadioButton backgroundRadio, ComboBox<String> lineThickness, TextArea textArea,
                      ComboBox<String> shapeChooser) {
        // Reset color sliders
        redSlider.setValue(255);
        greenSlider.setValue(255);
        blueSlider.setValue(255);

        // Reset colorShow
        colorShow.setFill(Color.web("rgb(255, 255, 255)"));

        // Reset filled checkbox
        filledCheckbox.setSelected(false);
        filled.set(false);

        // Reset Shape Chooser
        shapeChooser.setValue("Circle");

        // Reset background color
        backgroundRadio.setSelected(true);
        backgroundColor.set(Color.BLACK);

        // Reset line thickness
        lineThickness.setValue("Small");
        lineWidth.set(1);

        // Clear Textarea
        textArea.clear();
    } // end clear

    public void clear(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow, CheckBox filledCheckbox,
                      AtomicBoolean filled, RadioButton backgroundRadio, ComboBox<String> lineThickness,TextArea textArea) {
        // Reset color Sliders
        redSlider.setValue(255);
        greenSlider.setValue(255);
        blueSlider.setValue(255);

        // Reset colorShow
        colorShow.setFill(Color.web("rgb(255, 255, 255)"));

        // Reset filled checkbox
        filledCheckbox.setSelected(false);
        filled.set(false);

        // Reset background color
        backgroundRadio.setSelected(true);
        backgroundColor.set(Color.BLACK);

        // Reset line thickness
        lineThickness.setValue("Small");
        lineWidth.set(1);

        // Clear Textarea
        textArea.clear();
    } // end clear

    
    // Shape info updater
    public void shapeInfoUpdater(MyBoundedShape shape, TextArea textArea, double curX, double curY) {
        // Update textArea with shape info
        textArea.setText(String.format("Mouse X: %.1f\t\tY: %.1f%nInfo: %s%nHow to draw: %s%nArea: %.2f%nPerimeter: %.2f",
                curX,
                curY,
                shape.toString(),
                shape.howToDraw(),
                shape.getArea(),
                shape.getPerimeter()));
    } // end shapeInfoUpdater
} // end program
