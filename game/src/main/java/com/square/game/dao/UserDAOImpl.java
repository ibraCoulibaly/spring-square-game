package com.square.game.dao;


import com.square.game.dao.dto.UserDTO;
import com.square.game.dao.user.User;
import com.square.game.dao.user.UserCreationParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAOImpl implements UserDAO{
    //private final Map<Integer, User> userMap = new HashMap<>();
    private final ArrayList<User> listUser = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return listUser;
    }

    @Override
    public UserDTO getUserDTO(UserCreationParam params) {
        User user = createUser(params.id(), params.firstName(), params.lastName(), params.age());
        return new UserDTO(params.lastName(), params.firstName(), params.age());
    }

    @Override
    public User createUser(int id, String firstName, String lastName, int age) {
        return new User(id, firstName, lastName, age);
    }

    @Override
    public User getUserById(int id) {
        //return userMap.get(id);
        return listUser.get(id);
    }
    @Override
    public void addUser(User user) {
        listUser.add(user);
    }
    @Override
    public void deleteUser(int id) {
        listUser.remove(id);
    }
}
