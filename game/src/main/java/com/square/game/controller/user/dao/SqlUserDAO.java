package com.square.game.controller.user.dao;

import com.square.game.controller.user.DbAccess;
import com.square.game.controller.user.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class SqlUserDAO implements UserDAO {
    private final DbAccess dbAccess = DbAccess.getInstance();

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        Connection con = this.dbAccess.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery("SELECT  * FROM User");
            while (res.next()){
                User user = new User();
                user.setId(UUID.fromString(res.getString("id")));
                user.setFirstName(res.getString("firstName"));
                user.setLastName(res.getString("lastName"));
                user.setAge(res.getInt("age"));
                allUsers.add(user);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return allUsers;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(UUID id) {

    }

    @Override
    public User updateUser(UUID id, User user) {
        return null;
    }
}
