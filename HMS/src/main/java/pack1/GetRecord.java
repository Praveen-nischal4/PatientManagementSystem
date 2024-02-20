package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DatabaseConfig;

import java.sql.*;

@WebServlet("/GetRec")
public class GetRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetRecord() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		PrintWriter out = response.getWriter();
		
		try
		{
			DatabaseConfig d = new DatabaseConfig();
			Connection con = d.getCon();
			Statement s = con.createStatement();
			
		ResultSet rs = s.executeQuery("select pid, email, username, password, Phnno from register where pid='"+pid+"'");
		
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Edit Record</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Edit Patient Record</h2>");
        out.println("<form method='post' action='EditRecord'>");
		while(rs.next())
		{		
			out.println("<input type='hidden' name='pid' value='"+rs.getInt(1)+"'"+"</input>");
			out.println("<input type='text' name='email' value='"+rs.getString(2)+"'"+"</input>");
			out.println("<input type='text' name='user' value='"+rs.getString(3)+"'"+"</input>");
			out.println("<input type='text' name='pass' value='"+rs.getString(4)+"'"+"</input>");
			out.println("<input type='text' name='phn' value='"+rs.getString(5)+"'"+"</input>");		
			
		}
		
		out.println("<input type='submit' value='Save'/>");
		out.println("</form>");
			
		}catch(SQLException f)
		{
			f.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
