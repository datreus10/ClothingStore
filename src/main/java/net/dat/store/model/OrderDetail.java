package net.dat.store.model;


import java.math.BigDecimal;

public class OrderDetail {
	private Integer id;
	private Integer orderId;
	private Integer productOptionId;
	private Integer quantity;
	private BigDecimal totalPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getproductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(Integer productOptionId) {
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
