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

public class signUpController {

    @FXML
    private Button loginButton,signupButton;


    @FXML
    protected void setLoginButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("login-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }


    @FXML
    protected void setSignupButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }
}
