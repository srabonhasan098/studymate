module com.example.studymate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.studymate to javafx.fxml;
    exports com.example.studymate;
}