package Java_coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Delete_Horse {

    @FXML
    private TextField id;

    int ID;


    public void Delete(ActionEvent event) {
        try {
            ID = Integer.parseInt(id.getText());

            boolean idExists = false;
            int indexToRemove = -1;

            // Find the index of the horse with the given ID
            for (int i = 0; i < Adding_Horse.WholeHorses.size(); i++) {
                ArrayList horse = Adding_Horse.WholeHorses.get(i);
                int horseID = (int) horse.getFirst();
                if (horseID == ID) {
                    idExists = true;
                    indexToRemove = i;
                    break;
                }
            }

            if (idExists) {
                // Remove the horse entry from the ArrayList
                Adding_Horse.WholeHorses.remove(indexToRemove);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ID is there");
                alert.setHeaderText(null);
                alert.setContentText("Horse with ID " + ID + " has been deleted.");
                alert.showAndWait();
                id.clear();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No ID Found");
                alert.setHeaderText(null);
                alert.setContentText("The ID you entered was not found.");
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
            System.out.println("error Occured");
        }
    }
}
