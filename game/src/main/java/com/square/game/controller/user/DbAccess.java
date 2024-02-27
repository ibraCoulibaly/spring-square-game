package com.square.game.controller.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbAccess {

    private static DbAccess instance;

    private Connection con;


    public static DbAccess getInstance() {
        if (instance == null) instance = new DbAccess();
        return instance;
    }

    private DbAccess() {
        //TODO generate everything you need for db connection
        getCon();
    }

    public Connection getCon() {
        if (con == null){
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:6603/game", "root", "helloworld");
            }
            catch(Exception e){
                System.err.println(e.getMessage());
            }
        }

        return con;
    }




}
