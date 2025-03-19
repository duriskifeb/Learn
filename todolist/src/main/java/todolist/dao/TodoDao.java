package todolist.src.main.java.todolist.dao;

import java.util.List;
import todolist.src.main.java.todolist.Model.*;

//menerapkan OCP Princilple 
// Karena interface ini memungkinkan untuk ekstensi tanpa modifikasi 
public interface TodoDao {
    void Create(Todo todo) throws Exception;
    void Update(Todo todo) throws Exception;
    void deleted(Todo todo) throws Exception;

    Todo findById(String id) throws Exception;
    List<Todo> findAll() throws Exception;
    void addTodo(Todo todo);
}
