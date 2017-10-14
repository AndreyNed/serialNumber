package by.serialnumber.service.impl;

import java.util.List;

import by.serialnumber.dao.BasicDao;
import by.serialnumber.dao.impl.DaoExcell;
import by.serialnumber.domain.entity.Product;
import by.serialnumber.service.BasicService;

public class ServiceExcel implements BasicService {

	@Override
	public List<Product> getProductsList() {
		List<Product> list = null;
		BasicDao dao = new DaoExcell();
		list = dao.readProductsList();
		return list;
	}

}
