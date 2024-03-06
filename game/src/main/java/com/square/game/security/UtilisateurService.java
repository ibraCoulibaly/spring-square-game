package com.square.game.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
@Service
public class UtilisateurService implements UserDetailsService {
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private final UtilisateurRepository utilisateurRepository;
        private static final String SECRET_KEY = "votre_clé_secrète";
        private static final long EXPIRATION_TIME = 86400000; // 1 jour en millisecondes

        @Autowired
        public UtilisateurService(UtilisateurRepository utilisateurRepository) {
                this.utilisateurRepository = utilisateurRepository;
        }
        public void subscribe(Utilisateur utilisateur){
                String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
                utilisateur.setPassword(mdpCrypte);
                this.utilisateurRepository.save(utilisateur);
        }

        @Override
        public Utilisateur loadUserByUsername(String username) throws UsernameNotFoundException {
                Objects.requireNonNull(username);
                Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
                return utilisateur;
        }


}
