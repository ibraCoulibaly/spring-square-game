/*package com.square.game.controller.user;

import com.square.game.controller.dto.UserDTO;

import com.square.game.controller.user.dao.UserDAO;
import com.square.game.repository.UserRepository;
import com.sun.tools.javac.Main;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Qualifier("userDAOImpl")
    private UserDAO userDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @PostMapping("/users")
    public UserDTO createUserDTO( @RequestBody User user){
        userDAO.addUser(user);
        LOGGER.info("User ajouter");
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



    /*--------------------------------------------------------
    * Controller to test Repository
    *---------------------------------------------------------*/


   /* @PostMapping("/usersRepo")
    public UserDTO createUserDTOForRepo(@Valid @RequestBody UserCreationParam param){
        User user1 = new User(param.getFirstName(), param.getLastName(), param.getAge());
        userRepository.save(user1);
        return User.toUserDTO(user1);
    }
    @GetMapping("/listUsersRepo")
    public Collection<UserDTO> getListUserForRepo(){
        return userRepository.findAll().stream().map(User::toUserDTO).toList();
    }
    @GetMapping("/listUsersRepo/{userId}")
    public UserDTO getUserForRepo(@PathVariable UUID userId){
        User user = userRepository.getReferenceById(userId);
        return User.toUserDTO(user);
    }
    @DeleteMapping("/listUsersRepo/sup/{userId}")
    public Collection<UserDTO> supUserForRepo(@PathVariable UUID userId){
        userRepository.deleteById(userId);
        return getListUserForRepo();
    }
    @PutMapping("/listUsersRepo/up/{userId}")
    public UserDTO updateUserForRepo(@PathVariable UUID userId, @RequestBody UserCreationParam param){
        return User.toUserDTO(userRepository.updateUserForRepoImpl(userId, param));
    }

}*/





