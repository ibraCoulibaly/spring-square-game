package com.square.game.controller.user;


import com.square.game.controller.dto.UserDTO;
import com.square.game.controller.user.dao.UserDAO;
import com.square.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Qualifier("sqlUserDAO")
    private UserDAO userDAO;

    @PostMapping("/users")
    public UserDTO createUserDTO(@RequestBody UserCreationParam param){
        User user1 = new User(param.firstName(), param.lastName(), param.age());
        userRepository.save(user1);
        return User.toUserDTO(user1);
    }
    @GetMapping("/listUsers")
    public Collection<UserDTO> getListUser(){
        return userRepository.findAll().stream().map(User::toUserDTO).toList();

    }
    @GetMapping("/listUsers/{userId}")
    public UserDTO getUser(@PathVariable UUID userId){
        User user = userRepository.getReferenceById(userId);
        return User.toUserDTO(user);
    }
    @DeleteMapping("/listUsers/sup/{userId}")
    public Collection<UserDTO> supUser(@PathVariable UUID userId){
        userRepository.deleteById(userId);
        return getListUser();
    }
    @PutMapping("/listUsers/up/{userId}")
    public UserDTO upUser(@PathVariable UUID userId, @RequestBody UserCreationParam param){
        User user = userRepository.getReferenceById(userId);
        user.setId(userId);
        user.setFirstName(param.firstName());
        user.setLastName(param.lastName());
        user.setAge(param.age());
        userRepository.save(user);
        return User.toUserDTO(user);
    }

    /*@PostMapping("/users")
    public UserDTO createUserDTO(@RequestBody User user){
        userDAO.addUser(user);
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
    }*/

    /*--------------------------------------------------------
    * Controller to test Repository
    *---------------------------------------------------------*/



}