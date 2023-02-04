module com.learning.storejavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.learning.storejavafxjdbc to javafx.fxml;
    exports com.learning.storejavafxjdbc;
}