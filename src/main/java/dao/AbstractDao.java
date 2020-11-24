package dao;

import entity.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AbstractDao {

    final static SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy '-' HH:mm:ss");

    protected final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    protected final static String LOGIN_TABLES = "postgres";
    protected final static String PASS_TABLES = "learn2000_";

    Connection connection = null;
    Menu menu = new Menu();

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
