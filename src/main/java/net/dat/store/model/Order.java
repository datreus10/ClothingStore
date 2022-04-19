package net.dat.store.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
	private String id;
	private String userId;
	private LocalDateTime orderDate;
	private BigDecimal totalPrice;
	private Integer totalQuantity;
	private String address;
	private String phone;
	private String payment;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	

	public Order(String id, String userId, LocalDateTime orderDate, BigDecimal totalPrice, Integer totalQuantity,
			String address, String phone, String payment, String status) {
		this.id = id;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.address = address;
		this.phone = phone;
		this.payment = payment;
		this.status = status;
	}
	
	public Order(String userId, LocalDateTime orderDate, BigDecimal totalPrice, Integer totalQuantity,
			String address, String phone, String payment, String status) {
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.address = address;
		this.phone = phone;
		this.payment = payment;
		this.status = status;
	}

	public Order() {
	}

	public String getDateFormatted() {
	     return orderDate.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));

	}
	
	public String priceFormatted() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(totalPrice)+" VNĐ";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
