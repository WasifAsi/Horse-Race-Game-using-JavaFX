package Java_coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Update_Horse_Detail implements Initializable {

    @FXML
    private TextField age;

    @FXML
    private TextField breed;

    @FXML
    private ChoiceBox<String> group;

    @FXML
    private TextField id;

    @FXML
    private TextField jockey;

    @FXML
    private Label mylabel;

    @FXML
    private TextField name;

    @FXML
    private TextField races;

    @FXML
    private TextField wins;
    @FXML
    private ImageView horseImage ;

    private final String [] groups={"A","B","C","D"};
    int ID, Age ,Wins , TotalRace ;
    String Name , Jockey , Group , Breed ;

    int countA = 0;
    int countB = 0;
    int countC = 0;
    int countD = 0;

    private File selectedImageFile;
    private String imagePath;


    static int indexToUpdate = -1;


    Adding_Horse ahd = new Adding_Horse();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        group.getItems().addAll(groups);
    }

    public void Check(ActionEvent event) {
        try {
            ID = Integer.parseInt(id.getText());

            Boolean idExists = false;

            // Find the index of the horse with the given ID
            for (int i = 0; i < ahd.WholeHorses.size(); i++) {
                ArrayList<Object> horse = ahd.WholeHorses.get(i);
                int horseID = (int) horse.get(0);
                if (horseID == ID) {
                    idExists = true;
                    indexToUpdate = i;
                    break;
                }
            }

            if (idExists) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ID is there");
                alert.setHeaderText(null);
                alert.setContentText("Fill the bellow  details to update.");
                alert.showAndWait();
                System.out.println(ID);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No ID Founded");
                alert.setHeaderText(null);
                alert.setContentText("The ID You entered is Not there");
                alert.showAndWait();
                id.clear();
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong input / Blank");
            alert.setHeaderText(null);
            alert.setContentText("Input shoud be validated. \nDont leave Blank");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void submit(ActionEvent event) {
        GroupCount();
        try{
            Name = name.getText();
            Jockey = jockey.getText();
            Age = Integer.parseInt(age.getText());
            Breed = breed.getText();
            Wins = Integer.parseInt(wins.getText());
            TotalRace = Integer.parseInt(races.getText());
            Group = group.getValue();

            ArrayList<Object> horseDetails = ahd.WholeHorses.get(indexToUpdate);

            if (ahd.WholeHorses.size()<20) {

                if (Wins <= TotalRace) {
                    String raceRecord = Wins + " Wins in " + TotalRace + " races";


                    if (Group == "A"){
                        if (countA<5){
                            horseDetails.set(1,Name);
                            horseDetails.set(2,Jockey);
                            horseDetails.set(3,Age);
                            horseDetails.set(4,Breed);
                            horseDetails.set(5,raceRecord);
                            horseDetails.set(6,Group);
                            horseDetails.set(7,imagePath);

                        }else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Group A is Full");
                            alert.setHeaderText(null);
                            alert.setContentText("Only 5 horses for each group ");
                            alert.showAndWait();
                        }

                    }else if (Group == "B"){
                        if (countB<5){
                            horseDetails.set(1,Name);
                            horseDetails.set(2,Jockey);
                            horseDetails.set(3,Age);
                            horseDetails.set(4,Breed);
                            horseDetails.set(5,raceRecord);
                            horseDetails.set(6,Group);
                            horseDetails.set(7,imagePath);

                        }else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Group B is Full");
                            alert.setHeaderText(null);
                            alert.setContentText("Only 5 horses for each group ");
                            alert.showAndWait();
                        }

                    }else if (Group == "C"){
                        if (countC<5){
                            horseDetails.set(1,Name);
                            horseDetails.set(2,Jockey);
                            horseDetails.set(3,Age);
                            horseDetails.set(4,Breed);
                            horseDetails.set(5,raceRecord);
                            horseDetails.set(6,Group);
                            horseDetails.set(7,imagePath);

                        }else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Group C is Full");
                            alert.setHeaderText(null);
                            alert.setContentText("Only 5 horses for each group ");
                            alert.showAndWait();
                        }

                    }else if (Group == "D"){
                        if (countD<5){
                            horseDetails.set(1,Name);
                            horseDetails.set(2,Jockey);
                            horseDetails.set(3,Age);
                            horseDetails.set(4,Breed);
                            horseDetails.set(5,raceRecord);
                            horseDetails.set(6,Group);
                            horseDetails.set(7,imagePath);

                        }else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Group D is Full");
                            alert.setHeaderText(null);
                            alert.setContentText("Only 5 horses for each group ");
                            alert.showAndWait();
                        }
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Wrong input");
                    alert.setHeaderText(null);
                    alert.setContentText("Wins Can't be higher than Total Races.");
                    alert.showAndWait();
                }

            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Limit Reached");
                alert.setHeaderText(null);
                alert.setContentText("Already passed limit. \nMaximum 20 Horses can be addable .");
                alert.showAndWait();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Updated");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Updated horse Details .");
            alert.showAndWait();

            resetFields();


        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong input / Blank");
            alert.setHeaderText(null);
            alert.setContentText("Input shoud be validated. \nDont leave Blank");
            alert.showAndWait();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void onChooseImageClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        selectedImageFile = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        if (selectedImageFile != null) {
            try {
                Image image = new Image(new FileInputStream(selectedImageFile));
                horseImage.setImage(image);
                imagePath = selectedImageFile.getAbsolutePath();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    private void resetFields() {
        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;

        id.clear();
        age.clear();
        wins.clear();
        races.clear();
        name.clear();
        jockey.clear();
        breed.clear();
        group.getSelectionModel().clearSelection();
    }


    private void GroupCount(){
        for (ArrayList<Object> horse : ahd.WholeHorses) {
            String GROUP = (String) horse.get(6);


            if (GROUP== "A"){
                countA+=1;
            }else if (GROUP== "B"){
                countB+=1;
            }else if (GROUP== "C"){
                countC+=1;
            }else if (GROUP== "D"){
                countD+=1;
            }
        }
    }
}
