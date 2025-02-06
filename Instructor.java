import java.util.ArrayList;
public class Instructor {
    private static Instructor instance;
    private String username;
    private String password;

    private Instructor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Instructor getInstance(String username, String password) {
        if (instance == null) {
            instance = new Instructor(username, password);
        }
        return instance;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Instructor: " + username;
    }
}