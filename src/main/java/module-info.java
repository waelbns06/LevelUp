module com.example.levelup {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.levelup to javafx.fxml;
    opens com.example.levelup.model to javafx.base;

    exports com.example.levelup;
    exports com.example.levelup.model;
    exports com.example.levelup.repository;
    exports com.example.levelup.database;
}