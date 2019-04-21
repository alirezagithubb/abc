package Golestan.Controller;

import Golestan.Main;
import Golestan.Model.Book;
import Golestan.Model.Lesson;
import Golestan.Model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StudentChooseUnitController {
    public TableView<Lesson> unitsTable;
    public TableColumn<Lesson, String> lessonCol;
    public TableColumn<Lesson, String> teacherCol;
    public TableColumn<Lesson, String> dayCol;
    public TableColumn<Lesson, String> dateCol;
    public TableColumn<Lesson, String> unitsCol;
    public TableColumn<Lesson, String> capacityCol;
    public TableColumn<Lesson, String> conditionCol;

    public void initialize() {
        for (int i = 0; i < Student.student.unitCondition.size() ; i++) {
            if(Student.student.unitCondition.get(i)){
                Lesson.lessons.get(i).condition = "NOT CHOOSED";
            }
            else{
                Lesson.lessons.get(i).condition = "CHOOSED";
            }
        }

        lessonCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        teacherCol.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        unitsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfUnits"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
        unitsTable.setItems(Lesson.lessons);
    }


    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/StudentHP.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void chooseUnit(MouseEvent mouseEvent) {
        Lesson temp = unitsTable.getSelectionModel().getSelectedItem();
        int index = Lesson.lessons.indexOf(temp);
        Lesson selectedLesson = Lesson.lessons.get(index);
        if (!Student.student.unitCondition.get(index)) {
            Lesson.lessons.get(index).students.add(Student.student.toString());
            Student.student.unitCondition.set(index , true);
            Student.student.lessonsChoiced.add(selectedLesson);
            Student.student.marks.add("-1");
            Lesson.lessons.get(index).condition = "CHOOSED";
            unitsTable.setItems(Lesson.lessons);
        }
        else{
            Student.student.unitCondition.set(index , false);
            Lesson.lessons.get(index).students.remove(Student.student.toString());
            Student.student.lessonsChoiced.remove(selectedLesson);
            Student.student.marks.remove(index);
            Lesson.lessons.get(index).condition = "NOT CHOOSED";
            unitsTable.setItems(Lesson.lessons);
        }
    }
}
