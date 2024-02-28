package com.square.game.controller.user.dao;
import com.square.game.controller.user.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserDAOImpl implements UserDAO {
    private final List<User> listUser = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return listUser;
    }
    @Override
    public User getUserById(UUID id) {
        return getAllUsers().stream().filter(e -> e.getId().equals(id)).toList().getFirst();
    }
    @Override
    public void addUser(User user) {
        listUser.add(new User(user.getFirstName(), user.getLastName(), user.getAge()));
    }
    @Override
    public void deleteUser(UUID id) {
        listUser.remove(listUser.stream().filter(e->e.getId().equals(id)).toList().getFirst());
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
