package Java_coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Select_Winning_Horses implements Initializable {

    @FXML
    private TableColumn<Selected_horseTime, Integer> id;

    @FXML
    private TableColumn<Selected_horseTime, String> name;

    @FXML
    private TableColumn<Selected_horseTime, String> jockey;

    @FXML
    private TableColumn<Selected_horseTime, Integer> age;

    @FXML
    private TableColumn<Selected_horseTime, String> breed;

    @FXML
    private TableColumn<Selected_horseTime, String> record;

    @FXML
    private TableColumn<Selected_horseTime, String> group;

    @FXML
    private TableColumn<Selected_horseTime, ImageView> image;

    @FXML
    private TableColumn<Selected_horseTime, Integer> time;

    @FXML
    private TableView<Selected_horseTime> table;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        jockey.setCellValueFactory(new PropertyValueFactory<>("jockey"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        breed.setCellValueFactory(new PropertyValueFactory<>("breed"));
        record.setCellValueFactory(new PropertyValueFactory<>("record"));
        group.setCellValueFactory(new PropertyValueFactory<>("group"));
        image.setPrefWidth(80);
        image.setCellValueFactory(new PropertyValueFactory<>("image")); // Changed from Image to image
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        Rand_time();

        bubbleSortSelectedHorses();

        populateData();
    }

    public void Rand_time(){
        Random rand = new Random();
        for (ArrayList horse: Select_Horses_Randomly.SelectedHorses){
            horse.add(rand.nextInt(10,90));
            System.out.println(horse);
        }
    }

    private void bubbleSortSelectedHorses() {
        for (int i = 0; i < Select_Horses_Randomly.SelectedHorses.size() - 1; i++) {
            for (int j = 0; j < Select_Horses_Randomly.SelectedHorses.size() - i - 1; j++) {
                ArrayList<Object> horse1 = Select_Horses_Randomly.SelectedHorses.get(j);
                ArrayList<Object> horse2 = Select_Horses_Randomly.SelectedHorses.get(j + 1);

                // Compare the first elements of the horses
                int horse1FirstElement = (int) horse1.get(8);
                int horse2FirstElement = (int) horse2.get(8);

                if (horse1FirstElement > horse2FirstElement) {
                    // Swap the horses
                    Select_Horses_Randomly.SelectedHorses.set(j, horse2);
                    Select_Horses_Randomly.SelectedHorses.set(j + 1, horse1);
                }
            }
        }
    }

    private ObservableList<Selected_horseTime> initialData = FXCollections.observableArrayList();

    private void populateData() {
        for (ArrayList<Object> horse : Select_Horses_Randomly.SelectedHorses) {
            int ID = (int) horse.get(0);
            String Name = (String) horse.get(1);
            String Jockey = (String) horse.get(2);
            int Age = (int) horse.get(3);
            String Breed = (String) horse.get(4);
            String Record = (String) horse.get(5);
            String Group = (String) horse.get(6);
            String ImagePath = (String) horse.get(7);


            // Load image from local file system
            ImageView pic = null;
            if (ImagePath != null && !ImagePath.isEmpty()) {
                File imageFile = new File(ImagePath);
                if (imageFile.exists()) {
                    Image image = new Image(imageFile.toURI().toString());
                    pic = new ImageView(image);
                    // Set maximum dimensions to resize the image
                    double maxWidth = 100; // Set your desired maximum width
                    double maxHeight = 100; // Set your desired maximum height
                    pic.setPreserveRatio(true);
                    pic.setFitWidth(maxWidth);
                    pic.setFitHeight(maxHeight);
                } else {
                    System.err.println("Image file does not exist: " + ImagePath);
                }
            }

            int time = (int) horse.get(8);

            Selected_horseTime data = new Selected_horseTime(ID, Name, Jockey, Age, Breed, Record, Group, pic,time);
            initialData.add(data);
        }
        table.setItems(initialData);
    }
}
