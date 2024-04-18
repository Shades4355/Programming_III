// File name:   ShapeChooser.java
// Written by:  Shades Meyers
// Description: Driver Application
// Challenges:
//
// Time Spent:  4 h 58 min + 1 h 04 min
//
// Revision history:
// Date:           By:     Action:
// -------------------------------
// 2024-April-11    SM      File created
// 2024-April-12    SM      Con't first pass work
// 2024-April-15    SM      Con't first pass work
// 2024-April-16    SM      SI help for removing 'package' statement
//                          Con't first pass work
// 2024-April-18    SM      Con't first pass work; MVP


package assignment_5.assignment_5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import  javax.swing.JOptionPane;


public class ShapeChooser extends Application {
    String color = "Black";
    boolean filled = false;
    MyBoundedShape shape;

    @Override
    public void start(Stage stage) throws IOException {
        // main box
        VBox root = new VBox();

        // add combo box
        ObservableList<String> shapes = FXCollections.observableArrayList(
                "Circle", "Rectangle", "Square", "Triangle");
        ComboBox<String> shapeChooser = new ComboBox<String>();
        shapeChooser.setItems(shapes);
        shapeChooser.setValue("Circle");

        // add HBox for label and combo box
        BorderPane shapeChooserBox = new BorderPane();
        Label selectLabel = new Label("Select a Geometric Object");
        shapeChooserBox.setLeft(selectLabel);
        shapeChooserBox.setRight(shapeChooser);

        // create buttons for bottom of main scene
        Button calcBtn = new Button("Calculate");
        Button clearBtn = new Button("Clear");
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction((ActionEvent e) -> {System.exit(0);});

        // add buttons to a Horizontal Box
        HBox bottomBtns = new HBox(10);
        bottomBtns.getChildren().addAll(calcBtn, clearBtn, exitBtn);
        bottomBtns.setAlignment(Pos.CENTER);

        // Input box
        BorderPane inputPane = new BorderPane();
        TitledPane inputScene = new TitledPane("Input Data", inputPane);
        inputScene.setCollapsible(true);
        inputScene.setAnimated(true);
        // radius slider
        BorderPane radiusBox = new BorderPane();
        Slider radiusSlider = new Slider(0.0, 30.0, 15.0);
        Label radiusReadout = new Label(String.format("%.1f", radiusSlider.valueProperty().doubleValue()));
        radiusSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                radiusReadout.setText(String.format("%.1f", newNum.doubleValue()));
            }
        });
        radiusBox.setLeft(new Label("Radius: "));
        radiusBox.setCenter(radiusReadout);
        radiusBox.setRight(radiusSlider);
        // input fields and labels
        // Width
        BorderPane inputWidth = new BorderPane();
        TextField widthField = new TextField();
        widthField.setAlignment(Pos.CENTER_RIGHT);
        inputWidth.setLeft(new Label("Width: "));
        inputWidth.setRight(widthField);
        widthField.setEditable(false);
        // TODO: greyout panel
        // Height
        BorderPane inputHeight = new BorderPane();
        TextField heightField = new TextField();
        heightField.setAlignment(Pos.CENTER_RIGHT);
        inputHeight.setLeft(new Label("Height: "));
        inputHeight.setRight(heightField);
        // TODO: editable = false; greyout panel
        // Side1
        BorderPane inputSide1 = new BorderPane();
        TextField side1Field = new TextField();
        side1Field.setAlignment(Pos.CENTER_RIGHT);
        inputSide1.setLeft(new Label("Side 1: "));
        inputSide1.setRight(side1Field);
        // TODO: editable = false; greyout panel
        // Side2
        BorderPane inputSide2 = new BorderPane();
        TextField side2Field = new TextField();
        side2Field.setAlignment(Pos.CENTER_RIGHT);
        inputSide2.setLeft(new Label("Side 2: "));
        inputSide2.setRight(side2Field);
        // TODO: editable = false; greyout panel
        // Side3
        BorderPane inputSide3 = new BorderPane();
        TextField side3Field = new TextField();
        side3Field.setAlignment(Pos.CENTER_RIGHT);
        inputSide3.setLeft(new Label("Side 3: "));
        inputSide3.setRight(side3Field);
        // TODO: editable = false; greyout panel
        // combine left side
        VBox inputLeftSide = new VBox();
        inputLeftSide.getChildren().addAll(radiusBox,
                inputWidth, inputHeight, inputSide1,
                inputSide2, inputSide3);
        // right side of input box
        VBox inputRightSide = new VBox(10);
        CheckBox filledCheckbox = new CheckBox("Filled");
        // radio group
        VBox radioBox = new VBox(15);
        ToggleGroup radioGroup = new ToggleGroup();
        RadioButton radioBlack = new RadioButton("Black");
        radioBlack.setSelected(true);
        radioBlack.setToggleGroup(radioGroup);
        RadioButton radioRed = new RadioButton("Red");
        radioRed.setToggleGroup(radioGroup);
        RadioButton radioGreen = new RadioButton("Green");
        radioGreen.setToggleGroup(radioGroup);
        RadioButton radioBlue = new RadioButton("Blue");
        radioBlue.setToggleGroup(radioGroup);
        radioBox.getChildren().addAll(radioBlack, radioRed, radioGreen, radioBlue);

        // combine checkbox with radio buttons
        inputRightSide.getChildren().addAll(filledCheckbox, radioBox);
        // add input labels, fields, and right side together
        inputPane.setLeft(inputLeftSide);
        inputPane.setRight(inputRightSide);

        // add result boxes
        VBox resultPane = new VBox();
        // add fields
        // Shape
        BorderPane shapeBox = new BorderPane();
        TextField shapeField = new TextField();
        shapeField.setEditable(false);
        Label shapeLabel = new Label("Shape: ");
        shapeBox.setLeft(shapeLabel);
        shapeBox.setCenter(shapeField);
        BorderPane.setAlignment(shapeField, Pos.CENTER_RIGHT);
        // Information
        BorderPane infoBox = new BorderPane();
        TextField infoField = new TextField();
        infoField.setEditable(false);
        Label infoLabel = new Label("Label: ");
        infoBox.setLeft(infoLabel);
        infoBox.setCenter(infoField);
        BorderPane.setAlignment(infoField, Pos.CENTER_RIGHT);
        // Area
        BorderPane areaBox = new BorderPane();
        TextField areaField = new TextField();
        areaField.setEditable(false);
        Label areaLabel = new Label("Area: ");
        areaBox.setLeft(areaLabel);
        areaBox.setCenter(areaField);
        BorderPane.setAlignment(areaField, Pos.CENTER_RIGHT);
        // Perimeter
        BorderPane perimeterBox = new BorderPane();
        TextField perimeterField = new TextField();
        perimeterField.setEditable(false);
        Label perimeterLabel = new Label("Perimeter: ");
        perimeterBox.setLeft(perimeterLabel);
        perimeterBox.setCenter(perimeterField);
        BorderPane.setAlignment(perimeterField, Pos.CENTER_RIGHT);

        // add text and label fields to resultPane
        resultPane.getChildren().addAll(shapeBox, infoBox, areaBox, perimeterBox);

        // create Results box; add resultPane to Results box
        TitledPane output = new TitledPane("Result:", resultPane);
        output.setCollapsible(false);
        output.setAnimated(false);

        // add boxes to main box
        root.getChildren().addAll(shapeChooserBox, inputScene, output, bottomBtns);

        // set title
        stage.setTitle("The Shape Chooser");

        // add root to mainScene
        Scene mainScene = new Scene(root, 350, 385);

        // add mainScene to stage and display
        stage.setScene(mainScene);
        stage.show();

        // Listeners and Events
        ArrayList<TextField> fieldList = new ArrayList<TextField>();
        fieldList.add(widthField);
        fieldList.add(heightField);
        fieldList.add(side1Field);
        fieldList.add(side2Field);
        fieldList.add(side3Field);
        fieldList.add(shapeField);
        fieldList.add(infoField);
        fieldList.add(areaField);
        fieldList.add(perimeterField);
        // event: clear button press
        clearBtn.setOnAction((ActionEvent e) -> clear(fieldList, radiusSlider));
        // event: shape chosen
        shapeChooser.setOnAction((ActionEvent e) -> {
            clear(fieldList, radiusSlider);
            radiusSlider.setValue(15.0);
            if (shapeChooser.getValue().equals("Circle")) {
                widthField.setEditable(false);
                widthField.setStyle("-fx-background-color: grey;");
                heightField.setEditable(false);
                heightField.setStyle("-fx-background-color: grey;");
                side1Field.setEditable(false);
                side1Field.setStyle("-fx-background-color: grey;");
                side2Field.setEditable(false);
                side2Field.setStyle("-fx-background-color: grey;");
                side3Field.setEditable(false);
                side3Field.setStyle("-fx-background-color: grey;");
            } else if (shapeChooser.getValue().equals("Rectangle")) {
                widthField.setEditable(true);
                widthField.setStyle("");
                heightField.setEditable(true);
                heightField.setStyle("");
                side1Field.setEditable(false);
                side1Field.setStyle("-fx-background-color: grey;");
                side2Field.setEditable(false);
                side2Field.setStyle("-fx-background-color: grey;");
                side3Field.setEditable(false);
                side3Field.setStyle("-fx-background-color: grey;");
            } else if (shapeChooser.getValue().equals("Square")) {
                widthField.setEditable(false);
                widthField.setStyle("-fx-background-color: grey;");
                heightField.setEditable(false);
                heightField.setStyle("-fx-background-color: grey;");
                side1Field.setEditable(true);
                side1Field.setStyle("");
                side2Field.setEditable(false);
                side2Field.setStyle("-fx-background-color: grey;");
                side3Field.setEditable(false);
                side3Field.setStyle("-fx-background-color: grey;");
            } else if (shapeChooser.getValue().equals("Triangle")) {
                widthField.setEditable(false);
                heightField.setEditable(false);
                side1Field.setEditable(true);
                side2Field.setEditable(true);
                side3Field.setEditable(true);
            } else {
                System.err.println("Combo Box error - invalid selection");
                System.exit(1);
            } // end if/else
        }); // end shapeChooser onAction
        // event: calculate button pressed
        calcBtn.setOnAction((ActionEvent e) -> {
            if (shapeChooser.getValue().equals("Circle")) {
                // create circle
                try {

                    shape = new MyCircle(radiusSlider.getValue(), color, filled);
                } catch (InvalidRadiusException exception) {
                    // this catch present to satisfy necessity of try/catch
                    // cannot be triggered based on current implementation
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    clear(fieldList, radiusSlider);
                }
            } else if (shapeChooser.getValue().equals("Rectangle")) {
                // create rectangle
                try {
                    shape = new MyRectangle(Double.parseDouble(widthField.getText()),
                            Double.parseDouble(heightField.getText()), color, filled);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Enter a numeric number");
                    clear(fieldList, radiusSlider);
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    clear(fieldList, radiusSlider);
                }
            } else if (shapeChooser.getValue().equals("Square")) {
                // create square
                try {
                    shape = new MySquare(Double.parseDouble(side1Field.getText()), color, filled);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Enter a numeric number");
                    clear(fieldList, radiusSlider);
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    clear(fieldList, radiusSlider);
                }
            } else if (shapeChooser.getValue().equals("Triangle")) {
                // todo: create triangle
                try {
                    shape = new MyTriangle(Double.parseDouble(side1Field.getText()),
                            Double.parseDouble(side2Field.getText()), Double.parseDouble(side3Field.getText()),
                            color, filled);
                } catch (IllegalTriangleException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    clear(fieldList, radiusSlider);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Enter a numeric number");
                    clear(fieldList, radiusSlider);
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    clear(fieldList, radiusSlider);
                }
            } // end if/else

            // show shape data
            if (shape != null) {
                shapeField.setText(shape.getShape());
                infoField.setText(shape.toString());
                areaField.setText(String.format("%.2f", shape.getArea()));
                perimeterField.setText(String.format("%.2f", shape.getPerimeter()));
            } // end If
        }); // end calcBtn onAction
        // event: checkbox toggled
        filledCheckbox.setOnAction((ActionEvent e) -> {filled = filledCheckbox.isSelected();}); // end checkbox onAction
        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldVal, Toggle newVal) {
                if (newVal.toString().contains("Black")) {
                    color = "Black";
                } else if (newVal.toString().contains("Red")) {
                    color = "Red";
                } else if (newVal.toString().contains("Green")) {
                    color = "Green";
                } else if (newVal.toString().contains("Blue")) {
                    color = "Blue";
                } else {
                    System.err.println("Select Toggle Property: " + newVal.toString());
                    System.exit(1);
                }
            }
        }); // end radioGroup listener
    } // end start function

    public void clear(ArrayList<TextField> array, Slider slider) {
        // set all fields to ""
        for(TextField item : array) {
            item.setText("");
        }
        // set slider to 15.0
        slider.setValue(15.0);
    }

    public static void main(String[] args) {
        launch();
    }
}
