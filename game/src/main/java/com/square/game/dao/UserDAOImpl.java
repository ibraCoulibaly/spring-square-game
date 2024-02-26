package com.square.game.dao;


import com.square.game.dao.dto.UserDTO;
import com.square.game.dao.user.User;
import com.square.game.dao.user.UserCreationParam;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDAOImpl implements UserDAO{
    private final List<UserDTO> listUserDTO = new ArrayList<>();

    @Override
    public List<UserDTO> getAllUsers() {
        return listUserDTO;
    }

    @Override
    public UserDTO getUserDTO(UserCreationParam params) {
        return createUserDTO(params);
    }
    @Override
    public User createUser(int id, String firstName, String lastName, int age) {
        int idRamdom = id+ (int)(Math.random() * ((247 - id) +1));
        return new User(id, firstName, lastName, age);
    }
    @Override
    public UserDTO getUserById(int id) {
        return getAllUsers().stream().filter(e -> e.id() == id).toList().getFirst();
    }
    @Override
    public UserDTO createUserDTO(UserCreationParam params) {
        return new UserDTO(params.id(), params.lastName(), params.firstName(), params.age());
    }
    @Override
    public void addUser(UserDTO user) {
        listUserDTO.add(user);
    }
    @Override
    public void deleteUser(int id) {
        listUserDTO.remove(id);
    }

    @Override
    public void updateUser(User user) {
//        User toUpdate = getUserById(user.getId());
//        toUpdate.setFirstName(user.getFirstName());
//        toUpdate.setLastName(user.getLastName());
//        toUpdate.setAge();
    }
}
