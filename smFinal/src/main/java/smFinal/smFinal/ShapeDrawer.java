// File name:   ShapeDrawer
// Written by:  Shades Meyers
// Description: A driver class for drawing shapes
// Challenges:
// Time Spent:  3 h, 09 min + 33 min
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-30    SM      File created


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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
        boolean filled = false;

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
        // Combine sliders and color preview
        VBox colorOuterBox = new VBox(5);
        colorOuterBox.getChildren().addAll(colorBox, colorPane);

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
            // Buttons
        exitBtn.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        undoBtn.setOnAction((ActionEvent e) -> {});
        clearBtn.setOnAction((ActionEvent e) -> {
            clear(redSlider, greenSlider, blueSlider, colorShow, shapeChooser);
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
            // Shape chooser
        shapeChooser.setOnAction((ActionEvent e) -> {
            clear(redSlider, greenSlider, blueSlider, colorShow);
        });

            // Mouse Events
        // TODO: fix this event handler
        canvas.setOnMouseClicked(eventClick -> {
            if (eventClick.getClickCount() > 1) {
                double initX = eventClick.getX();
                double initY = eventClick.getY();

                System.out.println(Double.toString(initX)); // TODO: delete
                System.out.println(Double.toString(initY)); // TODO: delete

                GraphicsContext gc = canvas.getGraphicsContext2D();
                if (shapeChooser.getValue().equals("Circle")) {
                    System.out.println("Circle chosen"); // TODO: delete
                    // TODO: clear canvas
                    gc.setFill(Color.WHITESMOKE);
                    // Create Circle with radius 0
                    Circle circle = new Circle(initX, initY, 25);
                    circle.setStrokeWidth(5);
                    circle.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));

                    gc.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                    gc.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());

                    //                if (filled) {
                    //                    circle.setStyle("-fx-fill: % ;".formatted(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue))));
                    //                }

                    canvas.setOnMouseMoved(eventMove -> {
                        // reset cirlce's radius based on mouse placement
                        double MoveX = eventMove.getX();
                        double MoveY = eventMove.getY();
                        double radius = Math.sqrt(((Math.abs(initX - MoveX)) * (Math.abs(initX - MoveX))) + ((Math.abs(initY - MoveY) * (Math.abs(initY - MoveY)))));
                        circle.setRadius(radius);

                        gc.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        gc.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());

                        System.out.println("Radius: " + radius); // TODO: delete

                        // TODO: remove event handler
//                         canvas.setOnMouseClicked(mouseClick -> {
//                             canvas.removeEventHandler(MouseEvent.MOUSE_CLICKED, this);
//
//                             System.out.println("Click"); // TODO: delete
//
//                             gc.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
//                             gc.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
//                         });
                    });
                }
            }
        });

    } // end start method

    public void colorUpdater(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow) {
        int red = (int)redSlider.getValue();
        int green = (int)greenSlider.getValue();
        int blue = (int)blueSlider.getValue();

        colorShow.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
    } // end colorUpdater

    // Overloaded clear method
    public void clear(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow, ComboBox<String> shapeChooser) {
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);

        colorShow.setFill(Color.web("rgb(0, 0, 0)"));

        shapeChooser.setValue("Circle");
    } // end clear
    public void clear(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow) {
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);

        colorShow.setFill(Color.web("rgb(0, 0, 0)"));
    } // end clear
} // end program
