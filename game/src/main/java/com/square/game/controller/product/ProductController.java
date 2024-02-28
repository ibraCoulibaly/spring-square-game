package com.square.game.controller.product;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.square.game.controller.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController

public class ProductController {

    @Autowired

    private ProductDAO productDao;

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
 /* @GetMapping(value = "/Produits/{id}")
  public Product afficherUnProduit(@PathVariable int id) {
    return productDao.findById(id);

  }

  //ajouter un produit
  @PostMapping(value = "/Produits")
  public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
    Product productAdded =  productDao.save(product);

    if (productAdded == null)
      return ResponseEntity.noContent().build();

    URI location = ServletUriComponentsBuilder
          .fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(productAdded.getId())
          .toUri();
    return ResponseEntity.created(location).build();
  }*/
}