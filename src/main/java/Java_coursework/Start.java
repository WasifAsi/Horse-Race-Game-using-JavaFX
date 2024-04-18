package Java_coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Start {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static ArrayList GroupA = new ArrayList();
    public static ArrayList GroupB = new ArrayList();
    public static ArrayList GroupC = new ArrayList();
    public static ArrayList GroupD = new ArrayList();


    @FXML
    public void Start_Game(ActionEvent event) throws IOException {
        ReadGA();
        ReadGB();
        ReadGC();
        ReadGD();

        if(GroupA.isEmpty() || GroupB.isEmpty() || GroupC.isEmpty() || GroupD.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Group or more Groups null");
            alert.setHeaderText(null);
            alert.setContentText("Check All the the groups. \n Each Group must have at least one Horse detail.");
            alert.showAndWait();

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Alert");
            alert.setHeaderText("Can not Go Back");
            alert.setContentText("You Can not go back to the previous page ");
            alert.showAndWait();

            root = FXMLLoader.load(getClass().getResource("Game.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }


    public  void ReadGA() {
        try {
            String fileName = "Group A horse_details.txt";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                GroupA.add(line);                       // Add each line to the list
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        for (Object horses : GroupA) {
            System.out.println(horses);
        }

    }

    public  void ReadGB() {


        try {
            String fileName = "Group B horse_details.txt";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                GroupB.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object horses : GroupB) {
            System.out.println(horses);
        }
    }

    public  void ReadGC() {

        try  {
            String fileName = "Group C horse_details.txt";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                GroupC.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object horses : GroupC) {
            System.out.println(horses);
        }
    }

    public  void ReadGD() {
        String fileName = "Group D horse_details.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                GroupD.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object horses : GroupD) {
            System.out.println(horses);
        };
    }
}