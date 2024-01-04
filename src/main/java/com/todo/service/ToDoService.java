package com.todo.service;

import com.todo.entity.Task;

import java.util.List;

public interface ToDoService {

    Task save(Task task);

    List<Task> getAll();

    Task findById(int id);

    void deleteById(int id);
}
