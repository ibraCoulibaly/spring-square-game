package com.square.game.service.user;


import com.square.game.controller.dto.UserDTO;
import com.square.game.controller.user.User;
import com.square.game.controller.user.UserCreationParam;
import com.square.game.service.user.dao.UserDAO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserDAOImpl implements UserDAO {
    private final List<User> listUserDTO = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return listUserDTO;
    }



    @Override
    public User getUserById(UUID id) {
        return getAllUsers().stream().filter(e -> e.getId().equals(id)).toList().getFirst();
    }
    @Override
    public User createUser(UserCreationParam params) {
        return new User( params.lastName(), params.firstName(), params.age());
    }
    @Override
    public void addUser(User user) {
        listUserDTO.add(user);
    }
    @Override
    public void deleteUser(UUID id) {
        User user = listUserDTO.stream().filter(e->e.getId().equals(id)).toList().getFirst();
        listUserDTO.remove(user);
    }

    @Override
    public User updateUser(UUID id, User user) {
        User toUpdate = getUserById(id);
        toUpdate.setFirstName(user.getFirstName());
        toUpdate.setLastName(user.getLastName());
        toUpdate.setAge(user.getAge());
        return user;
    }
}
