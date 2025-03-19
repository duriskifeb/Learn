package todolist.src.main.java.todolist.Service;

import java.util.List;
import todolist.src.main.java.todolist.Model.*;
import todolist.src.main.java.todolist.dao.TodoDao;

public class TodoServiceEmp implements TodoService {
    private final TodoDao todoDao;

    public TodoServiceEmp(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public void Create(Todo todo) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void Update(Todo todo) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleted(int id) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Todo> getAllTodo() throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void markAsCompleted(int id) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public Todo getTodoById(int id) throws Exception {
        // TODO Auto-generated method stub
    }
}
