package net.dat.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.store.dao.ProductDAO;
import net.dat.store.model.Product;
import net.dat.store.model.User;

@Service
public class ProductService {

	private final ProductDAO productDAO;

	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public int addProduct(Product p,List<Integer>lstId) {
		int result = productDAO.save(p,lstId);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
		return result;
	}
	
	public List<Product> getProducts() {
		return productDAO.getAll();
	}
}
