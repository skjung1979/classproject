module com.app.kkt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.kkt to javafx.fxml;
    exports com.app.kkt;
}