package com.example.taskborad.dao.service;


import com.example.taskborad.dao.entity.Task;
import com.example.taskborad.dao.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepo taskRepo;

    @Override
    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task updateTask(Task task, Long id) {
        Task existingTask = taskRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setPriority(task.getPriority());

        return taskRepo.save(existingTask);
    }

    @Override
    public String deleteTask(Long id) {
        taskRepo.deleteById(id);
        return "Deleted Successfully";
    }
}
