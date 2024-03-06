//package com.square.game.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class AuthenticationController {
//    @Autowired
//    private UtilisateurService utilisateurService;
//
//    @PostMapping("/api/public/login")
//    public void subscribe(@RequestBody AuthentificationDTO authentificationDTO){
//        this.utilisateurService.subscribe(Utilisateur.toAuth(authentificationDTO));
//    }
//
//}
