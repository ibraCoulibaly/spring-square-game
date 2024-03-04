//package com.square.game.controller.product;
//
//import com.fasterxml.jackson.databind.ser.FilterProvider;
//import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
//import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//
//import com.square.game.controller.user.AuthenticationParams;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.json.MappingJacksonValue;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.Date;
//import java.util.List;
//
//
//@RestController
//public class ProductController {
//    @Autowired
//    private ProductDAO productDao;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//    //Récupérer la liste des produits
//    @RequestMapping(value = "/ProduitsList", method = RequestMethod.GET)
//
//    public MappingJacksonValue listeProduits() {
//
//        Iterable<Product> produits = productDao.findAll();
//
//        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
//
//        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
//
//        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);
//
//        produitsFiltres.setFilters(listDeNosFiltres);
//
//        return produitsFiltres;
//    }
//
//    //Récupérer un produit par son Id
//    @GetMapping(value = "/Produits/{id}")
//    public Product afficherUnProduit(@PathVariable int id) {
//        return productDao.findById(id);
//
//    }
//
//    @PostMapping("/login")
//    public void login(@RequestBody AuthenticationParams params) {
//        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(params.username(), params.password());
//        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
//    }
//
//
//
//    //ajouter un produit
//    @PostMapping(value = "/ad/Produits")
//    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
//        Product productAdded =  productDao.save(product);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(productAdded.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
//
//    @GetMapping(value = "test/produits/{prixLimit}")
//    public List<Product> testeDeRequetes(@PathVariable int prixLimit)
//    {
//        return productDao.findByPrixGreaterThan(400);
//    }
//
//    @DeleteMapping (value = "/sup/Produits/{id}")
//    public void supprimerProduit(@PathVariable int id) {
//        productDao.deleteById(id);
//    }
//
//    @PutMapping (value = "/up/Produits")
//    public void updateProduit(@RequestBody Product product) {
//        productDao.save(product);
//
//    }
//
//}