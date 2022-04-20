package net.dat.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.store.dao.ProductDAO;
import net.dat.store.dao.ProductOptionDAO;
import net.dat.store.exception.NotFoundException;
import net.dat.store.model.Product;
import net.dat.store.model.ProductOption;

@Service
public class ProductService {

	private final ProductDAO productDAO;
	private final ProductOptionDAO productOptionDAO;

	public ProductService(ProductDAO productDAO,ProductOptionDAO productOptionDAO) {
		this.productDAO = productDAO;
		this.productOptionDAO = productOptionDAO;
	}

//	public int addProduct(Product p,List<Integer>lstId) {
//		int result = productDAO.save(p,lstId);
//		if (result != 1)
//			throw new IllegalStateException("Oop!! Some thing went wrong");
//		return result;
//	}
	
	public int addProductAndOpt(Product p) {
		int result = productDAO.save(p);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
		for (ProductOption opt : p.getOptions()) {
			opt.setProductId(p.getId());	
		}
		productOptionDAO.saveList(p.getOptions());
		return result;
	}
	
	public List<Product> getProducts() {
		List<Product> products= productDAO.get(100);
		for (Product product : products) {
			product.setOptions(productOptionDAO.getOptions(product.getId()));
		}
		return products;
	}
	
	public int deleteById(String id) {
		int result = productDAO.delete(id);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
		return result;
	}
	
	public Product getById(String id) {
		Product p= productDAO.getById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Product with id % not found", id)));
		p.setOptions(productOptionDAO.getOptions(p.getId()));
		return p;
	}
	
	public void update(Product p) {
		productDAO.update(p);
		for (ProductOption opt : p.getOptions()) {
			opt.setProductId(p.getId());
			if(productOptionDAO.update(opt)==0)
				productOptionDAO.save(opt);
		}
	}
}
