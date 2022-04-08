package net.dat.store.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
	private Integer id;
	private Integer userId;
	private LocalDateTime orderDate;
	private BigDecimal totalPrice;
	private Integer totalQuantity;
	private String payment;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUser_id(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order(Integer id, Integer userId, LocalDateTime orderDate, BigDecimal totalPrice, Integer totalQuantity,
			String payment, String status) {
		this.id = id;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.payment = payment;
		this.status = status;
	}
	
	public Order(Integer userId, LocalDateTime orderDate, BigDecimal totalPrice, Integer totalQuantity,
			String payment, String status) {
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.payment = payment;
		this.status = status;
	}

}
