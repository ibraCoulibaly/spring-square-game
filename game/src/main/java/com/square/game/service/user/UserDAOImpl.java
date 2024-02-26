package com.square.game.service.user;


import com.square.game.controller.user.User;
import com.square.game.controller.user.UserCreationParam;
import com.square.game.service.user.dao.UserDAO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDAOImpl implements UserDAO {
    private final List<User> listUserDTO = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return listUserDTO;
    }

    @Override
    public User getUserDTO(UserCreationParam params) {
        return createUser(params);
    }
    @Override
    public User createUser(int id, String firstName, String lastName, int age) {
        int idRamdom = id+ (int)(Math.random() * ((247 - id) +1));
        return new User(id, firstName, lastName, age);
    }
    @Override
    public User getUserById(int id) {
        return getAllUsers().stream().filter(e -> e.getId() == id).toList().getFirst();
    }
    @Override
    public User createUser(UserCreationParam params) {
        return new User(params.id(), params.lastName(), params.firstName(), params.age());
    }
    @Override
    public void addUser(User user) {
        listUserDTO.add(user);
    }
    @Override
    public void deleteUser(int id) {
        listUserDTO.remove(id);
    }

    @Override
    public void updateUser(User user) {
        User toUpdate = getUserById(user.getId());
        toUpdate.setFirstName(user.getFirstName());
        toUpdate.setLastName(user.getLastName());
        toUpdate.setAge(user.getAge());
    }
}
