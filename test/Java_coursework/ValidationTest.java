package Java_coursework;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {

// AHD Part
    //ID 1 IS there and checking with No blanks and NO duplication
    @Test
    public void AHDWithValidInput() {
        ArrayList<ArrayList> wholeHorses = new ArrayList<>();
        ArrayList<Object> horse1 = new ArrayList<>();
        horse1.add(1);
        wholeHorses.add(horse1);

        assertTrue(Validation.AHD("2", "HorseName", "5", "3", "10", "Group", "Breed", wholeHorses));
    }

    //ID 1 IS there and checking with blanks and NO duplication
    @Test
    public void AHDWithInvalidInput() {
        ArrayList<ArrayList> wholeHorses = new ArrayList<>();
        ArrayList<Object> horse1 = new ArrayList<>();
        horse1.add(1);
        wholeHorses.add(horse1);

        assertFalse(Validation.AHD("", "HorseName", "5", "3", "10", "Group", "Breed", wholeHorses));
    }

    //ID 1 IS there and checking with blanks and  duplication
    @Test
    public void testAHDId() {
        ArrayList<ArrayList> wholeHorses = new ArrayList<>();
        ArrayList<Object> horse1 = new ArrayList<>();
        horse1.add(1);
        wholeHorses.add(horse1);

        assertFalse(Validation.AHD("1", "HorseName", "5", "3", "10", "Group", "Breed", wholeHorses));
    }


//UHD Part
    @Test
    public void UHD_IDCheck_already_there() {
        ArrayList<ArrayList<Object>> wholeHorses = new ArrayList<>();
        ArrayList<Object> horse1 = new ArrayList<>();
        horse1.add(1);
        wholeHorses.add(horse1);

        assertEquals(0, Validation.UHD_ID_Check(1, wholeHorses));
    }

    @Test
    public void UHD_IDCheck_Not_there() {
        ArrayList<ArrayList<Object>> wholeHorses = new ArrayList<>();
        ArrayList<Object> horse1 = new ArrayList<>();
        horse1.add(1);
        wholeHorses.add(horse1);

        assertEquals(-1, Validation.UHD_ID_Check(2, wholeHorses));
    }


// DHD Part
    @Test
    public void testDHDId() {
        ArrayList<ArrayList> wholeHorses = new ArrayList<>();
        ArrayList<Object> horse = new ArrayList<>();
        horse.add(1);
        horse.add("Horse1");
        horse.add(5);
        horse.add(3);
        horse.add(5);
        horse.add("GroupA");
        horse.add("Breed1");
        wholeHorses.add(horse);

        assertTrue(Validation.DHD_Id(1, wholeHorses));
        assertEquals(0, wholeHorses.size());
    }

    @Test
    public void testDHDId_with_2() {
        ArrayList<ArrayList> wholeHorses = new ArrayList<>();
        ArrayList<Object> horse = new ArrayList<>();
        horse.add(1);
        horse.add("Horse1");
        horse.add(5);
        horse.add(3);
        horse.add(5);
        horse.add("GroupA");
        horse.add("Breed1");
        wholeHorses.add(horse);

        ArrayList<Object> horse2 = new ArrayList<>();
        horse2.add(1);
        horse2.add("Horse1");
        horse2.add(5);
        horse2.add(3);
        horse2.add(5);
        horse2.add("GroupA");
        horse2.add("Breed1");
        wholeHorses.add(horse2);

        assertTrue(Validation.DHD_Id(1, wholeHorses));
        assertEquals(1, wholeHorses.size());
    }

    @Test
    public void testBubbleSortWholeHorses() {
        // Create some sample horse details
        ArrayList<ArrayList<Object>> horses = new ArrayList<>();
        ArrayList<Object> horse1 = new ArrayList<>();
        horse1.add(3); // ID
        horse1.add("Horse1"); // Name
        horse1.add("Jockey1"); // Jockey

        horses.add(horse1);

        ArrayList<Object> horse2 = new ArrayList<>();
        horse2.add(1); // ID
        horse2.add("Horse2"); // Name
        horse2.add("Jockey2"); // Jockey

        horses.add(horse2);

        ArrayList<Object> horse3 = new ArrayList<>();
        horse3.add(2); // ID
        horse3.add("Horse3"); // Name
        horse3.add("Jockey3"); // Jockey

        horses.add(horse3);

        // USing BubbleShort
        Validation.bubbleSort_VHD(horses);

        // Expected order after sorting by ID
        ArrayList<Integer> expectedIds = new ArrayList<>();
        expectedIds.add(1);
        expectedIds.add(2);
        expectedIds.add(3);


        ArrayList<Integer> sortedIds = new ArrayList<>();
        for (ArrayList<Object> horse : horses) {
            sortedIds.add((int) horse.getFirst());
        }


        assertEquals(expectedIds, sortedIds);
    }


}
