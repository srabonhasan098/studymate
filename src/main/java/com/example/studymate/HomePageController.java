package com.example.studymate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Utility.UserSession;
import javafx.stage.Stage;

public class HomePageController implements Initializable{

    @FXML
    public Label jUserName,jUserId,titleName;
    @FXML
    public Button btnProfile;

    Connection con = null;
    PreparedStatement ps = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showUserdata();
        showOtherUser();
    }

    public void showUserdata() {


        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymate", "root", "");

            String user_id = UserSession.getUser_id();

            String sql = "Select * from user where id="+user_id;
            ps = con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            if(rs.next())
            {
                String name = rs.getString("name");
                String id = rs.getString("student_id");
                jUserName.setText(name);
                jUserId.setText(id);
            }else{
                showError("Sorry...Something is not righ in showUserData");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showOtherUser(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymate", "root", "");

            String user_id = UserSession.getUser_id();

            String sql = "SELECT * FROM user WHERE id != "+ user_id+" ORDER BY RAND() LIMIT 1";
            ps = con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            if(rs.next())
            {
                String name = rs.getString("name");
                System.out.println(name);
                titleName.setText(name);

            }else{
                showError("Sorry...Something is not right in showOtherUser");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void skipUser(ActionEvent event) throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymate", "root", "");

            String user_id = UserSession.getUser_id();

            String sql = "SELECT * FROM user WHERE id != "+ user_id+" ORDER BY RAND() LIMIT 1";
            ps = con.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            if(rs.next())
            {
                String name = rs.getString("name");
                System.out.println(name);
                titleName.setText(name);

            }else{
                showError("Sorry...Something is not right in showOtherUser");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showError(String msg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        String s =msg;
        alert.setContentText(s);
        alert.show();
    }

    public void showInfo(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Success");
        String s =msg;
        alert.setContentText(s);
        alert.show();
    }

    public void goToBtnProfile(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("profile-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }

    public void goToBtnMates(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("mates-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }

    public void goToBtnSearch(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("search-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }

    public void goToBtnLogout(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("signup-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }
}
