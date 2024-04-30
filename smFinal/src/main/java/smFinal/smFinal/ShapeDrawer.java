// File name:   ShapeDrawer
// Written by:  Shades Meyers
// Description: A driver class for drawing shapes
// Challenges:
// Time Spent:  72 min +
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
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
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

        // create root scene
        BorderPane root = new BorderPane();

        // create GUI
        // Buttons
        Button clearBtn = new Button("Clear");
        Button undoBtn = new Button("Undo");
        Button exitBtn = new Button("Exit");
        
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
        VBox colorOuterBox = new VBox(10);
        colorOuterBox.getChildren().addAll(colorBox, colorPane);

        // TODO: delete; exists for testing only
        root.setRight(colorOuterBox);

        // add root scene to Stage
        Scene mainScene = new Scene(root);

        // show Stage
        stage.setScene(mainScene);
        stage.show();

        // Event Handlers
            // Buttons
        exitBtn.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        undoBtn.setOnAction((ActionEvent e) -> {});
        clearBtn.setOnAction((ActionEvent e) -> {});
            // Sliders
        redSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                redValue.setText(String.format("%d", newNum.intValue()));
            }
        });
        greenSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                greenValue.setText(String.format("%d", newNum.intValue()));
            }
        });
        blueSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNum, Number newNum) {
                blueValue.setText(String.format("%d", newNum.intValue()));
            }
        });
            // Shape chooser
        shapeChooser.setOnAction((ActionEvent e) -> {});

            // Mouse Events

    } // end start method
} // end program
