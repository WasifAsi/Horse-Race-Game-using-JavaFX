package Java_coursework;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class Visualize_Winning_Horse implements Initializable {
    @FXML
    private BarChart<?, ?> barchart;

    int Time1, Time2, Time3,ID_1 ,ID_2 ,ID_3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GetData();

        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName("Time Taken");
        series1.getData().add(new XYChart.Data("ID "+Integer.toString(ID_1),Time1));
        series1.getData().add(new XYChart.Data("ID "+Integer.toString(ID_2),Time2));
        series1.getData().add(new XYChart.Data("ID "+Integer.toString(ID_3),Time3));

        barchart.getData().addAll(series1);

    }
    public void GetData(){
        try{
        ArrayList first = Select_Horses_Randomly.SelectedHorses.getFirst();
        ID_1= (int) first.get(0);
        Time1= (int) first.get(8);

        ArrayList second = Select_Horses_Randomly.SelectedHorses.get(1);
        ID_2 = (int) second.get(0);
        Time2 = (int) second.get(8);

        ArrayList third = Select_Horses_Randomly.SelectedHorses.get(2);
        ID_3 = (int) third.get(0);
        Time3 = (int) third.get(8);
        }catch (IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SHR First");
            alert.setHeaderText(null);
            alert.setContentText("At first Click Select Horses Randomly.\nThen CLick Select Winning Horses. ");
            alert.showAndWait();

        }catch (NoSuchElementException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("SHR First");
            alert.setHeaderText(null);
            alert.setContentText("At first Click Select Horses Randomly.\nThen CLick Select Winning Horses. ");
            alert.showAndWait();}

        catch (Exception e){
            System.out.println(e);
        }

    }
}
