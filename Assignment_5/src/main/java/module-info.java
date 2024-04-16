module assignment_5.assignment_5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens assignment_5.assignment_5 to javafx.fxml;
    exports assignment_5.assignment_5;
}