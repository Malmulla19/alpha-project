package com.bbk.api.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbk.api.productservice.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
