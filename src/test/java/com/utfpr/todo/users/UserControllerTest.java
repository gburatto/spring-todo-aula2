package com.utfpr.todo.users;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void createUser_WithDataValid_ReturnsCreated() throws JsonProcessingException, Exception {

    Mockito.when(userService.create(UserConstants.USER)).thenReturn(UserConstants.USER_CREATED);

    mockMvc.perform(
        post("/users")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(UserConstants.USER)))
        .andExpect(status().isCreated())
        .andExpect(content().json(objectMapper.writeValueAsString(UserConstants.USER_CREATED)));

  }

}
