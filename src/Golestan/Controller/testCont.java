package Golestan.Controller;

import Golestan.Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class testCont {
    public ChoiceBox<String> choiceBox;
    public TableView<Book> tableView;
    public TableColumn<Book, String> row1;
    public TableColumn<Book, String> row2;
    public ListView<Book> listView;
    private ObservableList<Book> books = FXCollections.observableArrayList();

    public void initialize() {
        books.add(new Book("a","a","a"));
        books.add(new Book("b","b","b"));
        books.add(new Book("c","c","c"));
        listView.setItems(books);
        row1.setCellValueFactory(new PropertyValueFactory<>("name"));
        row1.setCellValueFactory(new PropertyValueFactory<>("author"));
        choiceBox.getItems().addAll("salam", "jashfo");
    }


    public void login(ActionEvent actionEvent) {
//        tableView.getSelectionModel().getSelectedItem().getName();
        System.out.println(choiceBox.getSelectionModel().getSelectedItem());
    }
}
