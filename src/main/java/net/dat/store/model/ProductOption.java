package net.dat.store.model;

public class ProductOption {
	private String id;
	private String productId;
	private String size;
	private String color;
	private Integer quantity;

	public ProductOption() {
		
	}
	
	public ProductOption(String id, String productId, String size, String color, Integer quantity) {
		this.id = id;
		this.productId = productId;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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

	public ProductOption(String productId, String size, String color, Integer quantity) {
		this.productId = productId;
		this.size = size;
		this.color = color;
		this.quantity = quantity;
	}

}
