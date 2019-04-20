package Golestan.Model;

import java.util.ArrayList;

public class Teacher {

    public boolean seeUnits;

    public static Teacher teacher = null;
    public static ArrayList<Teacher> teachers =new ArrayList<>();

    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username;
    public String password;

}
