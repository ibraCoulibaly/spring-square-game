package com.square.game.security;

import com.square.game.controller.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
//    @Query(" select u from Utilisateur u " +
//            " where u.username = ?1")
    Optional<Utilisateur> findByUsername(String username);
}
