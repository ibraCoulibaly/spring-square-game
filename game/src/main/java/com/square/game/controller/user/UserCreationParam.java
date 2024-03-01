package com.square.game.controller.user;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

//public record UserCreationParam(String lastName, String firstName, int age) {
//}


public class UserCreationParam {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private int age;

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }




    public int getAge() {
        return age;
    }


}