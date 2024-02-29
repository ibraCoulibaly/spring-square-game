package com.square.game.controller.product;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private String nom;
    private int prix;
    private int prixAchat;
    public int getId() {
        return id;
    }
}