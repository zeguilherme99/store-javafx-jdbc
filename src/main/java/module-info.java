module com.learning.storejavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;


    opens com.learning.storejavafxjdbc to javafx.fxml;
    exports com.learning.storejavafxjdbc;

    opens com.learning.storejavafxjdbc.model.entities to javafx.base;
    exports com.learning.storejavafxjdbc.model.entities;
}