package com.zubergu.weatherservice.authentication;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubergu.weatherservice.persistence.actions.administrators.RetrieveAdministrators;
import com.zubergu.weatherservice.persistence.entities.Administrator;


public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	RequestDispatcher rd = null;

	RetrieveAdministrators validator = new RetrieveAdministrators();
	Administrator admin = new Administrator();
	admin.setLogin(username);
	admin.setPassword(password);
	
	if (validator.validAdministrator(admin)) {
	    
	    rd = request.getRequestDispatcher("/success.jsp");
	    request.setAttribute("admin", admin);
	    request.setAttribute(
		    "listOfRecords",
		    validator.getAdministratorsList());
	    
	    ServletContext context = getServletContext();
	    
	    request.setAttribute("schedulerState", !((ScheduledExecutorService)context.getAttribute("scheduler")).isShutdown());
	    
	} else {
	    rd = request.getRequestDispatcher("/error.jsp");
	}
	rd.forward(request, response);
    }

}
