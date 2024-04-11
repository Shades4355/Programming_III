// File name:   ShapeChooser.java
// Written by:  Shades Meyers
// Description: Driver Application
// Challenges:
//
// Time Spent:  23 min +
//
// Revision history:
// Date:           By:     Action:
// -------------------------------
// 2024-April-11    SM      File created


package assignment_5.assignment_5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ShapeChooser extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // main box
        VBox root = new VBox();

        // add combo box
        ObservableList<String> shapes = FXCollections.observableArrayList("Circle", "Rectangle", "Square", "Triangle");
        ComboBox<String> shapeChooser = new ComboBox<String>();
        shapeChooser.setItems(shapes);

        // add HBox for label and combo box
        HBox shapeChooserBox = new HBox(10);
        Label shapeLabel = new Label("Select a Geometric Object");
        shapeLabel.setAlignment(Pos.CENTER_LEFT);
        shapeChooserBox.getChildren().addAll(shapeLabel, shapeChooser);

        // create buttons for bottom of main scene
        Button calcBtn = new Button("Calculate");
        Button clearBtn = new Button("Clear");
        Button exitBtn = new Button("Exit");

        // add buttons to a Horizontal Box
        HBox bottomBtns = new HBox();
        bottomBtns.getChildren().addAll(calcBtn, clearBtn, exitBtn);
        bottomBtns.setAlignment(Pos.CENTER);
        // TODO: needs more positional tweaking

        // Input box
        GridPane inputOrg = new GridPane();
        //inputOrg.setAlignment(Pos.CENTER);
        TitledPane inputScene = new TitledPane("Input Data", inputOrg);
        inputScene.setCollapsible(true);
        inputScene.setAnimated(true);

        // add result box
        GridPane outputOrg = new GridPane();
        TitledPane output = new TitledPane("Result:", outputOrg);
        output.setCollapsible(false);
        output.setAnimated(false);

        // add boxes to main box
        root.getChildren().addAll(shapeChooserBox, inputScene, output, bottomBtns);

        // set title
        stage.setTitle("The Shape Chooser");

        // add root to mainScene
        Scene mainScene = new Scene(root, 320, 240);

        // add mainScene to stage and display
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
