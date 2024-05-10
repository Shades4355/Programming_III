module smFinal.smFinal{
        requires javafx.controls;
        requires javafx.fxml;
        requires java.desktop;
        


        opens smFinal.smFinal to javafx.fxml;
        exports smFinal.smFinal;
        }