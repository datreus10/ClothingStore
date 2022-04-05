package net.dat.dao;

import java.util.List;
import java.util.Optional;

import net.dat.model.Product;

public interface ProductDAO {

	int add(Product newProduct);

	List<Product> getAll();

	Optional<Product> getById(Integer id);

	int update(Product product);

	int delete(Integer id);
}
