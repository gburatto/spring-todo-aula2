package com.utfpr.todo.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void createUser_WithValidData_ReturnsUser() {

        Mockito.when(userRepository.save(UserConstants.USER)).thenReturn(UserConstants.USER_CREATED);

        UserModel createdUser = userService.create(UserConstants.USER);

        Assertions.assertThat(createdUser).isNotNull();
        Assertions.assertThat(createdUser.getId()).isNotNull();
        Assertions.assertThat(createdUser.getUsername()).isEqualTo(UserConstants.USER.getUsername());
        Assertions.assertThat(createdUser.getName()).isEqualTo(UserConstants.USER.getName());
        Assertions.assertThat(createdUser.getEmail()).isEqualTo(UserConstants.USER.getEmail());

    }
}
