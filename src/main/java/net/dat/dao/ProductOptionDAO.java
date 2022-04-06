package net.dat.dao;

import java.util.List;

import net.dat.model.ProductOption;

public interface ProductOptionDAO {
	int add(ProductOption pOption);

	int[] addList(List<ProductOption> options);
}
