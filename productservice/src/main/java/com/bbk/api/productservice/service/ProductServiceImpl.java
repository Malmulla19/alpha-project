package com.bbk.api.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbk.api.productservice.Entity.Product;
import com.bbk.api.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProduct(long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public long addProduct(Product product) {
        return this.productRepository.save(product).getProductId();
    }

    @Override
    public Long removeProduct(long id) {
        this.productRepository.deleteById(id);
        return id;
    }

    @Override
    public void reduceQuantity(long id, long quantity) throws Exception {
        Product product = this.productRepository.findById(id).get();
        if ((product.getQuantity() - quantity) < 0) {
            throw new Exception("Run out of stock");
        }
        
        product.setQuantity(product.getQuantity() - quantity);
        
        productRepository.save(product);
    }
}
