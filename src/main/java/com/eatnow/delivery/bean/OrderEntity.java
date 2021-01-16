package com.eatnow.delivery.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_entity")
@Data
public class OrderEntity {
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	protected long orderId;
	@Column(name = "order_name")
	protected String orderName;
	protected double price;
	@Column(name = "restaurant_name")
	protected String restaurantName;
	@Column(name = "full_or_half")
	protected String fullOrHalf;
	protected int quantity;
}
