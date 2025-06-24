package com.example.taskborad.dao.service;

import com.example.taskborad.dao.entity.Task;
import com.example.taskborad.dao.repository.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {

    @Mock
    private TaskRepo taskRepo;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        task.setStatus(Task.Status.PENDING);
        task.setDueDate(new Date());
        task.setPriority(Task.Priority.HIGH);
    }

    @Test
    void testSaveTask() {
        when(taskRepo.save(any(Task.class))).thenReturn(task);

        Task saved = taskService.saveTask(task);
        assertEquals("Test Task", saved.getTitle());
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(task);
        when(taskRepo.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();
        assertEquals(1, result.size());
        assertEquals("Test Task", result.get(0).getTitle());
    }

    @Test
    void testUpdateTask_Success() {
        when(taskRepo.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepo.save(any(Task.class))).thenReturn(task);

        Task updated = new Task();
        updated.setTitle("Updated Title");
        updated.setDescription("Updated Description");
        updated.setStatus(Task.Status.COMPLETED);
        updated.setDueDate(new Date());
        updated.setPriority(Task.Priority.LOW);

        Task result = taskService.updateTask(updated, 1L);
        assertEquals("Updated Title", result.getTitle());
        assertEquals(Task.Status.COMPLETED, result.getStatus());
    }

    @Test
    void testUpdateTask_NotFound() {
        when(taskRepo.findById(2L)).thenReturn(Optional.empty());

        Task inputTask = new Task();
        assertThrows(ResponseStatusException.class, () -> taskService.updateTask(inputTask, 2L));
    }

    @Test
    void testDeleteTask() {
        doNothing().when(taskRepo).deleteById(1L);

        String result = taskService.deleteTask(1L);
        assertEquals("Deleted Successfully", result);
        verify(taskRepo, times(1)).deleteById(1L);
    }
}
