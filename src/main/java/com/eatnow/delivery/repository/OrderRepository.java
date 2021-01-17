package com.eatnow.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatnow.delivery.bean.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	public OrderEntity findByOrderId(Long orderId);
}
