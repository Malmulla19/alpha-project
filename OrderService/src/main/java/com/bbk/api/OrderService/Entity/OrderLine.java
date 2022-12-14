package com.bbk.api.OrderService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "UNIT_PRICE")
    private long unitPrice;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "TOTAL_PRICE")
    private long totalPrice;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
