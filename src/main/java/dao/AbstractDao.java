package dao;

import entity.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDao {

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
