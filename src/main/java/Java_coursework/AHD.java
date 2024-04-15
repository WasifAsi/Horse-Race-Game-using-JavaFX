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
    private TextField ID, Jockey, Name, age, breed ,races, wins;

    private final String [] groups={"A","B","C","D"};
    int Age ;
    int Wins;
    int TotelRace ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Group.getItems().addAll(groups);
    }

    public void submit(ActionEvent event) {
        Age =Integer.parseInt(age.getText());
        Wins =Integer.parseInt(wins.getText());
        TotelRace =Integer.parseInt(races.getText());


        System.out.println(Age);
        System.out.println(Group);

    }
}

