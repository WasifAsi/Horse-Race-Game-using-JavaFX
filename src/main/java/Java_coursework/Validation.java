package Java_coursework;

import java.util.ArrayList;

public class Validation {

    public static boolean AHD(String id, String name, String age, String wins, String races, String group, String breed, ArrayList<ArrayList> wholeHorses) {

        //
        if (id.isEmpty() || name.isEmpty() || age.isEmpty() || wins.isEmpty() || races.isEmpty() || group == null || breed.isEmpty()) {
            System.out.println("Blank fields are not allowed.");
            return false;
        }

        try {
            int Id = Integer.parseInt(id);
            int Age = Integer.parseInt(age);
            int Wins = Integer.parseInt(wins);
            int Races = Integer.parseInt(races);

            if (Age <= 0 || Wins < 0 || Races <= 0) {
                System.out.println("Invalid input values.");
                return false;
            }

            if (Wins > Races) {
                System.out.println("Wins cannot be greater than total races.");
                return false;
            }

            for (ArrayList horse : wholeHorses) {
                int old_Id = (int) horse.get(0);
                if (old_Id == Id) {
                    System.out.println("ID already exists. Change the ID.");
                    return false;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
            return false;
        }

        return true;
    }

    public static int UHD_ID_Check(int id, ArrayList<ArrayList<Object>> wholeHorses) {
        for (int i = 0; i < wholeHorses.size(); i++) {
            ArrayList<Object> horse = wholeHorses.get(i);
            int horseID = (int) horse.get(0);
            if (horseID == id) {
                return i;
            }
        }
        return -1;
    }

    public static boolean DHD_Id(int id, ArrayList<ArrayList> wholeHorses) {
        int indexToRemove = -1;
        for (int i = 0; i < wholeHorses.size(); i++) {
            ArrayList<Object> horse = wholeHorses.get(i);
            int horseID = (int) horse.get(0);
            if (horseID == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            wholeHorses.remove(indexToRemove);
            return true;
        }
        return false;
    }

    public static void bubbleSort_VHD(ArrayList<ArrayList<Object>> wholeHorses) {
        for (int i = 0; i < wholeHorses.size() - 1; i++) {
            for (int j = 0; j < wholeHorses.size() - i - 1; j++) {
                ArrayList<Object> horse1 = wholeHorses.get(j);
                ArrayList<Object> horse2 = wholeHorses.get(j + 1);

                // Compare the first elements of the horses
                int horse1FirstElement = (int) horse1.get(0);
                int horse2FirstElement = (int) horse2.get(0);

                if (horse1FirstElement > horse2FirstElement) {
                    // Swap the horses
                    wholeHorses.set(j, horse2);
                    wholeHorses.set(j + 1, horse1);
                }
            }
        }
        System.out.println(wholeHorses);
    }

}
