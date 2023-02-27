package com.qsp.jdbcApp;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Studentinformation extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		 
		String Id=arg0.getParameter("id");
		int id=Integer.parseInt(Id);
		String Name=arg0.getParameter("nm");
		String Place=arg0.getParameter("pl");
		String Address=arg0.getParameter("ad");
		
		PrintWriter out=arg1.getWriter();
		out.print("<html><body bgcolor='Red'>"+"<h1> Details are:- "+ " "+Id+" "+" "+Name+""+" "+""+Place+" "+Address+" "+ " </h1></html></body>");
		
		//jdbc code
		String qry=("insert into studentinfo.student values(?,?,?,?)");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Rupesh2036@");
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setInt(1, id);
			pstmt.setString(2,Name);
	 		pstmt.setString(3, Place);
			pstmt.setString(4, Address);
			
			pstmt.executeUpdate();
			System.out.println("Information Inserted!!!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
