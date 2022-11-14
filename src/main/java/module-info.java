module com.example.studymate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studymate to javafx.fxml;
    exports com.example.studymate;
}