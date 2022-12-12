package com.bbk.api.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbk.api.OrderService.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
