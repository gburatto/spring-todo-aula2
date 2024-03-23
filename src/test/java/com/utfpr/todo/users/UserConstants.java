package com.utfpr.todo.users;

import java.util.UUID;

public class UserConstants {
    
        private static final String USERNAME = "Test";

        private static final String NAME = "Test";

        private static final String EMAIL = "test@test.com";

        private static final String PASSWORD = "Test";

        public static final UserModel USER = UserModel.builder()
                        .username(USERNAME)
                        .name(NAME)
                        .email(EMAIL)
                        .password(PASSWORD)
                        .build();

        public static final UserModel USER_CREATED = UserModel.builder()
                        .id(UUID.randomUUID().toString())
                        .username(USERNAME)
                        .name(NAME)
                        .email(EMAIL)
                        .build();

        public static final UserModel USER_EMPTY = UserModel.builder().build();

        public static final UserModel USER_INVALID = UserModel.builder()
                        .username("")
                        .name("")
                        .email("")
                        .password("")
                        .build();

}
