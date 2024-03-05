package com.square.game.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UtilisateurService implements UserDetailsService {

        private BCryptPasswordEncoder passwordEncoder;
        private final UtilisateurRepository utilisateurRepositoryu;

        public void subscribe(Utilisateur utilisateur){
                //String mdpCrype = this.passwordEncoder.encode(utilisateur.getPassword());
                //utilisateur.setPassword(mdpCrype);
                this.utilisateurRepositoryu.save(utilisateur);
        }
        @Autowired
        public UtilisateurService(UtilisateurRepository utilisateurRepositoryu) {

                this.utilisateurRepositoryu = utilisateurRepositoryu;
        }

        @Override
        public UserDetails loadUserByUsername(String username) {
            return this.utilisateurRepositoryu.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }

}
