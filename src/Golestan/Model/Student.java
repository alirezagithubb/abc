package Golestan.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Student {

    public ObservableList<Book> borrowedBooks = FXCollections.observableArrayList();
    public ObservableList<Lesson> lessonsChoiced = FXCollections.observableArrayList();
    public ArrayList<String> marks = new ArrayList<>();
    public ArrayList<Boolean> unitCondition = new ArrayList<>();

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


    @Override
    public String toString() {
        if(marks.get(Lesson.index) != "-1") {
            return username + "   " + marks.get(Lesson.index);
        }
        else{
            return username + "   " + "No Mark Entered";
        }
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
