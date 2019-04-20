package Golestan.Controller;

import Golestan.Model.Food;
import Golestan.Model.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class StudentDiningController {
    public TableView<Food> diningTable;
    public TableColumn<Food, String> firstCol;
    public TableColumn<Food, String> secondCol;
    public TableColumn<Food, String> thirdCol;
    public Text credit;
    public CheckBox firstCheckBox = new CheckBox();
    public CheckBox secondCheckBox = new CheckBox();
    public CheckBox forthCheckBox = new CheckBox();
    public CheckBox fivthCheckBox = new CheckBox();
    public CheckBox thirdCheckBox = new CheckBox();
    public CheckBox[] checkBoxes = new CheckBox[5];
    {
        checkBoxes[0] = firstCheckBox;
        checkBoxes[1] = secondCheckBox;
        checkBoxes[2] = thirdCheckBox;
        checkBoxes[3] = forthCheckBox;
        checkBoxes[4] = fivthCheckBox;
    }

    public void initialize(){
        credit.setText(String.valueOf(Student.student.credit));
        for (int i = 0; i < checkBoxes.length ; i++) {
            if(Student.student.diningChoiceBox[i][0]){
                checkBoxes[i].setSelected(true);
            }
        }
        for (int i = 0; i < Food.foods.size() ; i++) {
            checkBoxes[i].setVisible(true);
        }
        firstCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        secondCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        thirdCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        diningTable.setItems(Food.foods);
    }

    public void chooseFood(ActionEvent actionEvent) {
        ////////chera dobare bayad in kare payinin ro anjam dedam akhe :(
        checkBoxes[0] = firstCheckBox;
        checkBoxes[1] = secondCheckBox;
        checkBoxes[2] = thirdCheckBox;
        checkBoxes[3] = forthCheckBox;
        checkBoxes[4] = fivthCheckBox;
        for (int i = 0; i < checkBoxes.length ; i++) {
            if(checkBoxes[i].isSelected() && !Student.student.diningChoiceBox[i][1]){
                if(Student.student.credit <= Food.diningPrices.get(i)) {
                    Student.student.credit -= Food.diningPrices.get(i);
                    Student.student.diningChoiceBox[i][1] = true;
                    Student.student.diningChoiceBox[i][0] = true;
                }
                else {
                    checkBoxes[i].setSelected(false);
                    Alert alert = new Alert(Alert.AlertType.ERROR,"credit is not enough!");
                    alert.show();
                    return;
                }
                credit.setText(String.valueOf(Student.student.credit));
            }
            else if(!checkBoxes[i].isSelected() && Student.student.diningChoiceBox[i][1]){
                Student.student.diningChoiceBox[i][1] = false;
                Student.student.diningChoiceBox[i][0] = false;
                Student.student.credit += Food.diningPrices.get(i);
                credit.setText(String.valueOf(Student.student.credit));
            }
        }
    }
}
