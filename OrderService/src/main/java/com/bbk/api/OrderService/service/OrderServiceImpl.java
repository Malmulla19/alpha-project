package com.bbk.api.OrderService.service;

import com.bbk.api.OrderService.Entity.Order;
import com.bbk.api.OrderService.model.OrderRequest;
import com.bbk.api.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("Placing the Order Request");
        new ArrayList<String>();

        //Order order = Order.builder()
        //        .amount(orderRequest.getTotalAmount())
        //        .orderStatus("CREATED")
        //        .productId(orderRequest.getProductId())
        //        .quantity(orderRequest.getQuantity())
        //        .orderDate(Instant.now())
        //        .build();
        Order order = Order.builder().build();

        order = orderRepository.save(order);

        return order.getId();
    }

}
