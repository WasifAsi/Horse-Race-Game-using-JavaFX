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

        // Appending Horse Details and Horse IDs to Lists
        for (ArrayList<Object> horse : Adding_Horse.WholeHorses) {
            String group = horse.get(6).toString(); // Assuming horse details are at index 6
            String horseInfo = horse.toString(); // Convert horse details to string representation
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
        if (groupA.isEmpty() || groupB.isEmpty() || groupC.isEmpty() || groupD.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Groups");
            alert.setHeaderText("One or more groups are empty");
            alert.setContentText("Please make sure all groups have at least one horse before saving.");
            alert.showAndWait();
            return; // Stop further execution
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
                System.out.println("\nSuccessfully Saved");
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


                System.out.println("\nSuccessfully Saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
