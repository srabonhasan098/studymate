package com.example.studymate;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.searchModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class searchItemController implements Initializable {

    @FXML
    private Label availabletime;

    @FXML
    private Label expertise;

    @FXML
    private ImageView img;

    @FXML
    private Label name;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    private List<searchModel> searchs(){
        List<searchModel> ls = new ArrayList<>();
        searchModel searchmodel = new searchModel();

        searchmodel.setName("Aisha");
        searchmodel.setAvailabletime("4.00 Pm - 6.00 Pm");
        searchmodel.setExpertise("AI, Machine Learning");
        searchmodel.setImgsrc("/Images/girl.jpg");
        ls.add(searchmodel);

        searchmodel.setName("Sophia");
        searchmodel.setAvailabletime("3.00 Pm - 5.00 Pm");
        searchmodel.setExpertise("Data Structure, Machine Learning");
        searchmodel.setImgsrc("/Images/girl3.jpg");
        ls.add(searchmodel);

        return ls;
    }
}
