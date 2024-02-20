package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DatabaseConfig;


@WebServlet("/EditRecord")
public class EditRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public EditRecord() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
      int pid = Integer.parseInt(request.getParameter("pid"));
      String em = request.getParameter("email");
      String user =request.getParameter("user");
      String pwd = request.getParameter("pass");
      String phn = request.getParameter("phn");
      
      PrintWriter out =response.getWriter();
    
      try
      {
    	  DatabaseConfig d  = new DatabaseConfig();
    	  Connection con = d.getCon();
    	  
    	Statement s = con.createStatement();
			 
			s.executeUpdate("update  register set email ='"+em+"', username='"+user+"',password='"+pwd+"',phnno ='"+phn+"' where pid='"+pid+"'");
			response.sendRedirect("GetRecord.html");
    	  
      }catch(SQLException e)      
      {
    	e.printStackTrace();  
      }

	}

}
