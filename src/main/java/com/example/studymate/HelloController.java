package com.example.studymate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label signup;

    @FXML
    private Button login,signButton;


    @FXML
    protected void setSignupButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("signup-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }


    @FXML
    protected void setLoginButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }
}