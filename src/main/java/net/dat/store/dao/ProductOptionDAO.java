package net.dat.store.dao;

import java.util.List;

import net.dat.store.model.ProductOption;

public interface ProductOptionDAO {
	int save(ProductOption pOption);

	int[] saveList(List<ProductOption> options);
	
	List<ProductOption> getOptions(Integer productId);
	int deleteById(Integer id);
}
