package com.example.studymate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
        stage.setTitle("Study Mate");
//        Image logo = new Image("C:\\Users\\Septemberiya\\Documents\\JavaFxCode\\StudyMate\\src\\main\\resources\\com\\example\\studymate\\Study Mate.png");
//        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}