package com.boris.todorestapi;

import com.boris.todorestapi.controllers.todo.TodoController;
import com.boris.todorestapi.entities.Task;
import com.boris.todorestapi.services.todo.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
@AutoConfigureMockMvc
public class TodoControllerUnitTest {

    private MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void verifyGetAllTodos() throws Exception  {

        mockMvc.perform(get("/todos/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(todoService, times(1)).getAllTodos();

    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void verifyGetOneTask() throws Exception {
        mockMvc.perform(get("/todo/1"))
                .andExpect(status().isOk());

        verify(todoService, times(1)).findTodoById(1L);

    }

    @Test
    @WithMockUser(username = "admin", password = "password", roles = "USER")
    public void verifyTaskDeletion() throws Exception {
        mockMvc.perform(delete("/todo/1"))
                .andExpect(status().isOk());

        verify(todoService, times(1)).deleteTodoById(1L);
    }

   @Test
    public void verifyTaskCreation() throws Exception {
        String body = "{\"title\": \"Title 1\", \"description\": \"Description 1\"} ";
        mockMvc.perform(post("/todo/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .accept("application/json"))
                .andExpect(status().isCreated());
     //   Task task = new Task("title 1", "description 1");
   //     assertEquals(todoService.createTodo(task), new Task("title 1", "description 1"));
    }

    @Test
    public void verifyUpdateTask() {

    }
}
