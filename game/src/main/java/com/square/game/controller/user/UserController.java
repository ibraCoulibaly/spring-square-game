package com.square.game.controller.user;

import com.square.game.service.user.dao.UserDAO;
import com.square.game.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    @Qualifier("userDAOImpl")
    private  UserDAO userDAO;
    @PostMapping("/users")
    public UserDTO createUserDTO(@RequestBody UserCreationParam params){
        User user = userDAO.createUser(params);
        userDAO.getAllUsers().add(user);
        return User.toUserDTO(user);
    }
    @GetMapping("/listUsers")
    public Collection<UserDTO> getListUser(){
        return userDAO.getAllUsers().stream().map(User::toUserDTO).toList();
    }
    @GetMapping("/listUsers/{userId}")
    public UserDTO getUser(@PathVariable UUID userId){
        User user = userDAO.getUserById(userId);
        return User.toUserDTO(user);
    }
    @DeleteMapping("/listUsers/sup/{userId}")
    public Collection<UserDTO> supUser(@PathVariable UUID userId){
        userDAO.deleteUser(userId);
        return getListUser();
    }
    @PutMapping("/listUsers/up/{userId}")
    public UserDTO upUser(@PathVariable UUID userId, @RequestBody User user){
        User user1 = userDAO.updateUser(userId, user);
        user1.setId(userId);
        return User.toUserDTO(user1);
    }

}