package com.square.game.controller.user;

import com.square.game.controller.dto.UserDTO;
import com.square.game.service.user.dao.UserDAO;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class SqlUserDAO implements UserDAO {
    private DbAccess dbAccess = DbAccess.getInstance();


    @Override
    public List<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        Connection con = this.dbAccess.getCon();
        try {
            Statement stat = con.createStatement();
            ResultSet res = stat.executeQuery(
                    "SELECT  * FROM User");

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
    public User createUser(UserCreationParam params) {
        return null;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

//    @Override
//    public void addUser(User user) {
//
//        Connection con = this.dbAccess.getCon();
//        try {
//            String req = "INSERT INTO User (firstName, lastName, age) VALUES (?,?,?,)";
//            PreparedStatement stat = con.prepareStatement(req);
//            stat.setString(1, user.getFirstName());
//            stat.setString(2, user.getLastName());
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//    }

    @Override
    public void deleteUser(UUID id) {

    }

    @Override
    public User updateUser(UUID id, User user) {
        return null;
    }
}
