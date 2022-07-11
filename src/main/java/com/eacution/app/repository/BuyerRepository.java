package com.eacution.app.repository;


import com.eacution.app.entity.Buyer;
import com.eacution.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

   // public Buyer findByName(String email);

    public List<Buyer> findByProductId(Integer productId);

    @Query("SELECT e from Buyer e where e.email =:email AND e.productId =:productId")
    Buyer findByEmailAndProduct(@Param("email") String email,@Param("productId")Integer productId);

    }