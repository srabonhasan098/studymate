package com.example.studymate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

import Utility.UserSession;
import javafx.stage.Stage;

public class LogInController {

    public TextField jStudentId, jPassword;
    public Button btnLogin;


    @FXML
    protected void setSignupButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("login-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }


    public void Login(ActionEvent event) throws IOException{

        Connection con = null;
        PreparedStatement ps = null;

        String student_id = jStudentId.getText();
        String password = jPassword.getText();

        try{

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymate", "root", "");


            String sql = "Select * from user where student_id=? and password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, student_id);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String user_id = rs.getString("id");
                UserSession user = new UserSession(user_id);
                showInfo("Success");
                goToHomePage(event);
                HomePageController c = new HomePageController();


            }else {
                showError("User not found");
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

    public boolean validateIdcard(String student_id) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(student_id);
        if (m.find() && m.group().equals(student_id)) {
            return true;
        } else {
            return false;
        }
    }

    public void goToHomePage(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        Scene signupScene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(signupScene);
        appStage.show();
    }
}
