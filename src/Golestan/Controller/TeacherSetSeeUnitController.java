package Golestan.Controller;

import Golestan.Main;
import Golestan.Model.Book;
import Golestan.Model.Lesson;
import Golestan.Model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class TeacherSetSeeUnitController {

    public TableColumn<Lesson, String> lessonCol;
    public TableColumn<Lesson, String> dayCol;
    public TableColumn<Lesson, String> dateCol;
    public TableColumn<Lesson, String> teacherCol;
    public TableColumn<Lesson, String> unitsCol;
    public TableColumn<Lesson, String> capacityCol;
    public ChoiceBox<String> dayChoiceBox;
    public ChoiceBox<String> dateChoiceBox;
    public ChoiceBox<String> classNameChoiceBox;
    public TextField unitsField;
    public TextField capacityField;
    public TableView<Lesson> lessonsTable;
    public Label unitText;
    public Label capacityText;
    public Button setButtonID;
    private boolean ItemsAreOk;

    public void initialize() {

        if(Teacher.teacher.seeUnits){
            UnVisibleFields();
            Teacher.teacher.seeUnits = false;
        }

        lessonCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        teacherCol.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        unitsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfUnits"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        dayChoiceBox.getItems().addAll("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday");
        dateChoiceBox.getItems().addAll("8 - 10", "10 - 12", "14 - 16");
        classNameChoiceBox.getItems().addAll("Math", "Phisics", "AP", "DS", "Literature" , "History");
    }

    public void UnVisibleFields() {
        setButtonID.setVisible(false);
        dayChoiceBox.setVisible(false);
        dateChoiceBox.setVisible(false);
        classNameChoiceBox.setVisible(false);
        unitsField.setVisible(false);
        capacityField.setVisible(false);
        unitText.setVisible(false);
        capacityText.setVisible(false);
    }
    public void reset() {
        setButtonID.setVisible(true);
        dayChoiceBox.setVisible(true);
        dateChoiceBox.setVisible(true);
        classNameChoiceBox.setVisible(true);
        unitsField.setVisible(true);
        capacityField.setVisible(true);
        unitText.setVisible(true);
        capacityText.setVisible(true);
    }


    public void setClass(ActionEvent actionEvent) {
        checkItems();
        if(!ItemsAreOk){
            return;
        }
        Lesson.lessons.add(new Lesson(classNameChoiceBox.getSelectionModel().getSelectedItem(),
                unitsField.getText(), dayChoiceBox.getSelectionModel().getSelectedItem(),
                dateChoiceBox.getSelectionModel().getSelectedItem(), Teacher.teacher.username,
                capacityField.getText()));
        lessonsTable.setItems(Lesson.lessons);

        ItemsAreOk = false;
    }

    public void checkItems() {
        if (unitsField.getText().length() == 0 || capacityField.getText().length() == 0 ||
        dayChoiceBox.getSelectionModel().isEmpty() ||dateChoiceBox.getSelectionModel().isEmpty()
        || classNameChoiceBox.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Complete items!");
            alert.show();
            return;
        }
        try{
            Integer integer = Integer.parseInt(unitsField.getText());
            Integer integer2 = Integer.parseInt(capacityField.getText());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Numbers!");
            alert.show();
            return;
        }
        ItemsAreOk = true;
    }

    public void back(ActionEvent actionEvent) throws IOException {
        reset();
        Parent root = FXMLLoader.load(getClass().getResource("../View/TeacherHP.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void seeStudentsOfThis(MouseEvent mouseEvent) {
        if(!Teacher.teacher.seeUnits){
            return;
        }
        Lesson temp = lessonsTable.getSelectionModel().getSelectedItem();

    }
}
