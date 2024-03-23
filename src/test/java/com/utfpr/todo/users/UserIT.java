package com.utfpr.todo.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserIT {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createUser_WithDataValid_ReturnsCreated() {

        ResponseEntity<UserModel> response = restTemplate.postForEntity("/users", UserConstants.USER, UserModel.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(response.getBody().getId()).isNotNull();
        Assertions.assertThat(response.getBody().getUsername()).isEqualTo(UserConstants.USER_CREATED.getUsername());
        Assertions.assertThat(response.getBody().getName()).isEqualTo(UserConstants.USER_CREATED.getName());
        Assertions.assertThat(response.getBody().getEmail()).isEqualTo(UserConstants.USER_CREATED.getEmail());

    }

    @Test
    public void createUser_WithInvalidData_ReturnsUnprocessableEntity() {
        ResponseEntity<Object> response = restTemplate.postForEntity("/users", UserConstants.USER_INVALID, Object.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
