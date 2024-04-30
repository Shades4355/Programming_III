module smFinal.smFinal{
        requires javafx.controls;
        requires javafx.fxml;
        


        opens smFinal.smFinal to javafx.fxml;
        exports smFinal.smFinal;
        }