package com.square.game.controller.user;

import com.square.game.service.user.dao.UserDAO;
import com.square.game.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    private  UserDAO userDAO;
    @PostMapping("/users")
    public UserDTO createUserDTO(@RequestBody UserCreationParam params){
        User user = userDAO.createUser(params);
        userDAO.addUser(user);
        return User.toUserDTO(user);
    }
    @GetMapping("/listUsers")
    public Collection<User> getListUser(){
        return userDAO.getAllUsers();
    }
    @GetMapping("/listUsers/{usreId}")
    public User getUser(@PathVariable int usreId){
        return userDAO.getUserById(usreId);
    }
    @DeleteMapping("/listUsers/sup/{userId}")
    public Collection<User> supUser(@RequestBody UserCreationParam params){
        userDAO.deleteUser(params.id());
        return getListUser();
    }

//    @PutMapping("/listUsers/up/{userId}")
//    public Collection<User> upUser(@PathVariable int userId, @RequestBody User user){
//        User newUser = userDAO.getUserById(userId);
//        return getListUser();
//    }


}