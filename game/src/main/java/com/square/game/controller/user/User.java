package com.square.game.controller.user;

import com.square.game.controller.dto.UserDTO;

import java.util.UUID;

public class User {
    private UUID id;

    private String lastName;

    private String firstName;

    private int age;

    public User(){

    }

    public User(UUID id, String lastName, String firstName, int age){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public User( String lastName, String firstName, int age){
        this.id = UUID.randomUUID();
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }



    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
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
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());
    }
    public static User toUser(UserDTO userDTO){
        return new User(userDTO.firstName(), userDTO.lastName(), userDTO.age());
    }
}
