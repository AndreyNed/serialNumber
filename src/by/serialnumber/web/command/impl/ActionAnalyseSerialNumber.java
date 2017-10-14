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

public class ActionAnalyseSerialNumber implements BasicAction {

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("analyse action for: ");
		String serial = request.getParameter( "serial" );
		if ( serial != null ) {
			System.out.println( "Serial: " + serial );
			BasicService service = new ServiceExcel();
			List<Product> products = service.getProductsList();
			String conclusion = null;
			if ( products != null ) {
				System.out.println( "Products list: " + products );
				for ( int i = 0; i < products.size(); i++ ) {
					String productSerial = products.get( i ).getSerial();
					String comparator = ( productSerial.length() > 5 ) ?
							productSerial.substring( productSerial.length() - 5 ) :
							productSerial;
					if ( comparator.equalsIgnoreCase( serial ) ) {
						request.setAttribute("product", products.get( i ).getTitle() );
						request.setAttribute( "serial", productSerial );
						conclusion = "Серия ввозилась авторизованным дистрибьютором";
					}
				}
				if ( conclusion == null ) {
					request.setAttribute( "serial", serial );
					conclusion = "Серия ввезена нелегально";
				}
			}
			else {
				System.out.println( "Warning: Serials list is empty or null..." );
			}
			request.setAttribute("conclusion", conclusion );
			System.out.println( conclusion );
		}
		return "WEB-INF/response.jsp";
	}

}
