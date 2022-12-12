package com.bbk.api.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bbk.api.productservice.Entity.Product;

@Service
public interface ProductService {
    Product getProduct(long id);

    List<Product> getAllProducts();

    long addProduct(Product product);

    Long removeProduct(long id);
}
