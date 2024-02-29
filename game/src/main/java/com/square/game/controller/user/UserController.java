package com.square.game.controller.user;



import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.square.game.controller.dto.UserDTO;

import com.square.game.controller.product.Product;
import com.square.game.controller.product.ProductDAO;
import com.square.game.controller.user.dao.UserDAO;
import com.square.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Qualifier("sqlUserDAO")
    private UserDAO userDAO;
    @Autowired
    private ProductDAO productDao;

    @PostMapping("/users")
    public UserDTO createUserDTO(@RequestBody User user){
        userDAO.addUser(user);
        return User.toUserDTO(user);
    }
    @GetMapping("/listUsers")
    public Collection<UserDTO> getListUser(){
        return userDAO.getAllUsers().stream().map(User::toUserDTO).toList();
    }
    @GetMapping("/listUsers/{userId}")
    public UserDTO getUser(@PathVariable UUID userId){
        User user = userDAO.getUserById(userId);
        return User.toUserDTO(user);
    }
    @DeleteMapping("/listUsers/sup/{userId}")
    public Collection<UserDTO> supUser(@PathVariable UUID userId){
        userDAO.deleteUser(userId);
        return getListUser();
    }
    @PutMapping("/listUsers/up/{userId}")
    public UserDTO upUser(@PathVariable UUID userId, @RequestBody User user){
        User user1 = userDAO.updateUser(userId, user);
        user1.setId(userId);
        return User.toUserDTO(user1);
    }

    /*--------------------------------------------------------
    * Controller to test Repository
    *---------------------------------------------------------*/


    @PostMapping("/usersRepo")
    public UserDTO createUserDTOForRepo(@RequestBody UserCreationParam param){
        User user1 = new User(param.firstName(), param.lastName(), param.age());
        userRepository.save(user1);
        return User.toUserDTO(user1);
    }
    @GetMapping("/listUsersRepo")
    public Collection<UserDTO> getListUserForRepo(){
        return userRepository.findAll().stream().map(User::toUserDTO).toList();

    }
    @GetMapping("/listUsersRepo/{userId}")
    public UserDTO getUserForRepo(@PathVariable UUID userId){
        User user = userRepository.getReferenceById(userId);
        return User.toUserDTO(user);
    }
    @DeleteMapping("/listUsersRepo/sup/{userId}")
    public Collection<UserDTO> supUserForRepo(@PathVariable UUID userId){
        userRepository.deleteById(userId);
        return getListUserForRepo();
    }
    @PutMapping("/listUsersRepo/up/{userId}")
    public UserDTO updateUserForRepo(@PathVariable UUID userId, @RequestBody UserCreationParam param){
        return User.toUserDTO(userRepository.updateUserForRepoImpl(userId, param));
    }

    /*--------------------------------------------------------
     * Controller to test H2
     *---------------------------------------------------------*/



    //Récupérer la liste des produits
    @RequestMapping(value = "/Produits", method = RequestMethod.GET)

    public MappingJacksonValue listeProduits() {

        Iterable<Product> produits = productDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }

    //Récupérer un produit par son Id
  @GetMapping(value = "/Produits/{id}")
  public Product afficherUnProduit(@PathVariable int id) {
    return productDao.findById(id);

  }

  //ajouter un produit
  @PostMapping(value = "/Produits")
  public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
    Product productAdded =  productDao.save(product);

      URI location = ServletUriComponentsBuilder
          .fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(productAdded.getId())
          .toUri();
    return ResponseEntity.created(location).build();
  }

    @GetMapping(value = "test/produits/{prixLimit}")
    public List<Product> testeDeRequetes(@PathVariable int prixLimit)
    {
        return productDao.findByPrixGreaterThan(400);
    }

    @DeleteMapping (value = "/Produits/{id}")
    public void supprimerProduit(@PathVariable int id) {
        productDao.deleteById(id);
    }

    @PutMapping (value = "/Produits")
    public void updateProduit(@RequestBody Product product)
    {
        productDao.save(product);
    }





}