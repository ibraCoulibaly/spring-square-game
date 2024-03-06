package com.square.game.security.entity;

import com.square.game.security.controller.UtilisateurDTO;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Entity
@Table(name="utilisateur")
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    public Utilisateur() {

    }

    public Utilisateur(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UtilisateurDTO toUserDTO(Utilisateur utilisateur){
        return new UtilisateurDTO(utilisateur.getId(), utilisateur.getUsername(), utilisateur.getPassword());
    }
    public static Utilisateur toUser(UtilisateurDTO utilisateurDTO){
        return new Utilisateur(utilisateurDTO.id(), utilisateurDTO.username(), utilisateurDTO.password());
    }
}
