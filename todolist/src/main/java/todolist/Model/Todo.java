package todolist.src.main.java.todolist.Model;

import java.sql.ResultSet;

public class Todo {
    private int id;
    private String title, description;
    private boolean completed;

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    //constructor nganggur 
    public Todo() {}


    // getter dan setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }


    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return id + " - " + title + (completed ? "[V]" : "[]") + "\n " + description;  
    }
    
    //ini blom
    private Todo extractTodoFromResultSet(ResultSet set) throws Exception {
        Todo todo = new Todo();
        todo.setId(set.getInt("id"));
        todo.setTitle(set.getString("title"));
        todo.setDescription(set.getString("desription"));
        todo.setCompleted(set.getBoolean("completed"));
        return todo;
    }
}