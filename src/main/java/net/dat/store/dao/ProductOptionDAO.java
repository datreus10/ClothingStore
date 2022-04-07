package net.dat.store.dao;

import java.util.List;

import net.dat.store.model.ProductOption;

public interface ProductOptionDAO {
	int add(ProductOption pOption);

	int[] addList(List<ProductOption> options);
}
