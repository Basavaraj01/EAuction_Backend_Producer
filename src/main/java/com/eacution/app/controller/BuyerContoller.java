package com.eacution.app.controller;

import com.eacution.app.NotFoundException;
import com.eacution.app.entity.Buyer;
import com.eacution.app.entity.Product;
import com.eacution.app.repository.BuyerRepository;
import com.eacution.app.repository.ProductRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.*;

@RestController
public class BuyerContoller {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/buyer/place-bid")
        public ResponseEntity<String> createUser(@Valid @RequestBody Buyer buyer) {
        List<Buyer> buyerList =buyerRepository.findAll();
        if(buyerList.stream().anyMatch(n->n.getEmail().equals(buyer.getEmail())))
        {
            throw new ValidationException("You cannot bid the product twice using the same emailId!");
        }

        Optional<Product> product=productRepository.findById(buyer.getProductId());
        Product pro=product.get();
        pro.getBidEndDate();
        Date date=new Date();
        if ( pro.getBidEndDate().compareTo((date))< 0) {
            System.out.println("the date is after");
            throw new ValidationException("You cannot bid the product after the bid enddate");
        }
        buyerRepository.save(buyer);
        return ResponseEntity.ok("Data Saved Successfully");
    }

    @GetMapping("/buyer/allbids")
    public List<Buyer> retrieveAllBids() {
        return buyerRepository.findAll();
    }

    @PutMapping ("/buyer/update-bid/{productId}/{buyerEmailId}/{newBidAmount}")
    public String createUsers(@PathVariable Integer productId,@PathVariable String buyerEmailId,@PathVariable String newBidAmount
      ) {
        Buyer buyer=buyerRepository.findByEmailAndProduct(buyerEmailId,productId);
        if(buyer==null){
            throw new NotFoundException("Either productId "+productId+" or buyerEmailId "+ buyerEmailId+" is not found");
        }
        buyer.setProductId(productId);
        buyer.setEmail(buyerEmailId);
        buyer.setBidAmount(newBidAmount);
        buyerRepository.save(buyer);
        return "data added successfully";
    }

}
