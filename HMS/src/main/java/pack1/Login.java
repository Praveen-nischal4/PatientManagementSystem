package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DatabaseConfig;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pass =request.getParameter("pass");
         
		
		try
		{
			DatabaseConfig d = new DatabaseConfig();
			Connection  con =d.getCon();
			
		Statement s =con.createStatement();
		ResultSet rs = s.executeQuery("select pid,password from register where pid ='"+pid+"'");
		  int ID=0;	String PWD=null;
		while(rs.next())
			{
				ID =rs.getInt(1);
				 PWD =rs.getString(2);
			}
		
		if(pid==ID && pass.equals(PWD))
 		 {
 	        RequestDispatcher rd = request.getRequestDispatcher("Dashboard.html");
 	        rd.forward(request, response);
 		 }else
 		 {
 			 response.sendRedirect("Login.html");
 		 }
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}

}
