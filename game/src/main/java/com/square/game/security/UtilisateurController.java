package com.square.game.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    //private AuthenticationManager authenticationManager;

    @PostMapping("/subscribe")
    public void inscription(@RequestBody UtilisateurDTO utilisateurDTO){
        //log.info("inscription is worked");
        this.utilisateurService.subscribe(Utilisateur.toUser(utilisateurDTO));
    }

//    @PostMapping(value = "/connexion")
//    public Map<String, String> connexion(@RequestBody AuthentificationDTO param) {
//        Authentication authenticated = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(param.username(), param.password())
//        );
//        LOGGER.info("result {}", authenticated.isAuthenticated());
//        return null;
//    }


}
