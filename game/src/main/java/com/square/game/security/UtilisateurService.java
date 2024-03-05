package com.square.game.security;

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
        public UtilisateurService(UtilisateurRepository utilisateurRepository) {
                this.utilisateurRepository = utilisateurRepository;
        }
        public void subscribe(Utilisateur utilisateur){
                String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
                utilisateur.setPassword(mdpCrypte);
                this.utilisateurRepository.save(utilisateur);
        }

}
