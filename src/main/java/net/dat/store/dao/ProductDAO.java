package net.dat.store.dao;

import java.util.List;
import java.util.Optional;

import net.dat.store.model.Product;

public interface ProductDAO {

	int save(Product newProduct);

	List<Product> get(int limit);

	Optional<Product> getById(String id);

	int update(Product product);

	int delete(String id);
}
