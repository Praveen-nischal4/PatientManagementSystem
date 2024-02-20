package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DatabaseConfig;


@WebServlet("/Reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pid = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String phnno = request.getParameter("phn");
		
		try
		{
			DatabaseConfig d = new DatabaseConfig();
			Connection con =d.getCon();
			
			Statement s =con.createStatement();
			s.execute("insert into Register values ('"+pid+"','"+email+"','"+user+"','"+pass+"','"+phnno+"')");
			response.sendRedirect("Login.html");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	PrintWriter out = response.getWriter();
	out.println("Data feeded Successfully");

		
		
 	}




}
