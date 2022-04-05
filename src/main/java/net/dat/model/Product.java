package net.dat.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Product {
	private Integer id;
	private String name;
	private BigDecimal price;
	private String description;
	private List<String> images;

	public Set<ProductOption> getOptions() {
		return options;
	}

	public void setOptions(Set<ProductOption> options) {
		this.options = options;
	}

	private Set<ProductOption> options;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

}
