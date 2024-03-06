package com.square.game.security.repository;

import com.square.game.security.entity.Utilisateur;
import com.square.game.security.entity.Validation;
import org.springframework.data.repository.CrudRepository;

public interface ValidationRepository extends CrudRepository<Validation, Integer> {
    String getValidation(String code);
}
