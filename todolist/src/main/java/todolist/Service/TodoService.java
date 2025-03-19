package todolist.src.main.java.todolist.Service;

import java.util.List;
import todolist.src.main.java.todolist.Model.*;

public interface TodoService {
    void Create(Todo todo) throws Exception;

    void Update(Todo todo) throws Exception;

    void deleted(int id) throws Exception;

    Todo getTodoById(int id) throws Exception;

    List<Todo> getAllTodo() throws Exception;

    void markAsCompleted(int id) throws Exception;
    
}
