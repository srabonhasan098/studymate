package com.example.studymate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MatesPageController {


    @FXML
    private Button loginbutton, profileButton, searchButton, matesButton, studyreqButton, matesreqButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    /***
     switchToLoginPage is used to change a scene from another scene.
     Just copy the whole function (line 27 to 34) and change the function name and the location where you want to go.
     ***/
    @FXML
    public void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("profile-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToMates(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mates-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToSearch(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("search-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToStudyrequest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("study-request-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToMatesrequest(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mates-request-working.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudSetup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("study-request-setup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToStudSetup_1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("studey-request-setup-1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToStudSetup_2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("studey-request-setup-2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudSetup_3(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("studey-request-setup-3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudSetup_4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("studey-request-setup-4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudSetup_5(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("studey-request-setup-5.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
