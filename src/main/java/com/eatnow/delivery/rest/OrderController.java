package com.eatnow.delivery.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eatnow.delivery.bean.OrderEntity;
import com.eatnow.delivery.service.OrderService;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	private static Logger logger = LogManager.getLogger(OrderController.class);

	@PostMapping(path = "/place")
	public void placeOrder(@RequestBody OrderEntity orderEntity) {
		logger.info("Entered into place order method");
		orderService.placeOrder(orderEntity);
	}
	
	@GetMapping(path = "/testdetails")
	public OrderEntity orderDetails() {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(1);
		orderEntity.setOrderName("Biriyani");
		orderEntity.setFullOrHalf("full");
		orderEntity.setQuantity(1);
		orderEntity.setRestaurantName("mastan vali restaurant");
		orderEntity.setPrice(371.00);
		return orderEntity;
	}
	@GetMapping(path = "/details/{orderId}")
	public OrderEntity getOrderDetails(@PathVariable(name = "orderId") Long orderId) {
		
		return orderService.getOrderDetailsById(orderId);
	}
	@GetMapping(path = "/details/all")
	public List<OrderEntity> getAllOrderDetails(){
		List<OrderEntity> allOrderDetails = orderService.getAllOrderDetails();
		allOrderDetails.forEach(orderDetails->System.out.println(orderDetails));
		return allOrderDetails;
	}
	@GetMapping(path = "/delete/all")
	public List<OrderEntity> deleteAll(){
		List<OrderEntity> allOrderDetails = orderService.getAllOrderDetails();
		allOrderDetails.forEach(orderDetails->System.out.println(orderDetails));
		return allOrderDetails;
	}
}
