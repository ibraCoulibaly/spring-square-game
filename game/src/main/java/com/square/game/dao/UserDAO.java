package com.square.game.dao;

import com.square.game.dao.dto.UserDTO;
import com.square.game.dao.user.User;
import com.square.game.dao.user.UserCreationParam;
import java.util.List;

public interface UserDAO {
    List<UserDTO> getAllUsers();
    UserDTO getUserDTO(UserCreationParam params);
    User createUser(int id, String firstName, String lastName, int age);
    UserDTO createUserDTO(UserCreationParam params);
    UserDTO getUserById(int id);
    void addUser(UserDTO user);
    void deleteUser(int id);
    void updateUser(User user);
}
