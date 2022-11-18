package com.boris.todorestapi.repositories;

import com.boris.todorestapi.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {
}
