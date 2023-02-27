package com.qsp.App;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class Registration_page extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException 
	{
		//logic to fetch the record(key and value pair) from the html file
		
		String Name = arg0.getParameter("nm");
		String Place = arg0.getParameter("pl");
		
		//Display the data from the servlet in html format
		
		 PrintWriter output =arg1.getWriter();
		output.print("<html><body bgcolor='orange'><h1> Details are:- "+Name+""+" from "+Place+" </h1></body></html>");
		
		
		
	}

}
