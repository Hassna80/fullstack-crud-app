package com.example.taskborad.dao.service;


import com.example.taskborad.dao.entity.Task;

import java.util.List;

public interface TaskService {
    
    Task saveTask(Task task);

    List<Task> getAllTasks();

    Task updateTask(Task task, Long id);

    String deleteTask(Long id);
}
