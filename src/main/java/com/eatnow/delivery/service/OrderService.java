package com.eatnow.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatnow.delivery.bean.OrderEntity;
import com.eatnow.delivery.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public void placeOrder(OrderEntity orderEntity) {
		orderRepository.save(orderEntity);
	}
	public List<OrderEntity> getAllOrderDetails(){
		return orderRepository.findAll();
	}
}
