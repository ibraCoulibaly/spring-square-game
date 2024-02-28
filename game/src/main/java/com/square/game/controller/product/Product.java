package com.square.game.controller.product;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@JsonFilter("monFiltreDynamique")
@Entity
public class Product {
    @Id
    private int id;
    private String nom;
    private int prix;

    //information que nous ne souhaitons pas exposer
    private int prixAchat;

}