package Golestan.Controller;

import Golestan.Main;
import Golestan.Model.Admin;
import Golestan.Model.Student;
import Golestan.Model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class StudentHomePageController {

    public Text username;
    public Text password;
    public Text credit;
    public Text average;
    public TextField textField;
    public Text variableText;
    public boolean usernameChangeID;
    public boolean passwordChangeID;
    public boolean creditIncreasingID;
    public boolean usernameIsOk;
    public boolean passwordIsOk;
    public boolean numberIsOk;
    public TextField creditNum;
    public TextField creditPass;
    public boolean creditInformationIsOk;
    public Label creditNumText;
    public Label creditPassText;


    public void initialize() {
        username.setText(Student.student.username);
        password.setText(Student.student.password);
        credit.setText(String.valueOf(Student.student.credit));
        average.setText(String.valueOf(Student.student.average));
    }

    public void dining(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/studentDining.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void library(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/studentLibrary.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }

    public void units(ActionEvent actionEvent) {
    }

    public void changeUsername(ActionEvent actionEvent) {
        textField.setVisible(true);
        variableText.setVisible(true);
        variableText.setText("Username chaning :)");
        usernameChangeID = true;

    }

    public void changePassword(ActionEvent actionEvent) {
        textField.setVisible(true);
        variableText.setVisible(true);
        variableText.setText("Password chaning :)");
        passwordChangeID = true;
    }

    public void increseCredit(ActionEvent actionEvent) {

        creditNum.setVisible(true);
        creditPass.setVisible(true);
        creditNumText.setVisible(true);
        creditPassText.setVisible(true);

        textField.setVisible(true);
        variableText.setVisible(true);
        variableText.setText("Credit increasing :)");
        creditIncreasingID = true;
    }

    public void setChanges(ActionEvent actionEvent) {
        if (usernameChangeID) {
            checkUsername();
            if (usernameIsOk) {
                username.setText(textField.getText());
                Student.student.username = textField.getText();
                reset();
            }
            usernameIsOk = false;
            usernameChangeID = false;
        } else if (passwordChangeID) {
            checkPassword();
            if (passwordIsOk) {
                password.setText(textField.getText());
                Student.student.password = textField.getText();
                reset();
            }
            passwordIsOk = false;
            passwordChangeID = false;
        } else {

            checkCreditInformation();
            if (!creditInformationIsOk) {
                return;
            }
            checkCredit();
            if (numberIsOk) {
                Student.student.credit += Integer.parseInt(textField.getText());
                credit.setText(String.valueOf(Student.student.credit));
                reset();
            }
            numberIsOk = false;
            creditIncreasingID = false;
            creditInformationIsOk = false;

            creditNum.setVisible(false);
            creditPass.setVisible(false);
            creditNumText.setVisible(false);
            creditPassText.setVisible(false);
        }
    }

    public boolean checkCreditInformation() {
        if (creditNum.getText().length() == 0 || creditPass.getText().length() == 0 ||
                !(creditNum.getText().equals(Student.student.creditNumber)) ||
                !(creditPass.getText().equals(Student.student.creditPass))) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Credit Information are invalid!");
            alert.show();
            return true;
        }
        creditInformationIsOk = true;
        return false;
    }

    public void reset() {
        textField.setText("");
        textField.setVisible(false);
        variableText.setVisible(false);
    }

    public void checkCredit() {
        if (textField.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Write something!");
            alert.show();
            return;
        } else if (textField.getText().charAt(0) == '-') {
            Alert alert = new Alert(Alert.AlertType.ERROR, "number is invalid!");
            alert.show();
            return;
        }
        try {
            Integer number = Integer.parseInt(textField.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "number is invalid!");
            alert.show();
            return;
        }
        numberIsOk = true;
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

    public void showCreditInf(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "CreditNumber : " +
                Student.student.creditNumber + "\n" + "CreditPass :" + Student.student.creditPass);
        alert.show();
        return;
    }
}
