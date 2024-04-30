// File name:   ShapeChooser.java
// Written by:  Shades Meyers
// Description: Driver Application
// Challenges:  Struggled to figure out how to change the color of text
//
// Time Spent:  8 h 26 min
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
// 2024-April-19    SM      Visual formatting
// 2024-April-22    SM      Fine-tuning/tweaking
//                          Added overlooked functionality to clear()
//                          DRYed up code
//                          Figured out text colors
// 2024-April-23    SM      Switched howToDraw and toString methods
//                          Visual tweaking



package assignment_5.assignment_5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import  javax.swing.JOptionPane;


public class ShapeChooser extends Application {
    String color = "BLACK";
    boolean filled = false;
    MyBoundedShape shape;

    @Override
    public void start(Stage stage) throws IOException {
        // main box
        BorderPane root = new BorderPane();

        // add combo box
        ObservableList<String> shapes = FXCollections.observableArrayList(
                "Circle", "Rectangle", "Square", "Triangle");
        ComboBox<String> shapeChooser = new ComboBox<String>();
        shapeChooser.setItems(shapes);
        shapeChooser.setValue("Circle");

        // add box for label and combo box
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
        // Height
        BorderPane inputHeight = new BorderPane();
        TextField heightField = new TextField();
        heightField.setAlignment(Pos.CENTER_RIGHT);
        inputHeight.setLeft(new Label("Height: "));
        inputHeight.setRight(heightField);
        // Side1
        BorderPane inputSide1 = new BorderPane();
        TextField side1Field = new TextField();
        side1Field.setAlignment(Pos.CENTER_RIGHT);
        inputSide1.setLeft(new Label("Side 1: "));
        inputSide1.setRight(side1Field);
        // Side2
        BorderPane inputSide2 = new BorderPane();
        TextField side2Field = new TextField();
        side2Field.setAlignment(Pos.CENTER_RIGHT);
        inputSide2.setLeft(new Label("Side 2: "));
        inputSide2.setRight(side2Field);
        // Side3
        BorderPane inputSide3 = new BorderPane();
        TextField side3Field = new TextField();
        side3Field.setAlignment(Pos.CENTER_RIGHT);
        inputSide3.setLeft(new Label("Side 3: "));
        inputSide3.setRight(side3Field);
        // combine left side of input box
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
        radioBox.setStyle("-fx-border-color: Green; -fx-border-width: 3");

        // combine checkbox with radio buttons
        inputRightSide.getChildren().addAll(filledCheckbox, radioBox);
        // add input labels, fields, and right side together
        inputPane.setLeft(inputLeftSide);
        inputPane.setRight(inputRightSide);

        // add result boxes
        VBox resultPane = new VBox();
        resultPane.setStyle("-fx-background-color: #00cdcd;");
        // add fields
        // Shape
        BorderPane shapeBox = new BorderPane();
        TextField shapeField = new TextField();
        Label shapeLabel = new Label("Shape: ");
        shapeBox.setLeft(shapeLabel);
        shapeBox.setCenter(shapeField);
        BorderPane.setAlignment(shapeField, Pos.CENTER_RIGHT);
        BorderPane.setMargin(shapeLabel, new Insets(5, 5, 5, 30));
        // Information
        BorderPane infoBox = new BorderPane();
        TextField infoField = new TextField();
        Label infoLabel = new Label("Information: ");
        infoBox.setLeft(infoLabel);
        infoBox.setCenter(infoField);
        BorderPane.setAlignment(infoField, Pos.CENTER_RIGHT);
        BorderPane.setMargin(infoLabel, new Insets(5, 5, 5, 0));
        // Area
        BorderPane areaBox = new BorderPane();
        TextField areaField = new TextField();
        Label areaLabel = new Label("Area: ");
        areaBox.setLeft(areaLabel);
        areaBox.setCenter(areaField);
        BorderPane.setAlignment(areaField, Pos.CENTER_RIGHT);
        BorderPane.setMargin(areaLabel, new Insets(5, 5, 5, 37));
        // Perimeter
        BorderPane perimeterBox = new BorderPane();
        TextField perimeterField = new TextField();
        Label perimeterLabel = new Label("Perimeter: ");
        perimeterBox.setLeft(perimeterLabel);
        perimeterBox.setCenter(perimeterField);
        BorderPane.setAlignment(perimeterField, Pos.CENTER_RIGHT);
        BorderPane.setMargin(perimeterLabel, new Insets(5, 5, 5, 10));

        // add text and label fields to resultPane
        resultPane.getChildren().addAll(shapeBox, infoBox, areaBox, perimeterBox);

        // create Results box; add resultPane to Results box
        TitledPane output = new TitledPane("Result:", resultPane);
        output.setCollapsible(false);
        output.setAnimated(false);
        output.setStyle("-fx-border-color: Blue; -fx-border-width: 5;");

        // combine shapeChooserBox and inputScene into one box
        VBox topBox = new VBox();
        topBox.getChildren().addAll(shapeChooserBox, inputScene);

        // add boxes to main box
        root.setTop(topBox);
        root.setCenter(output);
        root.setBottom(bottomBtns);

        // set title
        stage.setTitle("The Shape Chooser");

        // add root to mainScene
        Scene mainScene = new Scene(root, 350, 415);

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
        clearBtn.setOnAction((ActionEvent e) -> clear(fieldList, radiusSlider, filledCheckbox, radioBlack, shapeChooser));
        // event: shape chosen
        shapeChooser.setOnAction((ActionEvent e) -> {
            clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
            radiusSlider.setValue(15.0);
            radiusSlider.setDisable(true);
            widthField.setEditable(false);
            widthField.setStyle("-fx-background-color: #E0E0E0; -fx-border-color: black;");
            heightField.setEditable(false);
            heightField.setStyle("-fx-background-color: #E0E0E0; -fx-border-color: black;");
            side1Field.setEditable(false);
            side1Field.setStyle("-fx-background-color: #E0E0E0; -fx-border-color: black;");
            side2Field.setEditable(false);
            side2Field.setStyle("-fx-background-color: #E0E0E0; -fx-border-color: black;");
            side3Field.setEditable(false);
            side3Field.setStyle("-fx-background-color: #E0E0E0; -fx-border-color: black;");
            if (shapeChooser.getValue().equals("Circle")) {
                radiusSlider.setDisable(false);
            } else if (shapeChooser.getValue().equals("Rectangle")) {
                widthField.setEditable(true);
                widthField.setStyle("");
                heightField.setEditable(true);
                heightField.setStyle("");
            } else if (shapeChooser.getValue().equals("Square")) {
                side1Field.setEditable(true);
                side1Field.setStyle("");
            } else if (shapeChooser.getValue().equals("Triangle")) {
                side1Field.setEditable(true);
                side1Field.setStyle("");
                side2Field.setEditable(true);
                side2Field.setStyle("");
                side3Field.setEditable(true);
                side3Field.setStyle("");
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
                    JOptionPane.showMessageDialog(null, exception);
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack, shapeChooser);
                }
            } else if (shapeChooser.getValue().equals("Rectangle")) {
                // create rectangle
                try {
                    shape = new MyRectangle(Double.parseDouble(widthField.getText()),
                            Double.parseDouble(heightField.getText()), color, filled);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Enter a numeric number");
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
                    shape = null;
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, "IllegalArgumentException: " + exception.getMessage());
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
                    shape = null;
                }
            } else if (shapeChooser.getValue().equals("Square")) {
                // create square
                try {
                    shape = new MySquare(Double.parseDouble(side1Field.getText()), color, filled);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Enter a numeric number");
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
                    shape = null;
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, "IllegalArgumentException: " + exception.getMessage());
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
                    shape = null;
                }
            } else if (shapeChooser.getValue().equals("Triangle")) {
                // create triangle
                try {
                    shape = new MyTriangle(Double.parseDouble(side1Field.getText()),
                            Double.parseDouble(side2Field.getText()), Double.parseDouble(side3Field.getText()),
                            color, filled);
                } catch (IllegalTriangleException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
                    shape = null;
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Enter a numeric number");
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
                    shape = null;
                } catch (IllegalArgumentException exception) {
                    JOptionPane.showMessageDialog(null, "IllegalArgumentException: " + exception.getMessage());
                    clear(fieldList, radiusSlider, filledCheckbox, radioBlack);
                    shape = null;
                } // end try/catch
            } // end if/else

            // show shape data
            if (shape != null) {
                shapeField.setText(shape.toString());
                infoField.setText(shape.howToDraw());
                infoField.setStyle("-fx-background-color: #E0E0E0; -fx-border-color: black; -fx-text-fill: %s;".formatted(color));
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
                    color = "BLACK";
                } else if (newVal.toString().contains("Red")) {
                    color = "RED";
                } else if (newVal.toString().contains("Green")) {
                    color = "GREEN";
                } else if (newVal.toString().contains("Blue")) {
                    color = "BLUE";
                } else {
                    System.err.println("Select Toggle Property: " + newVal.toString());
                    System.exit(1);
                }
            }
        }); // end radioGroup listener

        // clear() to set initial values; DRYs up code considerably
        clear(fieldList, radiusSlider, filledCheckbox, radioBlack, shapeChooser);
    } // end start function

    // overloaded clear()
    public void clear(ArrayList<TextField> array, Slider slider, CheckBox checkbox, RadioButton radioButton, ComboBox<String> shapeSelector) {
        // set all fields to ""
        for (TextField item : array) {
            item.setText("");
            item.setEditable(false);
            item.setStyle("-fx-background-color: #E0E0E0; -fx-border-color: black;");
        }
        // set slider to 15.0 and unlocked
        slider.setValue(15.0);
        slider.setDisable(false);

        // uncheck filled
        checkbox.setSelected(false);
        filled = false;

        // reset color to black
        radioButton.setSelected(true);
        color = "BLACK";

        // reset combobox to circle
        shapeSelector.setValue("Circle");
    }

    public void clear(ArrayList<TextField> array, Slider slider, CheckBox checkbox, RadioButton radioButton) {
        // set all fields to ""
        for (TextField item : array) {
            item.setText("");
        }
        // set slider to 15.0
        slider.setValue(15.0);

        // uncheck filled
        checkbox.setSelected(false);
        filled = false;

        // reset color to black
        radioButton.setSelected(true);
        color = "BLACK";
    }
    public static void main(String[] args) {
        launch();
    }
}
