// File name:   ShapeChooser.java
// Written by:  Shades Meyers
// Description: Driver Application
// Challenges:
//
// Time Spent:  23 min + 1 h 43 min + 1 h 16 min +
//
// Revision history:
// Date:           By:     Action:
// -------------------------------
// 2024-April-11    SM      File created
// 2024-April-12    SM      Con't first pass work
// 2024-April-15    SM      Con't first pass work


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


public class ShapeChooser extends Application {
    String color, strWidth, strHeight, strSide1, strSide2, strSide3;

    @Override
    public void start(Stage stage) throws IOException {
        // main box
        VBox root = new VBox();

        // add combo box
        ObservableList<String> shapes = FXCollections.observableArrayList("Circle", "Rectangle", "Square", "Triangle");
        ComboBox<String> shapeChooser = new ComboBox<String>();
        shapeChooser.setItems(shapes);
        shapeChooser.setValue("Circle");

        // add HBox for label and combo box
        BorderPane shapeChooserBox = new BorderPane();
        Label shapeLabel = new Label("Select a Geometric Object");
        shapeChooserBox.setLeft(shapeLabel);
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
        Label radiusReadout = new Label(Double.toString(radiusSlider.getValue()));
        radiusSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                radiusReadout.setText(String.format("%.1f", newNum.doubleValue()));
            }
        });
        radiusBox.setCenter(radiusReadout);
        radiusBox.setRight(radiusSlider);
        // input fields and labels
        // Width
        BorderPane inputWidth = new BorderPane();
        TextField widthField = new TextField();
        inputWidth.setLeft(new Label("Width: "));
        inputWidth.setRight(widthField);
        // Height
        BorderPane inputHeight = new BorderPane();
        TextField heightField = new TextField();
        inputHeight.setLeft(new Label("Height: "));
        inputHeight.setRight(heightField);
        // Side1
        BorderPane inputSide1 = new BorderPane();
        TextField side1Field = new TextField();
        inputSide1.setLeft(new Label("Side 1: "));
        inputSide1.setRight(side1Field);
        // Side2
        BorderPane inputSide2 = new BorderPane();
        TextField side2Field = new TextField();
        inputSide2.setLeft(new Label("Side 2: "));
        inputSide2.setRight(side2Field);
        // Side3
        BorderPane inputSide3 = new BorderPane();
        TextField side3Field = new TextField();
        inputSide3.setLeft(new Label("Side 3: "));
        inputSide3.setRight(side3Field);
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
        VBox outputOrg = new VBox();
        VBox textPane = new VBox();
        BorderPane resultPane = new BorderPane();
        // add Labels
        outputOrg.getChildren().addAll(new Label("Shape: "), new Label("Information: "),
                new Label("Area: "), new Label("Perimeter: "));
        // add fields
        TextField shapeField = new TextField();
        shapeField.setEditable(false);
        TextField infoField = new TextField();
        infoField.setEditable(false);
        TextField areaField = new TextField();
        areaField.setEditable(false);
        TextField perimeterField = new TextField();
        perimeterField.setEditable(false);
        // add text and label fields to boxes
        textPane.getChildren().addAll(shapeField, infoField, areaField, perimeterField);
        resultPane.setLeft(outputOrg);
        resultPane.setCenter(textPane);
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
    }


    public static void main(String[] args) {
        launch();
    }
}
