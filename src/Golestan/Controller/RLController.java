package Golestan.Controller;

import Golestan.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import Golestan.Model.*;

import java.io.IOException;
import java.util.Random;
import java.util.zip.ZipEntry;

public class RLController {
    public TextField usernameId;
    public PasswordField passId;
    public RadioButton teacherCheck;
    public RadioButton studentCheck;
    public RadioButton adminCheck;
    private ToggleGroup toggleGroup;

//kk
    public void initialize() {
        toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(teacherCheck, studentCheck, adminCheck);
    }

    public void register(ActionEvent actionEvent) {
        RadioButton selectedToggle = (RadioButton) toggleGroup.getSelectedToggle();
        if (selectedToggle == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "*userType* is not selected");
            alert.show();
            return;
        } else if (usernameId.getText().length() == 0 || passId.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "username or password is empty");
            alert.show();
            return;
        } else if (passId.getText().length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "password length must be over 6");
            alert.show();
            return;
        }

        if (Admin.getAdmin().username.equals(usernameId.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "repeating username");
            alert.show();
            return;
        }

        for (int i = 0; i < Teacher.teachers.size(); i++) {
            if (Teacher.teachers.get(i).username.equals(usernameId.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "repeating username");
                alert.show();
                return;
            }
        }
        for (int i = 0; i < Student.students.size(); i++) {
            if (Student.students.get(i).username.equals(usernameId)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "repeating username");
                alert.show();
                return;
            }
        }

        if (selectedToggle.getText().equals("teacher")) {
            Teacher teacher = new Teacher(usernameId.getText(), passId.getText());
            Teacher.teachers.add(teacher);
        } else if (selectedToggle.getText().equals("student")) {
            Student student = new Student(usernameId.getText(), passId.getText());
            makeCredit(student);
            Student.students.add(student);
        } else {
            Admin.getAdmin().setUP(usernameId.getText(), passId.getText());
        }
    }

    public void makeCredit(Student student) {
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            student.creditNumber += String.valueOf(random.nextInt(10));
        }
        student.creditPass = passId.getText();
    }

    public void login(ActionEvent actionEvent) throws IOException {
        RadioButton selectedToggle = (RadioButton) toggleGroup.getSelectedToggle();
        if (selectedToggle == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "user is not selected");
            alert.show();
            return;
        } else if (usernameId.getText().length() == 0 || passId.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "username or password is empty");
            alert.show();
            return;
        }

        if (usernameId.getText().equals(Admin.getAdmin().username)) {
            if (passId.getText().equals(Admin.getAdmin().password)) {
                Parent root = FXMLLoader.load(getClass().getResource("../View/AdminHP.fxml"));
                Main.ps.setScene(new Scene(root));
                return;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "password is wrong");
                alert.show();
                return;
            }
        }

        for (int i = 0; i < Student.students.size(); i++) {
            if (usernameId.getText().equals(Student.students.get(i).username)) {
                if (passId.getText().equals(Student.students.get(i).password)) {
                    Student.student = Student.students.get(i);
                    Parent root = FXMLLoader.load(getClass().getResource("../View/studentHP.fxml"));
                    Main.ps.setScene(new Scene(root));
                    return;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "password is wrong");
                    alert.show();
                    return;
                }
            }
        }
        for (int i = 0; i < Teacher.teachers.size(); i++) {
            if (usernameId.getText().equals(Teacher.teachers.get(i).username)) {
                if (passId.getText().equals(Teacher.teachers.get(i).password)) {
                    Teacher.teacher = Teacher.teachers.get(i);
                    Parent root = FXMLLoader.load(getClass().getResource("../View/TeacherHP.fxml"));
                    Main.ps.setScene(new Scene(root));
                    return;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "password is wrong");
                    alert.show();
                    return;
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR, "user not found");
        alert.show();
        return;
    }
}


