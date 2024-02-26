package com.square.game.dao.user;

import com.square.game.dao.UserDAO;
import com.square.game.dao.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    private  UserDAO userDAO;
    @PostMapping("/users")
    public UserDTO createUserDTO(@RequestBody UserCreationParam params){
        userDAO.getAllUsers().add(userDAO.createUserDTO(params));
        return userDAO.createUserDTO(params);
    }
    @GetMapping("/listUsers")
    public Collection<UserDTO> getListUser(){
        return userDAO.getAllUsers();
    }
    @GetMapping("/listUsers/{usreId}")
    public UserDTO getUser(@PathVariable int usreId){
        return userDAO.getUserById(usreId);
    }
    @DeleteMapping("/listUsers/sup/{usrId}")
    public Collection<UserDTO> supUser(@RequestBody UserCreationParam params){
        userDAO.deleteUser(params.id());
        return getListUser();
    }

//    @PutMapping("/listUsers/up/{usrId}")
//    public Collection<UserDTO> updUser(@PathVariable int userId,  @RequestBody UserCreationParam params){
//        UserDTO user = userDAO.getUserById(userId);
//        return getListUser();
//    }

}