package com.todo.dao;

import com.todo.entity.Task;

import java.util.List;

public interface ToDoDAO {

    Task save(Task task);

    List<Task> getAll();

    Task findById(int id);

    void deleteById(int id);


}
