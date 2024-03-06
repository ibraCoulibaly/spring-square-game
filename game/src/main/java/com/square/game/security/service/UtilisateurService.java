package com.square.game.security.service;

import com.square.game.security.entity.Utilisateur;
import com.square.game.security.repository.UtilisateurRepository;
import com.square.game.security.repository.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService{
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private final UtilisateurRepository utilisateurRepository;
        @Autowired
        private ValidationService validationService;
        @Autowired
        public UtilisateurService(UtilisateurRepository utilisateurRepository) {
                this.utilisateurRepository = utilisateurRepository;
        }
        public void subscribe(Utilisateur utilisateur){
                String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
                utilisateur.setPassword(mdpCrypte);
                utilisateur = this.utilisateurRepository.save(utilisateur);

                this.validationService.enregistrer(utilisateur);
        }


}
