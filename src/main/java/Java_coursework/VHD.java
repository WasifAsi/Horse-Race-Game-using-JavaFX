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
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VHD implements Initializable {

    @FXML
    private TableColumn<DataView, Integer> id;

    @FXML
    private TableColumn<DataView, String> name;

    @FXML
    private TableColumn<DataView, String> jockey;

    @FXML
    private TableColumn<DataView, Integer> age;

    @FXML
    private TableColumn<DataView, String> breed;

    @FXML
    private TableColumn<DataView, String> record;

    @FXML
    private TableColumn<DataView, String> group;

    @FXML
    private TableColumn<DataView, ImageView> image; // Changed from Image to image

    @FXML
    private TableView<DataView> table;

    private ObservableList<DataView> initialData = FXCollections.observableArrayList(); // Made it private

    private AHD ahd = new AHD(); // Made it private

    @FXML
    private void populateData() {
        for (ArrayList<Object> horse : ahd.WholeHorses) {
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

            DataView data = new DataView(ID, Name, Jockey, Age, Breed, Record, Group, pic);
            initialData.add(data);
        }
        table.setItems(initialData);
    }






    private void bubbleSortWholeHorses() {
        for (int i = 0; i < ahd.WholeHorses.size() - 1; i++) {
            for (int j = 0; j < ahd.WholeHorses.size() - i - 1; j++) {
                ArrayList<Object> horse1 = ahd.WholeHorses.get(j);
                ArrayList<Object> horse2 = ahd.WholeHorses.get(j + 1);

                // Compare the first elements of the horses
                int horse1FirstElement = (int) horse1.get(0);
                int horse2FirstElement = (int) horse2.get(0);

                if (horse1FirstElement > horse2FirstElement) {
                    // Swap the horses
                    ahd.WholeHorses.set(j, horse2);
                    ahd.WholeHorses.set(j + 1, horse1);
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id")); // Changed PropertyValueFactory<DataView, Integer>("id") to new PropertyValueFactory<>("id")
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        jockey.setCellValueFactory(new PropertyValueFactory<>("jockey"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        breed.setCellValueFactory(new PropertyValueFactory<>("breed"));
        record.setCellValueFactory(new PropertyValueFactory<>("record"));
        group.setCellValueFactory(new PropertyValueFactory<>("group"));
        image.setPrefWidth(80);
        image.setCellValueFactory(new PropertyValueFactory<>("image")); // Changed from Image to image





        bubbleSortWholeHorses();
        populateData();
    }
}
