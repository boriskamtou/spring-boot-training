package com.boris.todorestapi.repositories;

import com.boris.todorestapi.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Task, Long> {
}
