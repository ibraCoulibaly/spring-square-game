package com.square.game.dao;

import com.square.game.dao.dto.UserDTO;
import com.square.game.dao.user.User;
import com.square.game.dao.user.UserCreationParam;

import java.util.List;


public interface UserDAO {
    List<User> getAllUsers();
    UserDTO getUserDTO(UserCreationParam params);
    User createUser(int id, String firstName, String lastName, int age);
    User getUserById(int id);
    void addUser(User user);
    void deleteUser(int id);
}
