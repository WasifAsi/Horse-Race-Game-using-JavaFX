package Java_coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.ResourceBundle;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {
    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("home.fxml"));
            contentArea.getChildren() .removeAll();
            contentArea.getChildren().setAll(fxml);

        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,ex);
        }

    }

    @FXML
    public void home(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void AHD(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("AHD.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void UHD(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("UHD.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void DHD(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("DHD.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void VHD(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("VHD.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    public void SHD(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("SHD.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void Start(ActionEvent actionEvent) throws IOException {



    }
}

//package Java_coursework;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.layout.StackPane;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class Controller implements Initializable {
//    @FXML
//    private StackPane contentArea;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            // Load the initial scene
//            loadFXML("home.fxml");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    @FXML
//    public void home(ActionEvent actionEvent) throws IOException {
//        loadFXML("home.fxml");
//    }
//
//    public void AHD(ActionEvent actionEvent) throws IOException {
//        loadFXML("AHD.fxml");
//    }
//
//    public void UHD(ActionEvent actionEvent) throws IOException {
//        loadFXML("UHD.fxml");
//    }
//
//    public void DHD(ActionEvent actionEvent) throws IOException {
//        loadFXML("DHD.fxml");
//    }
//
//    public void VHD(ActionEvent actionEvent) throws IOException {
//        loadFXML("VHD.fxml");
//    }
//
//    public void SHD(ActionEvent actionEvent) throws IOException {
//        loadFXML("SHD.fxml");
//    }
//
//    public void Start(ActionEvent actionEvent) throws IOException {
//        // Load the second scene when Start button is clicked
//        loadFXML("second_scene.fxml");
//    }
//
//    private void loadFXML(String fxmlFileName) throws IOException {
//        Parent fxml = FXMLLoader.load(getClass().getResource(fxmlFileName));
//        contentArea.getChildren().clear();
//        contentArea.getChildren().setAll(fxml);
//    }
//}
