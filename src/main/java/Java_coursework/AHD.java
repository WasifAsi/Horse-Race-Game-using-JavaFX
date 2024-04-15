package Java_coursework;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AHD implements Initializable {

    @FXML
    private ChoiceBox<String> Group;
    @FXML
    private TextField ID;
    @FXML
    private TextField Jockey;
    @FXML
    private TextField Name;
    @FXML
    private TextField age;
    @FXML
    private TextField breed;
    @FXML
    private TextField races;
    @FXML
    private TextField wins;

    private String [] groups={"A","B","C","D"};
      int Age ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Group.getItems().addAll(groups);
    }

    public void submit(ActionEvent event) {
        Age =Integer.parseInt(age.getText());
        System.out.println(Age);

    }
}

