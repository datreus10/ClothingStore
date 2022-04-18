package net.dat.store.service;

import org.springframework.stereotype.Service;

import net.dat.store.dao.ProductOptionDAO;

@Service
public class ProductOptionService {
	private final ProductOptionDAO productOptionDAO;

	public ProductOptionService(ProductOptionDAO productOptionDAO) {
		this.productOptionDAO = productOptionDAO;
	}
	
	public int deleteById(String id) {
		int result = productOptionDAO.deleteById(Integer.valueOf(id));
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
		return result;
	}
}
