package com.eacution.app.controller;

import com.eacution.app.repository.SellerRepository;
import com.eacution.app.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping("/seller/{id}")
    public Optional<Seller> retrieveSellerById(@PathVariable Long id) {
        return sellerRepository.findById(id);
    }

    @GetMapping("/seller")
    public List<Seller> retrieveAllSellers() {
        List<Seller> sellerList=new ArrayList<>();
        sellerList =sellerRepository.findAll();
        return sellerList;
    }

    @PostMapping("/seller")
    public ResponseEntity<String> createUser(@Valid @RequestBody Seller seller) {
        sellerRepository.save(seller);
        return ResponseEntity.ok("Data Saved Successfully");
    }

}
