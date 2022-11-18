package com.boris.todorestapi.services;

import com.boris.todorestapi.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
   List<Task> getAllTodos();
   Task createTodo(Task task);
   Task findTodoById(Long id);
   Task updateTodo(Task task, Long id);
   String deleteTodoById(Long id);

}
