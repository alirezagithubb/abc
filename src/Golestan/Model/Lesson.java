package Golestan.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Lesson {

    public static ObservableList<Lesson> lessons = FXCollections.observableArrayList();

    public String name;
    public String numberOfUnits;
    public String day;
    public String date;
    public String teacherName;
    public String capacity;

    public Lesson(String name, String numbrOfUnits, String day, String date, String teacherName , String capacity) {
        this.name = name;
        this.numberOfUnits = numbrOfUnits;
        this.day = day;
        this.date = date;
        this.teacherName = teacherName;
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(String numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
