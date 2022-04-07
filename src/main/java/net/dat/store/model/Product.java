package net.dat.store.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
	private Integer id;
	private String name;
	private BigDecimal price;
	private String description;
	private String images;
	private List<ProductOption> options;

	public List<ProductOption> getOptions() {
		return options;
	}

	public Product() {
		this.options = new ArrayList<ProductOption>();
	}

	public Product(Integer id, String name, BigDecimal price, String description, String images) {
		this(name, price, description, images);
		this.id = id;
	}

	public Product(String name, BigDecimal price, String description, String images) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.images = images;
		this.options = new ArrayList<ProductOption>();
	}

	public boolean addOption(ProductOption opt) {
		if (!options.contains(opt)) {
			opt.setProduct(this);
			options.add(opt);
		}
		return false;
	}

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

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}
