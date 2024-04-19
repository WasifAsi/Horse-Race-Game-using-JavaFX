package Java_coursework;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save_Horses {

    public void save(ActionEvent event) {

        ArrayList<String> groupA = new ArrayList<>();
        ArrayList<String> groupB = new ArrayList<>();
        ArrayList<String> groupC = new ArrayList<>();
        ArrayList<String> groupD = new ArrayList<>();

        // Appending Horse Details to Lists
        for (ArrayList<Object> horse : Adding_Horse.WholeHorses) {
            String group = horse.get(6).toString(); // Group details are at index 6
            String horseInfo = horse.toString();
            switch (group) {
                case "A":
                    groupA.add(horseInfo);
                    break;
                case "B":
                    groupB.add(horseInfo);
                    break;
                case "C":
                    groupC.add(horseInfo);
                    break;
                case "D":
                    groupD.add(horseInfo);
                    break;
                default:
                    break;
            }
        }
// To Start the game at least 4 Horse Details from each group should be there.

// Checking for each group have or not at least one detail
        if (groupA.isEmpty() || groupB.isEmpty() || groupC.isEmpty() || groupD.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Groups");
            alert.setHeaderText("One or more groups are empty");
            alert.setContentText("Please make sure all groups have at least one horse before saving.");
            alert.showAndWait();

        }else {

            // Saving horse details according to the group in one Text file

            try (FileWriter file = new FileWriter("horse_details.txt")) {
                file.write("Group A\n");
                for (String horse : groupA) {
                    file.write(horse + "\n");
                }
                file.write("\nGroup B\n");
                for (String horse : groupB) {
                    file.write(horse + "\n");
                }
                file.write("\nGroup C\n");
                for (String horse : groupC) {
                    file.write(horse + "\n");
                }
                file.write("\nGroup D\n");
                for (String horse : groupD) {
                    file.write(horse + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                FileWriter fileA = new FileWriter("Group A horse_details.txt");
                for (String horse : groupA) {
                    fileA.write(horse + "\n");
                }
                fileA.close();


                FileWriter fileB = new FileWriter("Group B horse_details.txt");
                for (String horse : groupB) {
                    fileB.write(horse + "\n");
                }
                fileB.close();


                FileWriter fileC = new FileWriter("Group C horse_details.txt");
                for (String horse : groupC) {
                    fileC.write(horse + "\n");
                }
                fileC.close();


                FileWriter fileD = new FileWriter("Group D horse_details.txt");
                for (String horse : groupD) {
                    fileD.write(horse + "\n");
                }
                fileD.close();


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Saved");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Saved horse Details .");
                alert.showAndWait();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
