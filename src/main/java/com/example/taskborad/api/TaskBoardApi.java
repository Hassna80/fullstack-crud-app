package com.example.taskborad.api;

import com.example.taskborad.dao.entity.Task;
import com.example.taskborad.dao.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TaskBoardApi {

    @Autowired
    TaskService taskService;

    @PostMapping("/task")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }


    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }


    @PutMapping("tasks/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id) {
        return taskService.updateTask(task, id);
    }


    @DeleteMapping("tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}
