package com.qsp.jdbcapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Employee_Details extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String EID=arg0.getParameter("EI");
		int EI=Integer.parseInt(EID);
		String EName=arg0.getParameter("EN");
		String Esalary=arg0.getParameter("ES");
		int ES=Integer.parseInt(Esalary);
		
		PrintWriter out=arg1.getWriter();
		out.print("<html><body='orange'>"+"<h1>Employee details:-"+ " "+EID+""+""+EName+""+Esalary+""+" </h1></body></html>");
		
		//jdbc code
		String qry="insert into employee_details.employee values(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Rupesh2036@");
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setInt(1, EI);
			pstmt.setString(2, EName);
			pstmt.setLong(3, ES);
			
			pstmt.executeUpdate();
			System.out.println("Employee Details Inserted!!!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
