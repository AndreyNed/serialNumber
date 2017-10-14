package by.serialnumber.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.serialnumber.web.command.BasicAction;
import by.serialnumber.web.command.CommandChooser;
import by.serialnumber.web.command.CommandType;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest( request, response );
	}
	
	private void processRequest( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("process request...");
		String commandStr = request.getParameter( "command" );
		if ( commandStr != null ) {
			System.out.println( "Command: " + commandStr );
			CommandType command = CommandType.valueOf( commandStr.toUpperCase() );
			BasicAction action = CommandChooser.createAction( command );
			String page = action.executeAction( request, response );
			RequestDispatcher dispatcher = request.getRequestDispatcher( page );
			dispatcher.forward(request, response);
		}
		
		
	}

}
