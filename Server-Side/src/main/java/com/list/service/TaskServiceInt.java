package com.list.service;

import com.list.domain.Task;
import com.list.domain.User;

import java.util.List;
import java.util.Optional;

public interface TaskServiceInt {
    Task createTask(Task newTask);
    Task updateTask(Long id, Task updatedTask);
    List<Task> getAllTasks(Long id);
    Optional<Task> getTaskById(Long id);
    List<Task> getTasksByUser(User user);
    List<Task> getFavoriteTasks();
    void deleteTask(Long id);
}