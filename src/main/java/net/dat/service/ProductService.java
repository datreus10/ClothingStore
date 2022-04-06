package net.dat.service;

import org.springframework.stereotype.Service;

import net.dat.dao.ProductDAO;
import net.dat.model.Product;

@Service
public class ProductService {

	private final ProductDAO productDAO;

	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void addProduct(Product p) {
		int result = productDAO.save(p);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
	}
}
