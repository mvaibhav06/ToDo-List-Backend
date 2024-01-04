package com.todo.rest;

import com.todo.entity.Task;
import com.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoRestController {

    private ToDoService toDoService;

    @Autowired
    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/tasks")
    public List<Task> getAll(){
        return toDoService.getAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable int id){
        return toDoService.findById(id);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        task.setId(0);
        return toDoService.save(task);
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task){
        return toDoService.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTaskById(@PathVariable int id){
        toDoService.deleteById(id);

        return "Task with id: " + id + " deleted...";
    }
}
