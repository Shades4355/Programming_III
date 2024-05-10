// File name:   ShapeDrawer
// Written by:  Shades Meyers
// Description: A driver class for drawing shapes
// Challenges:  Getting shapes to have the right color (forgot to update rgb variables).
//              Removing an event handler (unsolved).
// Time Spent:  12 h 10 min
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
// 2024-May-08      SM      Attended SI; could not solve removeEventHandler issue
// 2024-May-09      SM      Met with Pro. Yeung to discuss removeEventHandler
// 2024-May-10      SM      Refactored code; complete re-write of shape drawing


package smFinal.smFinal;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JOptionPane;


public class ShapeDrawer extends Application {
    // Variables
    int red = 255;
    int green = 255;
    int blue = 255;
    double curX, curY;
    // Using Atomics instead of Boolean to get around a lambda issue
    AtomicBoolean filled = new AtomicBoolean(false);
    AtomicInteger lineWidth = new AtomicInteger(1);
    AtomicReference<Color> backgroundColor = new AtomicReference<>(Color.BLACK);

    ArrayList<MyBoundedShape> shapeList = new ArrayList<MyBoundedShape>();
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
        VBox bottomBox = new VBox(5);
        TextArea shapeInfo = new TextArea();
        shapeInfo.setEditable(false);
        TextArea mouseCoords = new TextArea("");
        mouseCoords.setEditable(false);
        mouseCoords.setMaxHeight(15);
        bottomBox.getChildren().addAll(mouseCoords, shapeInfo, btnBox);

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
        TextField redValue = new TextField("255");
        redValue.setMaxWidth(40);
        redValue.setAlignment(Pos.CENTER);
        Slider redSlider = new Slider(0, 255, 255);
        redSlider.setOrientation(Orientation.VERTICAL);
        redBox.getChildren().addAll(new Label("R"), redValue, redSlider);
        // Green slider
        VBox greenBox = new VBox();
        TextField greenValue = new TextField("255");
        greenValue.setMaxWidth(40);
        greenValue.setAlignment(Pos.CENTER);
        Slider greenSlider = new Slider(0, 255, 255);
        greenSlider.setOrientation(Orientation.VERTICAL);
        greenBox.getChildren().addAll(new Label("G"), greenValue, greenSlider);
        // Blue slider
        VBox blueBox = new VBox();
        TextField blueValue = new TextField("255");
        blueValue.setMaxWidth(40);
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

        // Pane for drawings
        Pane canvas = new Pane();

        // Box for center of screen
        BorderPane centerBox = new BorderPane();
        centerBox.setTop(topBox);
        centerBox.setBottom(bottomBox);
        centerBox.setRight(colorOuterBox);
        centerBox.setCenter(canvas);
        BorderPane.setMargin(centerBox, new Insets(5, 10, 5, 10));

        // Add centerBox to root
        root.setCenter(centerBox);

        // Add root scene to Stage
        Scene mainScene = new Scene(root);

        // Show Stage
        stage.setScene(mainScene);
        stage.setTitle("Shape Drawer");
        stage.show();

