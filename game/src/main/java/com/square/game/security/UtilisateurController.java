package com.square.game.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
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
    public String getUser(@RequestBody UtilisateurDTO user){
        UtilisateurDTO u = Utilisateur.toUserDTO(utilisateurService.loadUserByUsername(user.username()));

        /*if(u.password().equals(passwordEncoder.encode(user.password())))
            System.out.println("LOGGED IN"+u);
        else
            System.out.println("FAIL"+u+user+passwordEncoder.encode(user.password()));*/

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

        return jwt;
    }

    @GetMapping("/test")
    public void test(){

    }


}
