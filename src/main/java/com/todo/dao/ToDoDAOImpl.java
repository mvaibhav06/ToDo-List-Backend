package com.todo.dao;

import com.todo.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoDAOImpl implements ToDoDAO{

    private EntityManager entityManager;

    @Autowired
    public ToDoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Task save(Task task) {
        return entityManager.merge(task);
    }

    @Override
    public List<Task> getAll() {
        TypedQuery<Task> query = entityManager.createQuery("from Task", Task.class);
        List<Task> tasks = query.getResultList();
        return tasks;
    }

    @Override
    public Task findById(int id) {
        Task task = entityManager.find(Task.class, id);
        return task;
    }

    @Override
    public void deleteById(int id) {
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
    }


}
