package net.dat.store.dao;

import java.util.List;
import java.util.Optional;

import net.dat.store.model.Product;



public interface ProductDAO {

	int save(Product newProduct);

	List<Product> getAll();

	Optional<Product> getById(Integer id);

	int update(Product product);

	int delete(Integer id);
}