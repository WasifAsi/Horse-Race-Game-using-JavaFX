package Java_coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main_Layout.fxml"));
        Scene scene = new Scene(root, 900, 600);

        Image icon = new Image("/images.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Horse Game");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}