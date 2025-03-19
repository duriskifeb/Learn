package todolist.src.main.java.todolist.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; // untuk menghandle 

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/todolist-sol";
    private static final String USER = "root";
    private static final String PASS = " ";

    private static Connection connection = null;

    public static Connection getConnetction() throws SQLException { // check ada msaalah apa ngga pada sql nya
        try {
            Class.forName("com.mysql.cj.cjdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new SQLException("Failed to connect to database");
        } finally {
            connection.close();
        }
        return connection;
    }

    // inging menerapkan, dengan memiliki fungsinya sendri sendiri
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}