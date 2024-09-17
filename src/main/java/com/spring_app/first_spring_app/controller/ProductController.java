package com.spring_app.first_spring_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_app.first_spring_app.model.Product;
import com.spring_app.first_spring_app.repository.ProductRepo;
import com.spring_app.first_spring_app.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
/*
 * @RequestMapping annotation in the class will act as a base path
 * and in the same class method it will act as a child path
 */
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductService productService;

    @GetMapping // if no @RequestMapping in the class it will look like @GetMapping("/products")
    public List<Product> sendProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{prodId}")
    public Optional<Product> getMethodName(@PathVariable int prodId) {
        return productRepo.findById(prodId);
    }

    @PostMapping
    public Product postMethodName(@RequestBody Product product) {
        productRepo.save(product);
        return product;
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        productRepo.save(product);
        return product;
    }

    @DeleteMapping("/{prodId}")
    public void deleteProduct(@PathVariable int prodId) {
        productRepo.deleteById(prodId);
    }

    @GetMapping("/pagination/{pageNumber}/{pageSize}")
    public Page<Product> productPagination(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return productService.getProductPagination(pageNumber, pageSize);
    }

}
