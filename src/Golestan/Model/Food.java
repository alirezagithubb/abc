package Golestan.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Food {

    public static ObservableList<Food> foods = FXCollections.observableArrayList();

    public Food(String name, String price, String day) {
        this.name = name;
        this.price = price;
        this.day = day;
    }

    public static ArrayList<Integer> diningPrices = new ArrayList<Integer>();
    public String day;
    public String name;
    public String price;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
