package com.square.game.dao.user;

public class User {
    private int id;

    private String lastName;

    private String firstName;

    private int age;

    public User(int id, String lastName, String firstName, int age){
        this.id = id; //+ (int)(Math.random() * ((247 - id) +1));
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
}
