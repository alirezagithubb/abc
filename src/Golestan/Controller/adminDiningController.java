package Golestan.Controller;

import Golestan.Main;
import Golestan.Model.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class adminDiningController {

    public TableView<Food> diningTable;
    public ChoiceBox<String> choiceBox;
    public TextField foodName;
    public TextField foodPrice;
    public TableColumn<Food,String> firstCol;
    public TableColumn<Food,String> secondCol;
    public TableColumn<Food,String> thirdCol;
    private boolean numberIsOk;

    public void initialize() {
        firstCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        secondCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        thirdCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        choiceBox.getItems().addAll("Saturday", "Sunday", "Monday", "Tuesday", "Wendsday");
    }


    public void addFood(ActionEvent actionEvent) {
        if (choiceBox.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Choose a day");
            alert.show();
            return;
        } else if (foodName.getText().length() == 0 || foodPrice.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Complete items");
            alert.show();
            return;
        }
        checkCredit();
        if(!numberIsOk){
            return;
        }
        Food.foods.add(new Food(foodName.getText(), foodPrice.getText(), choiceBox.getSelectionModel().getSelectedItem()));
        Food.diningPrices.add(Integer.parseInt(foodPrice.getText()));
        diningTable.setItems(Food.foods);
        numberIsOk = false;
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/AdminHP.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }


    public void checkCredit(){

        if(foodPrice.getText().charAt(0) == '-'){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Price is invalid!");
            alert.show();
            return;
        }
        try {
            Integer number = Integer.parseInt(foodPrice.getText());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Price is invalid!");
            alert.show();
            return;
        }
        numberIsOk = true;
    }
}
