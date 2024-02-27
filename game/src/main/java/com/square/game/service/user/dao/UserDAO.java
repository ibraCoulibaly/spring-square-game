package com.square.game.service.user.dao;

import com.square.game.controller.user.User;
import com.square.game.controller.user.UserCreationParam;
import java.util.List;

public interface UserDAO{
    List<User> getAllUsers();
    User getUserDTO(UserCreationParam params);
    User createUser(UserCreationParam params);
    User getUserById(int id);
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
}
