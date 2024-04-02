module hellofx.hellofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens hellofx.hellofx to javafx.fxml;
    exports hellofx.hellofx;
}