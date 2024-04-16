package Java_coursework;

import javafx.event.ActionEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SHD {

    public void save(ActionEvent event) {

        ArrayList<String> groupA = new ArrayList<>();
        ArrayList<String> groupB = new ArrayList<>();
        ArrayList<String> groupC = new ArrayList<>();
        ArrayList<String> groupD = new ArrayList<>();

        // Appending Horse Details and Horse IDs to Lists
        for (ArrayList<Object> horse : AHD.WholeHorses) {
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
    }

    public static void main(String[] args) {
        // Call the save method when required
        // SHD shd = new SHD();
        // shd.save(null);
    }
}
