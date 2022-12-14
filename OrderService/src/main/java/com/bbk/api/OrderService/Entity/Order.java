package com.bbk.api.OrderService.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER_DETAILS")
@Builder
public class Order {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Column(name = "PRODUCT_ID")
//    private long productId;
//
//    @Column(name = "QUANTITY")
//    private long quantity;
//
//    @Column(name = "ORDER_DATE")
//    private Instant orderDate;
//
//    @Column(name = "STATUS")
//    private String OrderStatus;
//
//    @Column(name = "TOTAL_AMOUNT")
//    private long amount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ORDER_DATE")
    private Instant orderDate;

	@Column(name = "STATUS")
	private String orderStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

}
