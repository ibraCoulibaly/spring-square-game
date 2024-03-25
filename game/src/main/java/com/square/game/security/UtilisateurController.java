package com.square.game.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final String SECRET_KEY = "okerqhfoglsqelosqbflohQP0FYhokerqhfoglsqelosqbflohQP0FYhokerqhfoglsqelosqbflohQP0FYhokerqhfoglsqelosqbflohQP0FYh";
    private static final long EXPIRATION_TIME = 300000;
    @PostMapping("/api/public/subscribe")
    public void inscription(@RequestBody UtilisateurDTO utilisateurDTO){
        this.utilisateurService.subscribe(Utilisateur.toUser(utilisateurDTO));
    }

    @PostMapping("/api/public/login")
    public ResponseEntity<String> getUser(@RequestBody UtilisateurDTO user){
        UtilisateurDTO u = Utilisateur.toUserDTO(utilisateurService.loadUserByUsername(user.username()));
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(user.username(), user.password());
        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);

        // Générer le token
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        String jwt = Jwts.builder()
                .setSubject(user.username())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        // Mettre le token dans le header 'Authorization'

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Autorization",jwt);

        return ResponseEntity.ok()
                .headers(responseHeaders).build();
    }


}
