package Java_coursework;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
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


public class Adding_Horse implements Initializable {

    // FXML Variables
    @FXML
    private ChoiceBox<String> group;
    @FXML
    private TextField id;
    @FXML
    private TextField jockey;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField breed;
    @FXML
    private TextField races;
    @FXML
    private TextField wins;
    @FXML
    private ImageView horseImage;


    private final String [] groups={"A","B","C","D"};
    int ID, Age ,Wins , TotalRace ;
    String Name , Jockey , Group , Breed , raceRecord ;

    int countA = 0;
    int countB = 0;
    int countC = 0;
    int countD = 0;

    private String imagePath;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initializing Groups A,B,C,D in check box
        group.getItems().addAll(groups);
    }

    //Creating an Arraylist that contain all the details of horses and that arraylist can be access in all classes
    public  static  ArrayList<ArrayList> WholeHorses = new ArrayList<>();


    public void submit(ActionEvent event) {
        // Getting count of the group in the first
        GroupCount();

        try {
            ID = Integer.parseInt(id.getText());
            Name = name.getText();
            Jockey = jockey.getText();
            Age = Integer.parseInt(age.getText());
            Breed = breed.getText();
            Wins = Integer.parseInt(wins.getText());
            TotalRace = Integer.parseInt(races.getText());
            Group = group.getValue();


            boolean idExists = false;

            for (ArrayList horse : WholeHorses) {
                int id = (int) horse.getFirst();
                if (id == ID) {
                    idExists = true;
                    break;
                }
            }

            if (idExists) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ID is already there");
                alert.setHeaderText(null);
                alert.setContentText("Already that Given id is there.  \nChange the ID ...");
                alert.showAndWait();
            } else {
                if (WholeHorses.size()<20) {

                    if (Wins <= TotalRace) {
                        raceRecord = Wins + " Wins in " + TotalRace + " races";

                        if (!imagePath.isEmpty()) {

                            if (Group == "A") {
                                if (countA < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group, imagePath);
                                    resetFields();

                                } else {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("Group A is Full");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Only 5 horses for each group ");
                                    alert.showAndWait();
                                }

                            } else if (Group.equals("B")) {
                                if (countB < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group, imagePath);
                                    resetFields();
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("Group B is Full");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Only 5 horses for each group ");
                                    alert.showAndWait();
                                }

                            } else if (Group.equals("C")) {
                                if (countC < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group, imagePath);
                                    resetFields();

                                } else {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("Group C is Full");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Only 5 horses for each group ");
                                    alert.showAndWait();

                                }

                            } else if (Group.equals("D")) {
                                if (countD < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group, imagePath);
                                    resetFields();

                                } else {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setTitle("Group D is Full");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Only 5 horses for each group ");
                                    alert.showAndWait();
                                }
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
            }

        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong input / Blank");
            alert.setHeaderText(null);
            alert.setContentText("Input should be validated. \nDont leave Blank");
            alert.showAndWait();

        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Image or Group is not selected");
            alert.setHeaderText(null);
            alert.setContentText("Select Image or a Group that u missed ");
            alert.showAndWait();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void HorseList(int ID,String Name , String Jockey, int Age ,String Breed,
                           String raceRecord,String Group,String imagePath){

        ArrayList horseDetails = new ArrayList();

        horseDetails.add(ID);
        horseDetails.add(Name);
        horseDetails.add(Jockey);
        horseDetails.add(Age);
        horseDetails.add(Breed);
        horseDetails.add(raceRecord);
        horseDetails.add(Group);
        horseDetails.add(imagePath);

        WholeHorses.add(horseDetails);
    }


    @FXML
    public void onChooseImageClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedImageFile = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        if (selectedImageFile != null) {
            try {
                Image image = new Image(new FileInputStream(selectedImageFile));
                horseImage.setImage(image);
                imagePath = selectedImageFile.getAbsolutePath();
                System.out.println(imagePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetFields() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Submitted");
        alert.setHeaderText(null);
        alert.setContentText("Successfully Added horse Details .");
        alert.showAndWait();

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

        horseImage.setImage(null);
        imagePath = null;

    }

    private void GroupCount(){
        for (ArrayList<Object> horse : WholeHorses) {
            String GROUP = (String) horse.get(6);


            switch (GROUP) {
                case "A" :
                    countA += 1;
                    break;
                case "B" :
                    countB += 1;
                    break;
                case "C" :
                    countC += 1;
                    break;
                case "D" :
                    countD += 1;
                    break;
            }
        }
    }

}

