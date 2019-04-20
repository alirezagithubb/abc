package Golestan.Controller;

import Golestan.Main;
import Golestan.Model.Admin;
import Golestan.Model.Student;
import Golestan.Model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.print.PaperSource;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdminHomePageController {

    public Text userNameText;
    public Text passwordText;
    public TextField changeUsernameField;
    public TextField changePasswordField;
    public ToggleGroup toggleGroup;

    public void initialize() {
        userNameText.setText(Admin.getAdmin().username);
        passwordText.setText(Admin.getAdmin().password);
    }


    public void changePassword(ActionEvent actionEvent) {
        if (changePasswordField.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write Something");
            alert.show();
            return;
        } else if (changePasswordField.getText().length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "password length must be over 6");
            alert.show();
            return;
        } else {
            Admin.getAdmin().password = changePasswordField.getText();
            passwordText.setText(changePasswordField.getText());
        }
        changePasswordField.setVisible(false);

    }

    public void changeUsername(ActionEvent actionEvent) {

        if (changeUsernameField.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write Something");
            alert.show();
            return;
        }
        if (changeUsernameField.getText().equals(Admin.getAdmin().username)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Repeatitous");
            alert.show();
            return;
        }
        for (int i = 0; i < Student.students.size(); i++) {
            if (changeUsernameField.getText().equals(Student.students.get(i).username)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Repeatitous");
                alert.show();
                return;
            }
        }
        for (int i = 0; i < Teacher.teachers.size(); i++) {
            if (changeUsernameField.getText().equals(Teacher.teachers.get(i).username)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Repeatitous");
                alert.show();
                return;
            }
        }

        Admin.getAdmin().username = changeUsernameField.getText();
        userNameText.setText(changeUsernameField.getText());
        changeUsernameField.setVisible(false);


    }

    public void changeUser(ActionEvent actionEvent) {
        changeUsernameField.setVisible(true);
    }

    public void changePass(ActionEvent actionEvent) {
        changePasswordField.setVisible(true);
    }

    public void diningSelected(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/AdminDiningg.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void librarySelected(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/AdminLibrary.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void teacherSelected(ActionEvent actionEvent) {
    }

    public void studentSelected(ActionEvent actionEvent) {
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/RegLog.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }
}
