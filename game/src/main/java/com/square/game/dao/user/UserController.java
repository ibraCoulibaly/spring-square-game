package com.square.game.dao.user;

import com.square.game.dao.UserDAO;
import com.square.game.dao.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    UserDAO userDAO;

    private final Map<String, User> userMap = new HashMap<>();
    private final ArrayList<User> listUser = new ArrayList<>();

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserCreationParam params){
        return userDAO.getUserDTO(params);
    }
    @GetMapping("/list")
    public Collection<UserDAO> getListUser(int params){
        return null;
    }

    @GetMapping("/users/{name}")
    public UserDTO getUser(@PathVariable String name){
        return null;
    }
}
