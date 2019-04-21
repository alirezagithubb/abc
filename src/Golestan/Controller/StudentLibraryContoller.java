package Golestan.Controller;

import Golestan.Model.Book;
import Golestan.Model.Student;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentLibraryContoller {
    public TableView<Book> bookTable;
    public TableColumn<Book, String> nameCol;
    public TableColumn<Book, String> authorCol;
    public TableColumn<Book, String> publisherCol;
    public TableColumn<Book, String> conditionCol;
    private boolean BorrowIsAllowed;

    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
        bookTable.setItems(Book.books);
    }

    public void borrowBook() {
        checkAllowToBorrowBook();
        if (!BorrowIsAllowed) {
            return;
        }
        Book temp = bookTable.getSelectionModel().getSelectedItem();
        int index = Book.books.indexOf(temp);
        Book selectedBook = Book.books.get(index);
        if(selectedBook.condition.equals("NOT BORROWED")){
            Book.books.get(index).condition = "BORROWED";
            Book.borrowedBooks.add(selectedBook);
            Student.student.borrowedBooks.add(selectedBook);
            Student.student.numberOfBorrowedBooks++;
            conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));
            bookTable.setItems(Book.books);
            conditionCol.setCellValueFactory(new PropertyValueFactory<>("condition"));

        }
        else{
            if(Student.student.borrowedBooks.contains(selectedBook)){
                Book.books.get(index).condition = "NOT BORROWED";
                Book.borrowedBooks.remove(selectedBook);
                Student.student.borrowedBooks.remove(selectedBook);
                Student.student.numberOfBorrowedBooks--;
                bookTable.setItems(Book.books);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "The book is borrowed!");
                alert.show();
                return;
            }
        }
        BorrowIsAllowed = false;
    }

    public void checkAllowToBorrowBook() {
        if (Student.student.numberOfBorrowedBooks < 3) {
            BorrowIsAllowed = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "over borrowing");
            alert.show();
            return;
        }
    }
}
