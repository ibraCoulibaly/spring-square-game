package com.square.game.controller.user;

import com.square.game.controller.dto.UserDTO;

public class User {
    private int id;

    private String lastName;

    private String firstName;

    private int age;

    public User(int id, String lastName, String firstName, int age){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public User( String lastName, String firstName, int age){
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String firstName) {
        this.lastName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String prenom) {
        this.firstName = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getAge());
    }
    public static User toUser(UserDTO userDTO){
        return new User(userDTO.firstName(), userDTO.lastName(), userDTO.age());
    }
}
