package com.bbk.api.OrderService.controller;

import com.bbk.api.OrderService.Entity.Order;
import com.bbk.api.OrderService.Entity.OrderLine;
import com.bbk.api.OrderService.external.client.ProductService;
import com.bbk.api.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController extends CrudController<Order, Long> {

    OrderRepository orderRepository;
    ProductService productService;

    OrderController(OrderRepository orderRepository, ProductService productService) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order newOrder = Order.builder()
                .orderDate(Instant.now())
                .orderStatus("TESTTTT")
                .build();
        Order finalNewOrder = newOrder;
        


        List<OrderLine> orderLines = order.getOrderLines().stream().map(line -> {
            line.setOrder(finalNewOrder);
            productService.reduceQuantity(line.getProductId(), line.getQuantity());
            return line;
        }).collect(Collectors.toList());

        newOrder.setOrderLines(orderLines);

        newOrder = orderRepository.save(newOrder);
        
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    //    @Autowired
    //    OrderService orderService;
    //
    //    @GetMapping
    //    public ResponseEntity<?> view() {
    //        return new ResponseEntity<>(this.orderService.getAllOrders(), HttpStatus.OK);
    //    }
    //
    //    @PostMapping
    //    public ResponseEntity<Long> create(@RequestBody OrderRequest orderRequest) {
    //        long orderId = orderService.placeOrder(orderRequest);
    //        return new ResponseEntity<>(orderId, HttpStatus.OK);
    //    }

}
