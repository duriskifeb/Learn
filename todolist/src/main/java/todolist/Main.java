package todolist.src.main.java.todolist;

import java.sql.SQLException;

import javax.swing.text.View;

import todolist.src.main.java.todolist.Model.*;
import todolist.src.main.java.todolist.Database.DatabaseConnection;
import todolist.src.main.java.todolist.dao.TodoDao;
import todolist.src.main.java.todolist.dao.TodoDaoJdbc;
import todolist.src.main.java.todolist.Service.TodoService;
import todolist.src.main.java.todolist.Service.TodoServiceEmp;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            TodoDao todoDao = new TodoDaoJdbc();
            TodoService todoService = new TodoServiceEmp(todoDao);
            View cli = new View(todoService);
            cli.start();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection();
    }
    }
}