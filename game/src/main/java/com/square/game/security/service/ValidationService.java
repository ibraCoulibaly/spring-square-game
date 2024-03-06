package com.square.game.security.service;

import com.square.game.security.entity.Utilisateur;
import com.square.game.security.entity.Validation;
import com.square.game.security.repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
public class ValidationService {
    @Autowired
    private ValidationRepository validationRepository;
    //Stocker une validation
    public void enregistrer(Utilisateur utilisateur){
        Validation validation = new Validation();
        validation.setUtilisateur(utilisateur);
        Instant creation = Instant.now();
        validation.setCreation(creation);

        Instant expiration = creation.plus(10, ChronoUnit.MINUTES);
        validation.setExpire(expiration);

        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);
        validation.setCode(code);

        this.validationRepository.save(validation);

        this.validationRepository.getValidation(validation.getCode());
    }
}
