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
    //@Qualifier("sqlUserDAO")
    private  UserDAO userDAO;
    @PostMapping("/users")
    public UserDTO createUserDTO(@RequestBody UserCreationParam params){
        User user = userDAO.createUser(params);
        userDAO.addUser(user);
        return User.toUserDTO(user);
    }
    @GetMapping("/listUsers")
    public Collection<UserDTO> getListUser(){
        return userDAO.getAllUsers().stream().map(User::toUserDTO).toList();
        //return userDAO.getAllUsers(user);
    }
    @GetMapping("/listUsers/{userId}")
    public UserDTO getUser(@PathVariable int userId){
        User user = userDAO.getUserById(userId);
        return User.toUserDTO(user);
    }
    @DeleteMapping("/listUsers/sup/{userId}")
    public Collection<UserDTO> supUser(@PathVariable int userId){
        userDAO.deleteUser(userId);
        return getListUser();
    }
    @PutMapping("/listUsers/up")
    public UserDTO upUser(@RequestBody User user){
        userDAO.updateUser(user);
        return User.toUserDTO(user);
    }


}