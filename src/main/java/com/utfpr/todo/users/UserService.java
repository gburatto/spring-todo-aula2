package com.utfpr.todo.users;

import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserModel create(UserModel user) {
    UserModel userModel = userRepository.findByUsername(user.getUsername());

    if (userModel != null) {
      throw new RuntimeException("Username already exists");
    }

    String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());

    user.setPassword(hashedPassword);

    return userRepository.save(user);
  }

}
