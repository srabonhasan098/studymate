package com.example.studymate;

import Utility.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUpController {

    @FXML
    private Button loginButton,signupButton;
    @FXML
    private TextField jName, jStudentId, jEmail, jPassword;

    @FXML
    ImageView imageView;

    Connection con = null;
    PreparedStatement ps = null;


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



        String name = jName.getText();
        String student_id = jStudentId.getText();
        String email = jEmail.getText();
        String password = jPassword.getText();

        if(validateIdcard(password) == false){
            showError("Enter right student id");
        }

        System.out.println(name+" "+student_id+" "+email+" "+password);

        signup(name,student_id,email,password);


        try{

            ResultSet rs;

            String sql = "Select * from user where student_id=? and password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, student_id);
            ps.setString(2, password);

            rs = ps.executeQuery();
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


//        Parent parent = FXMLLoader.load(getClass().getResource("home-page.fxml"));
//        Scene signupScene = new Scene(parent);
//        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        appStage.setScene(signupScene);
//        appStage.show();
    }

    public void signup(String name, String student_id, String email, String password){

        ResultSet rs;


        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studymate", "root", "");

//            System.out.println(name+" "+student_id+" "+email+" "+password);

            String query = "INSERT INTO user (name, student_id, email, password, start_time, end_time, address, dept) VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2,student_id);
            ps.setString(3,email);
            ps.setString(4,password);
            ps.setString(5,"");
            ps.setString(6,"");
            ps.setString(7,"");
            ps.setString(8,"");

            ps.execute();


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
