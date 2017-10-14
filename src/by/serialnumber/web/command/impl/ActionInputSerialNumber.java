package by.serialnumber.web.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.serialnumber.domain.entity.Product;
import by.serialnumber.service.BasicService;
import by.serialnumber.service.impl.ServiceExcel;
import by.serialnumber.web.command.BasicAction;

public class ActionInputSerialNumber implements BasicAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Input action...");
		/*RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/form.jsp" );
		dispatcher.forward(request, response);*/
		BasicService service = new ServiceExcel();
		List<Product> list = service.getProductsList();
		
		request.setAttribute("list", list);
		return "WEB-INF/form.jsp";
	}

}
