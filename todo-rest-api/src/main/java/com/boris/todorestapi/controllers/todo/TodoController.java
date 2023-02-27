package com.boris.todorestapi.controllers.todo;

import com.boris.todorestapi.entities.Task;
import com.boris.todorestapi.services.todo.TodoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Location microservice is running.")
})
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Task>> getAllTodos() {
        List<Task> todos = todoService.getAllTodos();
        log.debug("Tasks: {}", todos);
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Task> findTodoById(@PathVariable Long id) {
        Task task = todoService.findTodoById(id);
        log.info("Todo: {}", task);
        return new  ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id) {
        Task updatedTask = todoService.updateTodo(task, id);
        log.info("Updated Task: {}", updatedTask);
        return new  ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
       String response = todoService.deleteTodoById(id);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<Task> createTodo(@RequestBody Task task) {
        Task newTask = todoService.createTodo(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

}
