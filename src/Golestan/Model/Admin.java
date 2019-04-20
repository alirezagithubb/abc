package Golestan.Model;

public class Admin {

    public String username = "";
    public String password;

    public void setUP (String username , String passwprd) {
        this.username = username;
        this.password = passwprd;
    }

    private Admin(){

    }

    private static Admin admin = new Admin();

    public static Admin getAdmin() {
        return admin;
    }
}
