package com.todo.service;

import com.todo.dao.ToDoDAO;
import com.todo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    private ToDoDAO toDoDAO;

    @Autowired
    public ToDoServiceImpl(ToDoDAO toDoDAO) {
        this.toDoDAO = toDoDAO;
    }


    @Override
    @Transactional
    public Task save(Task task) {
        return toDoDAO.save(task);
    }



    @Override
    public List<Task> getAll() {
        return toDoDAO.getAll();
    }

    @Override
    public Task findById(int id) {
        return toDoDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        toDoDAO.deleteById(id);
    }
}
