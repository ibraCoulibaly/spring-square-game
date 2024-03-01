package com.square.game.controller.user;

import com.square.game.controller.dto.UserDTO;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="User")
public class User {
    @Id//cle primaire
    @GeneratedValue(strategy= GenerationType.UUID)//
    private UUID id;

    private String lastName;

    private String firstName;
    private int age;

    public User(){

    }

    public User( String firstName, String lastName,  int age){
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
