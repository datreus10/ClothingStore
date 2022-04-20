package net.dat.store.dao;

import java.util.List;
import java.util.Optional;

import net.dat.store.model.ProductOption;

public interface ProductOptionDAO {
	int save(ProductOption pOption);

	int[] saveList(List<ProductOption> options);

	List<ProductOption> getOptions(String productId);

	Optional<ProductOption> getById(String id);
	
	int update(ProductOption opt);

	int deleteById(String id);
}
