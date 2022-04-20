package net.dat.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.store.dao.OrderDetailDAO;
import net.dat.store.dao.ProductDAO;
import net.dat.store.dao.ProductOptionDAO;
import net.dat.store.exception.NotFoundException;
import net.dat.store.model.OrderDetail;
import net.dat.store.model.Product;
import net.dat.store.model.ProductOption;

@Service
public class OrderDetailService {
	private final OrderDetailDAO orderDetailDAO;
	private final ProductOptionDAO productOptionDAO;
	private final ProductDAO productDAO;

	public OrderDetailService(OrderDetailDAO orderDetailDAO, ProductOptionDAO productOptionDAO, ProductDAO productDAO) {
		this.orderDetailDAO = orderDetailDAO;
		this.productOptionDAO = productOptionDAO;
		this.productDAO = productDAO;
	}

	public List<OrderDetail> getByOrderId(String id) {
		List<OrderDetail> result = orderDetailDAO.getByOrderId(id);
		for (OrderDetail detail : result) {
			String optionId = detail.getproductOptionId();
			ProductOption option = productOptionDAO.getById(optionId)
					.orElseThrow(() -> new NotFoundException(String.format("Option with id %s not found", optionId)));
			Product product = productDAO.getById(option.getProductId()).orElseThrow(
					() -> new NotFoundException(String.format("Product with id %s not found", option.getProductId())));
			option.setProduct(product);
			detail.setProductOption(option);
		}
		return result;
	}

}
