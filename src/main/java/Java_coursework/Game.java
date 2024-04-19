package Java_coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game implements Initializable {
    @FXML
    private StackPane contentArea;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Loading  the initial scene
            loadFXML("start-menu.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void SHR(ActionEvent event) throws IOException {
        loadFXML("Select_Horses_Randomly.fxml");
    }

    public void SWH(ActionEvent event) throws IOException {
        loadFXML("Select_Winning_Horses.fxml");
    }

    public void VWH(ActionEvent event) throws IOException {
        loadFXML("Visualize_Winning_Horse.fxml");
    }

    private void loadFXML(String fxmlFileName) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource(fxmlFileName));
        contentArea.getChildren().clear();
        contentArea.getChildren().setAll(fxml);
    }
    public void exit(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Press OK to exit or Cancel to stay.");

        // Customizing the buttons in the alert dialog
        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, cancelButton);

        // Handling user's choice
        alert.showAndWait().ifPresent(response -> {
            if (response == okButton) {
                // Close the application
                Stage stage = (Stage) contentArea.getScene().getWindow();
                stage.close();
            }
        });
    }
}
