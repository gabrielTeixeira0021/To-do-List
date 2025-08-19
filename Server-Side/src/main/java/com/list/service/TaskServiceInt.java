package com.list.service;

import com.list.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskServiceInt {
    Task createTask(Task newTask);
    List<Task> getAllTasks(Long id);
    Optional<Task> getTaskById(Long id);
    //List<Task> getTasksByUser(User user);
    List<Task> getFavoriteTasks();
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
}