package com.qsp.empApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getemployee_details extends HttpServlet {
          
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Eid=req.getParameter("Id");
		int Id=Integer.parseInt(Eid);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Rupesh2036@");
			PreparedStatement pstmt=con.prepareStatement("select * from employee_details.employee where id=?");
			
			pstmt.executeUpdate();
			
			ResultSet rs=pstmt.executeQuery();
			
			PrintWriter out=resp.getWriter();
			
			if (rs.next()) {
				
				out.print("<html><body bgcolor='pink'><h1> employee details:-"+rs.getInt(1)+ "Id" 
						+ rs.getString(2)+"Ename" + rs.getDouble(3)+"Esalary"+ "</h1></body></html>");
				
			}
			else {
				//System.out.println("Id not found");
				out.print("<html><body bgcolor='pink'><h1> Emp Details are:-Id Not Found...."
						+"</h1></body></html>");
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
