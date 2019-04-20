package Golestan.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Student {

    public ObservableList<Book> borrowedBooks = FXCollections.observableArrayList();
    public ObservableList<Book> lessonsChoiced = FXCollections.observableArrayList();

    public boolean[][] diningChoiceBox = new boolean[5][2];
    public static Student student = null;
    public static ArrayList<Student> students = new ArrayList<>();
    public int numberOfBorrowedBooks = 0;
    public String username;
    public String password;
    public int credit = 10000;
    public String creditNumber = "";
    public String creditPass = "";
    public Integer average = 20;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
