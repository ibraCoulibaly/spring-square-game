package com.square.game.controller.user.dao;

import com.square.game.controller.dto.UserDTO;
import com.square.game.controller.user.User;
import com.square.game.controller.user.UserCreationParam;
import java.util.List;
import java.util.UUID;

public interface UserDAO{
    List<User> getAllUsers();
    User getUserById(UUID id);
    void addUser(User user);
    void deleteUser(UUID id);
    User updateUser(UUID id, User user);

}
