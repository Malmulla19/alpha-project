package com.bbk.api.OrderService.service;

import com.bbk.api.OrderService.model.OrderRequest;

public interface OrderService {

	public long placeOrder(OrderRequest orderRequest);

}
