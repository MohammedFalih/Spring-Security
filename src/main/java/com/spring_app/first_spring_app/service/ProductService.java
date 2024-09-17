package com.spring_app.first_spring_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring_app.first_spring_app.model.Product;
import com.spring_app.first_spring_app.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public  Page<Product> getProductPagination(int pageNumber, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepo.findAll(pageable);
    }

}
// List<Product> products = new ArrayList<>(Arrays.asList(
// new Product(121, "Samsung S24 Ultra", 148999),
// new Product(145, "Apple Iphone 15 pro", 148000),
// new Product(105, "Iphone 15 promax", 160000)));

// public List<Product> getProducts() {
// return products;
// }

// public Product getProductById(int prodId) {
// return products.stream()
// .filter(p -> p.getId() == prodId)
// .findFirst().orElse(new Product(000, "No Item", 000));
// }

// public void addProduct(Product product) {
// products.add(product);
// }

// public void updateProduct(Product product) {
// int index = 0;
// for (int i = 0; i < products.size(); i++) {
// if (products.get(i).getId() == product.getId()) {
// index = i;
// }
// }
// products.set(index, product);
// }

// public void deleteProduct(int prodId) {
// int index = 0;
// for (int i = 0; i < products.size(); i++) {
// if (products.get(i).getId() == prodId) {
// index = i;
// }
// }
// products.remove(index);
// }
