package net.dat.store.model;

public class ProductOption {
	private Integer id;
	private Integer productId;
	private String size;
	private String color;
	private Integer quantity;

	public ProductOption(Integer id, Integer productId, String size, String color, Integer quantity) {
		this.id = id;
		this.productId = productId;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductOption(Integer productId, String size, String color, Integer quantity) {
		this.productId = productId;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}

}
