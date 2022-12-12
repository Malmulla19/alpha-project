package com.bbk.api.productservice.controller;

import com.bbk.api.productservice.Entity.Product;
import com.bbk.api.productservice.model.ProductRequest;
import com.bbk.api.productservice.repository.ProductRepository;
import com.bbk.api.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.getProduct(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> create(@RequestBody ProductRequest productRequest) {
        Product product = Product
                .builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity()).build();

        long productId = this.productService
                .addProduct(product);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Product updatedProduct) {
        Product product = productService.getProduct(id);
        BeanUtils.copyProperties(updatedProduct, product, "id");

        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.removeProduct(id), HttpStatus.OK);
    }
}
