//package com.square.game.controller.user;
//
//import com.square.game.controller.dto.UserDTO;
//import com.square.game.service.user.dao.UserDAO;
//import org.springframework.stereotype.Service;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class SqlUserDAO implements UserDAO {
//    private DbAccess dbAccess = DbAccess.getInstance();
//
//    @Override
//    public List<User> getAllUsers() {
//        return null;
//    }
//
//    @Override
//    public User getUserDTO(UserCreationParam params) {
//        return null;
//    }
//
//    @Override
//    public User createUser(UserCreationParam params) {
//        return null;
//    }
//
//    @Override
//    public User getUserById(int id) {
//        return null;
//    }
//
//    @Override
//    public void addUser(User user) {
//
//    }
//
//    @Override
//    public void deleteUser(int id) {
//
//    }
//
//    @Override
//    public void updateUser(User user) {
//
//    }
//
////    @Override
////    public List<UserDTO> findAll() {
////        ArrayList<UserDTO> allProfil = new ArrayList<>();
////        Connection con = this.dbAccess.getCon();
////        try {
////            Statement stat = con.createStatement();
////            ResultSet res = stat.executeQuery(
////                    "SELECT  id, firstName, lastName, dateNaissanceUser FROM User");
////
////            while (res.next()){
////                UserDTO userDTO = new UserDTO();
////                userDTO.setId(res.getLong("id"));
////                userDTO.setFirstName(res.getString("firstName"));
////                userDTO.setLastName(res.getString("lastName"));
////                userDTO.setTelephone(res.getString("dateNaissanceUser"));
////                allProfil.add(userDTO);
////
////            }
////
////        }catch (Exception e){
////            System.out.println(e);
////        }
////
////        return allProfil;
////    }
//
//
//}
