package com.example.studymate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchPageController {


    @FXML
    private Button loginbutton, profileButton, searchButton, matesButton, studyreqButton, matesreqButton;

    @FXML
    private TextField searchMate;

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
        root = FXMLLoader.load(getClass().getResource("mates-request-working.fxml"));
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

    public void search(ActionEvent event) throws IOException{
        if(searchMate.getText().equals("Johan")){
            root = FXMLLoader.load(getClass().getResource("search-johan.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if(searchMate.getText().equals("Anna")){
            root = FXMLLoader.load(getClass().getResource("search-anna.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if(searchMate.getText().equals("Mike")){
            root = FXMLLoader.load(getClass().getResource("search-mike.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

}
