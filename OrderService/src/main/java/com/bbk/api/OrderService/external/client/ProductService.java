package com.bbk.api.OrderService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "productService", url = "http://localhost:8080/product")
public interface ProductService {
    @RequestMapping(method = RequestMethod.PUT, value = "/reduceQuantity/{id}")
    Void reduceQuantity(@PathVariable Long id, @RequestParam long quantity);
}

//
//@FeignClient("localhost:8080/product")
//public interface ProductService {
//    @PutMapping("/reduceQuantity/{id}")
//    void reduceQuantity(@PathVariable Long id, @RequestParam long quantity);
//}
