package by.serialnumber.dao;

import java.util.List;

import by.serialnumber.domain.entity.Product;

public interface BasicDao {
	
	List<Product> readProductsList();

}
