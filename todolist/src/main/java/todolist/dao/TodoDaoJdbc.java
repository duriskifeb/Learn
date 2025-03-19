package todolist.src.main.java.todolist.dao;

import todolist.src.main.java.todolist.Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class TodoDaoJdbc implements TodoDao {

    @Override
    public void Create(Todo todo) throws Exception {
        String sql = "INSERT INTO todos (title, description, completed) VALUES (?, ?, ?)";

             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
    
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                } else {
                    throw new Exception("Gagal membuat todo, tidak ada ID yang diperoleh.");
                }
            }
        }
    }

    @Override
    public void Update(Todo todo) throws Exception {

        String sql = "UPDATE todos SET title = ?, description = ?, completed = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setBoolean(3, todo.isCompleted());
            stmt.setInt(4, todo.getId());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new Exception("Gagal mengupdate todo, tidak ada baris yang terpengaruh.");
            }
        }
    }

    @Override
    public void deleted(Todo todo) throws Exception {
        
    
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
    
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                } else {
                    throw new Exception("Gagal membuat todo, tidak ada ID yang diperoleh.");
                }
            }
        }
    }
    
    @Override
    public Todo findById(String id) throws Exception {
        String sql = "INSERT INTO todos (title, description, completed) VALUES (?, ?, ?)";

             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
    
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                } else {
                    throw new Exception("Gagal membuat todo, tidak ada ID yang diperoleh.");
                }
            }
        }    
    }

    @Override
    public List<Todo> findAll() throws Exception {
        String sql = "INSERT INTO todos (title, description, completed) VALUES (?, ?, ?)";

             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
    
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                } else {
                    throw new Exception("Gagal membuat todo, tidak ada ID yang diperoleh.");
                }
            }
        } 
    }

    @Override
    public void addTodo(Todo todo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTodo'");
    }
}