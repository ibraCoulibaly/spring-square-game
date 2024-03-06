package com.square.game.security.controller;

import com.square.game.security.entity.Utilisateur;
import com.square.game.security.entity.Validation;
import com.square.game.security.repository.ValidationRepository;
import com.square.game.security.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ValidationRepository validationRepository;

    @PostMapping("/subscribe")
    public void inscription(@RequestBody UtilisateurDTO utilisateurDTO){
        this.utilisateurService.subscribe(Utilisateur.toUser(utilisateurDTO));
    }

    @GetMapping("/code")
    public String getCodeValidation(UtilisateurDTO utilisateurDTO){
        Validation validation = new Validation();
        Utilisateur user = Utilisateur.toUser(utilisateurDTO);
        validation.setUtilisateur(user);
        return validationRepository.getValidation(validation.getCode());
    }


}
