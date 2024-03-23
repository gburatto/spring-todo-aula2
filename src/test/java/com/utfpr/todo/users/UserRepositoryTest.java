package com.utfpr.todo.users;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUser_WithDataValid_ReturnsUser() {

        UserModel createdUser = userRepository.save(UserConstants.USER);

        System.out.println("createdUser");
        System.out.println(createdUser);

        UserModel foundUser = userRepository.findById(createdUser.getId()).get();

        System.out.println("foundUser");
        System.out.println(foundUser);

        Assertions.assertThat(createdUser).isEqualTo(foundUser);

    }

    @Test
    public void createUser_WithInvalidData_ThrowsException() {

        UserModel emptyUser = UserConstants.USER_EMPTY;
        UserModel invalidUser = UserConstants.USER_INVALID;

        Assertions.assertThatThrownBy(() -> userRepository.save(emptyUser)).isInstanceOf(RuntimeException.class);

        Assertions.assertThatThrownBy(() -> userRepository.save(invalidUser)).isInstanceOf(RuntimeException.class);

    }
}
