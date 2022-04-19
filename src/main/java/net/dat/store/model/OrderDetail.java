package net.dat.store.model;


import java.math.BigDecimal;

public class OrderDetail {
	private String id;
	private String orderId;
	private String productOptionId;
	private Integer quantity;
	private BigDecimal totalPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getproductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(String productOptionId) {
		this.productOptionId = productOptionId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
