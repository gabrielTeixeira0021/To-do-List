package com.list.service;

import com.list.domain.Task;
import com.list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceInt{

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // CREATE
    @Override
    public Task createTask(Task newTask) {
        // validações
        if(newTask.getTitle() == null || newTask.getTitle().isEmpty()) {
            throw new IllegalArgumentException("O título é obrigatório!!!");
        }
        return taskRepository.save(newTask);
    }

    // UPDATE
    @Override
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setFavorite(updatedTask.isFavorite());
            return taskRepository.save(task);
        })
        .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    // DELETE
    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }

    // READ
    @Override
    public List<Task> getAllTasks(Long id) {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getTasksByUser(User user) {
        return taskRepository.findTasksByUser(user);
    }

    @Override
    public List<Task> getFavoriteTasks() {
        return taskRepository.findByFavoriteTrue();
    }


}