        // Event Handlers
            // Checkbox
        filledCheckbox.setOnAction((ActionEvent e) -> {filled.set(filledCheckbox.isSelected());});
            // Buttons
        exitBtn.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        undoBtn.setOnAction((ActionEvent e) -> {
            if (!canvas.getChildren().isEmpty()) {
                canvas.getChildren().remove(canvas.getChildren().getLast());
                shapeList.removeLast();
                if (!shapeList.isEmpty()) {
                    shapeInfoUpdater(shapeList.getLast(), shapeInfo);
                } else {
                    shapeInfo.clear();
                }
            } else {
                clear(redSlider, greenSlider, blueSlider, colorShow, filledCheckbox, filled, blackBackground,
                        lineThickness, shapeInfo, mouseCoords, canvas, shapeChooser);
            }
        });
        clearBtn.setOnAction((ActionEvent e) -> {
            clear(redSlider, greenSlider, blueSlider, colorShow, filledCheckbox, filled, blackBackground, lineThickness,
                    shapeInfo, mouseCoords, canvas, shapeChooser);
        });
            // TextFields
        redValue.setOnAction(actionEvent -> {
            try {
                if (Integer.parseInt(redValue.getText()) <= 255 && Integer.parseInt(redValue.getText()) >= 0) {
                    redSlider.setValue(Integer.parseInt(redValue.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a number ranging from 0 to 255");
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Enter a integer number");
            }
        });
        greenValue.setOnAction(actionEvent -> {
            try {
                if (Integer.parseInt(greenValue.getText()) <= 255 && Integer.parseInt(greenValue.getText()) >= 0) {
                    greenSlider.setValue(Integer.parseInt(greenValue.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a number ranging from 0 to 255");
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Enter a integer number");
            }
        });
        blueValue.setOnAction(actionEvent -> {
            try {
                if (Integer.parseInt(blueValue.getText()) <= 255 && Integer.parseInt(blueValue.getText()) >= 0) {
                    blueSlider.setValue(Integer.parseInt(blueValue.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a number ranging from 0 to 255");
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Enter a integer number");
            }
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
                lineWidth.set(5);
            } else if (lineThickness.getValue().equals("Thick")) {
                lineWidth.set(10);
            }
        });
            // Radio buttons
        backgroundGroup.selectedToggleProperty().addListener((new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                // update canvas background
                if (newValue.toString().contains("Black")) {
                    backgroundColor.set(Color.BLACK);
                    canvas.setStyle("-fx-background-color: Black");
                } else if (newValue.toString().contains("Red")) {
                    backgroundColor.set(Color.RED);
                    canvas.setStyle("-fx-background-color: Red");
                } else if (newValue.toString().contains("Blue")) {
                    backgroundColor.set(Color.BLUE);
                    canvas.setStyle("-fx-background-color: Blue");
                }
            }
        }));
            // Mouse click/release event
        canvas.setOnMousePressed((MouseEvent mousePress) -> {
            // Save initial X, Y values
            double initX = mousePress.getX();
            double initY = mousePress.getY();

            canvas.setOnMouseClicked((MouseEvent mouseClick) -> {
                // Current X/Y positions
                double curX = mouseClick.getX();
                double curY = mouseClick.getY();

                // Find start points
                double xVal = Math.min(initX, curX);
                double yVal = Math.min(initY, curY);

                // Draw shapes
                if (shapeChooser.getValue().equals("Circle")) {
                    double radius = Math.sqrt(((Math.abs(initX - curX)) * (Math.abs(initX - curX)))
                            + ((Math.abs(initY - curY) * (Math.abs(initY - curY)))));

                    // Create a Circle to pull info from
                    MyCircle myCircle = new MyCircle();
                    try {
                        myCircle.setRadius(radius);
                        myCircle.setColor(red, green, blue);
                        myCircle.setFilled(filled.get());
                    } catch (InvalidRadiusException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        System.exit(2);
                    }

                    // add myCircle to shapeList
                    shapeList.add(myCircle);

                    // Draw Circle onscreen
                    Circle circle = new Circle(xVal, yVal, radius);
                    if (filled.get()) { // If filled == true, fill in shape
                        circle.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        circle.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                    } else { // If filled == false, draw outline only
                        circle.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        circle.setStrokeWidth(lineWidth.get());
                        circle.setFill(Color.TRANSPARENT);
                    }
                    // Add circle to canvas (pane)
                    canvas.getChildren().add(circle);
                    shapeInfoUpdater(myCircle, shapeInfo);
                } else if (shapeChooser.getValue().equals("Oval")) {
                    // Find width and height
                    double xRad = Math.abs(initX - curX);
                    double yRad = Math.abs(initY - curY);

                    // Create an Oval to pull info from
                    MyOval myOval = new MyOval();
                    try {
                        myOval.setWidth(xRad * 2);
                        myOval.setHeight(yRad * 2);
                        myOval.setColor(red, green, blue);
                        myOval.setFilled(filled.get());
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        System.exit(2);
                    }

                    // add myOval to shapeList
                    shapeList.add(myOval);

                    // Draw Oval onscreen
                    Ellipse oval = new Ellipse(xVal, yVal, xRad, yRad);
                    if (filled.get()) { // If filled == true, fill in shape
                        oval.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        oval.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                    } else { // If filled == false, draw outline only
                        oval.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        oval.setStrokeWidth(lineWidth.get());
                        oval.setFill(Color.TRANSPARENT);
                    }
                    // Add circle to canvas (pane)
                    canvas.getChildren().add(oval);
                    shapeInfoUpdater(myOval, shapeInfo);

                } else if (shapeChooser.getValue().equals("Square")) {
                    // Find side length
                    double side = Math.max(Math.abs(initX - curX), Math.abs(initY - curY));
                    // Create a Square to pull info from
                    MySquare mySquare = new MySquare();
                    try {
                        mySquare.setSide(side);
                        mySquare.setColor(red, green, blue);
                        mySquare.setFilled(filled.get());
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        System.exit(2);
                    }

                    // add mySquare to shapeList
                    shapeList.add(mySquare);

                    // Draw Square onscreen
                    Rectangle square = new Rectangle(xVal, yVal, side, side);
                    if (filled.get()) { // If filled == true, fill in shape
                        square.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        square.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                    } else { // If filled == false, draw outline only
                        square.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        square.setStrokeWidth(lineWidth.get());
                        square.setFill(Color.TRANSPARENT);
                    }
                    // Add circle to canvas (pane)
                    canvas.getChildren().add(square);
                    shapeInfoUpdater(mySquare, shapeInfo);
                } else if (shapeChooser.getValue().equals("Rectangle")) {
                    // Find width and Height
                    double width = Math.abs(initX - curX);
                    double height = Math.abs(initY - curY);

                    // Create a Rectangle to pull info from
                    MyRectangle myRectangle = new MyRectangle();
                    try {
                        myRectangle.setWidth(width);
                        myRectangle.setHeight(height);
                        myRectangle.setColor(red, green, blue);
                        myRectangle.setFilled(filled.get());
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        System.exit(2);
                    }

                    // add myRectangle to shapeList
                    shapeList.add(myRectangle);

                    // Draw Rectangle onscreen
                    Rectangle rectangle = new Rectangle(xVal, yVal, width, height);
                    if (filled.get()) { // If filled == true, fill in shape
                        rectangle.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        rectangle.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                    } else { // If filled == false, draw outline only
                        rectangle.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                        rectangle.setStrokeWidth(lineWidth.get());
                        rectangle.setFill(Color.TRANSPARENT);
                    }
                    // Add Rectangle to canvas (pane)
                    canvas.getChildren().add(rectangle);
                    shapeInfoUpdater(myRectangle, shapeInfo);
                } else if (shapeChooser.getValue().equals("Line")) {
                    // Find length
                    double absX = Math.abs(initX - curX);
                    double absY = Math.abs(initY - curY);
                    double len = Math.sqrt((absX * absX) + (absY * absY));

                    // Create a Line to pull info from
                    MyLine myLine = new MyLine();
                    try {
                        myLine.setLength(len);
                        myLine.setColor(red, green, blue);
                        myLine.setFilled(filled.get());
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        System.exit(2);
                    }

                    // add myLine to shapeList
                    shapeList.add(myLine);

                    // Draw Line onscreen
                    Line line = new Line(initX, initY, curX, curY);
                    line.setStroke(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
                    line.setStrokeWidth(lineWidth.get());

                    // Add Line to canvas (pane)
                    canvas.getChildren().add(line);
                    shapeInfoUpdater(myLine, shapeInfo);
                } else {
                    System.err.println("Error: shapeChooser error");
                } // End If/Else (Shapes)
            }); // End mose release event
        }); // End mouse press event
            // Mouse move event
        canvas.setOnMouseMoved(mouseMoved -> {
            curX = mouseMoved.getX();
            curY = mouseMoved.getY();
            mouseCoords.setText(String.format("Mouse: %.1f, %.1f", curX, curY));
        });

        // initialize background
        canvas.setStyle("-fx-background-color: Black");

    } // end start method


    // Color preview updater
    public void colorUpdater(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow) {
        red = (int)redSlider.getValue();
        green = (int)greenSlider.getValue();
        blue = (int)blueSlider.getValue();

        colorShow.setFill(Color.web("rgb(%d, %d, %d)".formatted(red, green, blue)));
    } // end colorUpdater


    // Clear method
    public void clear(Slider redSlider, Slider greenSlider, Slider blueSlider, Rectangle colorShow, CheckBox filledCheckbox,
                      AtomicBoolean filled, RadioButton backgroundRadio, ComboBox<String> lineThickness, TextArea textArea, TextArea mouseCoords, Pane canvas,
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
        mouseCoords.clear();

        // clear canvas (Pane)
        canvas.getChildren().removeAll(canvas.getChildren());
    } // end clear

    
    // Shape info updater
    public void shapeInfoUpdater(MyBoundedShape shape, TextArea textArea) {
        // Update textArea with shape info
        textArea.setText(String.format("Info: %s%nHow to draw: %s%nArea: %.2f%nPerimeter: %.2f",
                shape.toString(),
                shape.howToDraw(),
                shape.getArea(),
                shape.getPerimeter()));
    } // end shapeInfoUpdater
} // end program
