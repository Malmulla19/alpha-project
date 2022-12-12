package com.bbk.api.OrderService.controller;

import com.bbk.api.OrderService.Entity.Order;
import com.bbk.api.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController extends CrudController<Order, Long> {
    OrderController(OrderRepository orderRepository) {
        super(orderRepository);
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
