package com.eauction.app.controllers;

import com.eauction.app.repositories.ProductRepository;
import com.eauction.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private ProductRepository productRepository;

    @Autowired
    public UserController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public List<Product> getUsers(){
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public void saveUsers(@RequestBody Product product){
        productRepository.save(product);
    }
}
