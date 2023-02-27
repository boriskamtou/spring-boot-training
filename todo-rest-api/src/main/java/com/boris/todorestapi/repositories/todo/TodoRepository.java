package com.boris.todorestapi.repositories.todo;

import com.boris.todorestapi.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {
}
