package com.square.game.security.entity;

import jakarta.persistence.*;

import java.time.Instant;
@Entity
@Table(name = "validation")
public class Validation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private Instant creation;
    private Instant expire;
    private Instant activation;
    private String code;//va contenir le code

    public Validation() {
    }

    public Validation(int id, Instant creation, Instant expire, Instant activation, String code, Utilisateur utilisateur) {
        this.id = id;
        this.creation = creation;
        this.expire = expire;
        this.activation = activation;
        this.code = code;
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getCreation() {
        return creation;
    }

    public void setCreation(Instant creation) {
        this.creation = creation;
    }

    public Instant getExpire() {
        return expire;
    }

    public void setExpire(Instant expire) {
        this.expire = expire;
    }

    public Instant getActivation() {
        return activation;
    }

    public void setActivation(Instant activation) {
        this.activation = activation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @OneToOne(cascade = CascadeType.ALL)//ie la validation ne concerne qu'un seul user et cascadeType.ALL -> si on supprime 1, on sup tout
    private Utilisateur utilisateur;// le user qui seras valider
}
