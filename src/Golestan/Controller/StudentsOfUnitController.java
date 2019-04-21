package Golestan.Controller;

import Golestan.Model.Lesson;
import Golestan.Model.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class StudentsOfUnitController {
    public ListView<String> StudentsListView;
    public Button setMarkID;
    public TextField markField;
    public Label labelID;
    public Text studentNameText;
    private Student selectedStudent;
    private boolean MarkIsOK;

    public void initialize() {
        StudentsListView.setItems(Lesson.lessons.get(Lesson.index).students);
    }

    public void StudentClicked(MouseEvent mouseEvent) {
        setMarkID.setVisible(true);
        labelID.setVisible(true);
        studentNameText.setVisible(true);
        markField.setVisible(true);

        String[] data = StudentsListView.getSelectionModel().getSelectedItem().split("\\s");
        selectedStudent = null;
        for (int i = 0; i < Student.students.size(); i++) {
            if (data[0].equals(Student.students.get(i).username))
                selectedStudent = Student.students.get(i);
            break;
        }
        studentNameText.setText(selectedStudent.username);
    }

    public void setMark(ActionEvent actionEvent) {

        chackMarkField();
        if(!MarkIsOK){
            return;
        }
        selectedStudent.marks.set(Lesson.index, markField.getText());
        StudentsListView.setItems(Lesson.lessons.get(Lesson.index).students);
        MarkIsOK = false;
    }

    public void chackMarkField() {
        if (markField.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "type something!");
            alert.show();
            return;
        }
        try {
            Integer temp = Integer.parseInt(markField.getText());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "invalid mark number!");
            alert.show();
            return;
        }
        MarkIsOK = true;
    }

    public void reset() {
        setMarkID.setVisible(false);
        labelID.setVisible(false);
        studentNameText.setVisible(false);
        markField.setVisible(false);
    }
}
