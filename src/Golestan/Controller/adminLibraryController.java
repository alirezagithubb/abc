package Golestan.Controller;

import Golestan.Main;
import Golestan.Model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class adminLibraryController {
    public TableView<Book> bookTable;
    public TableColumn<Book , String> nameCol;
    public TableColumn<Book , String> authorCol;
    public TableColumn<Book, String> publisherCol;
    public TextField nameField;
    public TextField authorField;
    public TextField publisherField;
    public TableColumn conditionCol;

    public adminLibraryController() throws IOException {
    }


    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
    }

    public void addBook(ActionEvent actionEvent) {

        if(nameField.getText().length() == 0 || authorField.getText().length() == 0 || publisherField.getText().length() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR,"some fields are empty!");
            alert.show();
            return;
        }
        Book.books.add(new Book(nameField.getText() , authorField.getText() , publisherField.getText()));
        bookTable.setItems(Book.books);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/AdminHP.fxml"));
        Main.ps.setScene(new Scene(root));
        return;
    }
}
