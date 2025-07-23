package com.list.repository;

import com.list.domain.Task;
import com.list.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // métodos: findById(), save(), findAll(), deleteById()
    // Consulta personalizada vem aqui dentro
    List<Task> findFavoriteTasks ();
    List<Task> findTasksByUser (User user);
}
