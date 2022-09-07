package com.eacution.app.controller;

import com.eacution.app.NotFoundException;
import com.eacution.app.entity.Buyer;
import com.eacution.app.entity.Product;
import com.eacution.app.kafka.JsonKafkaProducer;
import com.eacution.app.repository.BuyerRepository;
import com.eacution.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://react-eauction.s3-website-us-east-1.amazonaws.com")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private JsonKafkaProducer kafkaProducer;

    @PostMapping("/seller/add-product")
    public ResponseEntity<String> retrieveSellerById(@Valid @RequestBody Product product) {
         productRepository.save(product);
        kafkaProducer.sendMessage(product);
        return ResponseEntity.ok("Data Saved Successfully");
    }


    @GetMapping("/seller/products")
    public List<Product> retrieveProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/seller/show-bids/{productId}")
    public List<Buyer> retrieveProductsById(@PathVariable int productId) {
        List<Buyer> buyers=buyerRepository.findByProductId(productId);
        if(buyers.isEmpty()){
            throw new NotFoundException("productId "+productId+" is not found");
        }
        return buyers;
    }

    @DeleteMapping ("/seller/delete/{productId}")
    public String removeProductsById(@PathVariable int productId) throws ValidationException {
       Optional<Product> productList= productRepository.findById(productId);
        if(!productList.isPresent()){
            throw new NotFoundException("productId "+productId+" is not found");
        }
       Product p=productList.get();
        Date date = new Date();
        if (p.getBidEndDate().compareTo((date))< 0) {
            System.out.println("the date is after");
            throw new ValidationException("You cannot delete the product after the bid enddate");
        }
        List<Buyer> buyerList =buyerRepository.findByProductId(productId);
        if (buyerList.stream().anyMatch(n->n.getProductId().equals(productId))) {
            System.out.println("the date is after");
            throw new ValidationException("You cannot delete due to some reason");
        }
        return "Data Deleted";
    }
}
