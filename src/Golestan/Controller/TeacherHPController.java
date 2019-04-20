package Golestan.Controller;

import Golestan.Main;
import Golestan.Model.Admin;
import Golestan.Model.Student;
import Golestan.Model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class TeacherHPController {


    public Text variableText;
    public TextField textField;
    public Text password;
    public Text username;
    private boolean usernameChangeID;
    private boolean passwordChangeID;
    private boolean usernameIsOk;
    private boolean passwordIsOk;

    public void initialize() {
        username.setText(Teacher.teacher.username);
        password.setText(Teacher.teacher.password);
    }

    public void setChanges(ActionEvent actionEvent) {

        if (usernameChangeID) {
            checkUsername();
            if (usernameIsOk) {
                username.setText(textField.getText());
                Teacher.teacher.username = textField.getText();
                reset();
            }
            usernameIsOk = false;
            usernameChangeID = false;
        } else if (passwordChangeID) {
            checkPassword();
            if (passwordIsOk) {
                password.setText(textField.getText());
                Teacher.teacher.password = textField.getText();
                reset();
            }
            passwordIsOk = false;
            passwordChangeID = false;

        }

    }

    public void reset() {
        textField.setText("");
        textField.setVisible(false);
        variableText.setVisible(false);
    }

    public void checkUsername() {
        if (textField.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write something");
            alert.show();
            return;
        }
        if (textField.getText().equals(Admin.getAdmin().username)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Repeatitous");
            alert.show();
            return;
        }
        for (int i = 0; i < Student.students.size(); i++) {
            if (textField.getText().equals(Student.students.get(i).username)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Repeatitous");
                alert.show();
                return;
            }
        }
        for (int i = 0; i < Teacher.teachers.size(); i++) {
            if (textField.getText().equals(Teacher.teachers.get(i).username)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Repeatitous");
                alert.show();
                return;
            }
        }
        usernameIsOk = true;
    }

    public void checkPassword() {
        if (textField.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write something");
            alert.show();
            return;
        }
        if (textField.getText().length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "password length must be over 6");
            alert.show();
            return;
        }
        passwordIsOk = true;
    }

    public void changePassword(ActionEvent actionEvent) {
        textField.setVisible(true);
        variableText.setVisible(true);
        variableText.setText("Password chaning :)");
        passwordChangeID = true;
    }

    public void changeUsername(ActionEvent actionEvent) {
        textField.setVisible(true);
        variableText.setVisible(true);
        variableText.setText("Username chaning :)");
        usernameChangeID = true;
    }

    public void setUnits(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/TeacherSetUnit.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void seeUnits(ActionEvent actionEvent) throws IOException {
        Teacher.teacher.seeUnits = true;
        Parent root = FXMLLoader.load(getClass().getResource("../View/TeacherSetUnit.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/RegLog.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }
}
