package com.boris.todorestapi.services.todo;

import com.boris.todorestapi.entities.Task;
import com.boris.todorestapi.repositories.todo.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private static final Logger LOG = LoggerFactory.getLogger(TodoServiceImpl.class);
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private final TodoRepository todoRepository;

    @Override
    public List<Task> getAllTodos() {
        return (List<Task>) todoRepository.findAll();
    }

    @Override
    public Task createTodo(Task task) {
        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        LOG.info("The new task is {}", newTask);
        return todoRepository.save(newTask);
    }

    @Override
    public Task findTodoById(Long id) {
        Optional<Task> optionalTask = Optional.of(todoRepository.findById(id).get());
        return optionalTask.orElseThrow(TodoNotFoundException::new);
    }

    @Override
    public Task updateTodo(Task updatedTask, Long id) {
        return todoRepository.findById(id).map(
                task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getTitle());
                    return todoRepository.save(task);
                }
        ).orElseGet(() -> {
            updatedTask.setId(id);
            return todoRepository.save(updatedTask);
        });
    }

    @Override
    public String deleteTodoById(Long id) {
        todoRepository.deleteById(id);
        return "Task deleted successfully";
    }
}
