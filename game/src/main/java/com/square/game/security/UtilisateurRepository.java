package com.square.game.security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
    @Query(" select u from Utilisateur u " +
            " where u.username = ?1")
    Optional<Utilisateur> findByUsername(String username);
}
