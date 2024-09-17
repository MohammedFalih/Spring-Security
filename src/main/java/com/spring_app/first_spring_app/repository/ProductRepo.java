package com.spring_app.first_spring_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring_app.first_spring_app.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}