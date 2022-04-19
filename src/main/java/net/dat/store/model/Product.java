package net.dat.store.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class Product {
	private String id;
	private String name;
	private BigDecimal price;
	private String description;
	private String images;
	private List<ProductOption> options;
	
	
	public List<ProductOption> getOptions() {
		return options;
	}

	public void setOptions(List<ProductOption> options) {
		this.options = options;
	}

	public Product() {
		
	}

	public Product(String id, String name, BigDecimal price, String description, String images) {
		this(name, price, description, images);
		this.id = id;
		
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", images=" + images + "]";
	}

	public Product(String name, BigDecimal price, String description, String images) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.images = images;
		
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String priceFormatted() {
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(price)+" VNĐ";
	}
}
