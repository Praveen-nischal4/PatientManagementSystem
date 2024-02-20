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


@WebServlet("/Changepass")
public class Changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Changepass() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String curpwd = request.getParameter("curPass");
		String newpwd = request.getParameter("newPass");
		String retpwd = request.getParameter("newPass1");
	  
		PrintWriter out = response.getWriter();
	
		try
		{
		
		if((!curpwd.isBlank()) && (newpwd.equals(retpwd)))
		{
			DatabaseConfig d = new DatabaseConfig();
			Connection con =d.getCon();
			Statement s = con.createStatement();
			
			s.executeUpdate("update register set password ='"+newpwd+"' where password ='"+curpwd+"'");
			  out.println("password is updated please login again");
			  response.sendRedirect("Login.html");
		}else
		{
			out.println("All fields are mandentory");
			return;
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
