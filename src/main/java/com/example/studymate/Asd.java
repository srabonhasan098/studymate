package com.example.studymate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Asd implements Initializable {

    @FXML
    public Pane asdasd;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane newLoadedPane = null;
        try {
            newLoadedPane = FXMLLoader.load(getClass().getResource("asdasdasd.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        asdasd.getChildren().add(newLoadedPane);
    }
}
