package net.dat.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.store.dao.ProductDAO;
import net.dat.store.dao.ProductOptionDAO;
import net.dat.store.exception.NotFoundException;
import net.dat.store.model.Product;
import net.dat.store.model.ProductOption;
import net.dat.store.model.User;

@Service
public class ProductService {

	private final ProductDAO productDAO;
	private final ProductOptionDAO productOptionDAO;

	public ProductService(ProductDAO productDAO,ProductOptionDAO productOptionDAO) {
		this.productDAO = productDAO;
		this.productOptionDAO = productOptionDAO;
	}

	public int addProduct(Product p,List<Integer>lstId) {
		int result = productDAO.save(p,lstId);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
		return result;
	}
	
	public int addProductAndOpt(Product p) {
		List<Integer> lstId = new ArrayList<Integer>();
		int result = productDAO.save(p,lstId);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
		Integer productID = lstId.get(0);
		for (ProductOption opt : p.getOptions()) {
			opt.setProductId(productID);	
		}
		productOptionDAO.saveList(p.getOptions());
		return result;
	}
	
	public List<Product> getProducts() {
		List<Product> products= productDAO.getAll();
		for (Product product : products) {
			product.setOptions(productOptionDAO.getOptions(product.getId()));
		}
		return products;
	}
	
	public int deleteById(String id) {
		int result = productDAO.delete(Integer.valueOf(id));
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
		return result;
	}
	
	public Product getById(String id) {
		Product p= productDAO.getById(Integer.valueOf(id))
				.orElseThrow(() -> new NotFoundException(String.format("Product with id % not found", id)));
		p.setOptions(productOptionDAO.getOptions(p.getId()));
		return p;
	}
}
