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


@WebServlet("/DelRecord")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteRecord() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pid = Integer.parseInt(request.getParameter("pid"));
		PrintWriter out =response.getWriter();
		try
		{
			DatabaseConfig d = new DatabaseConfig();
			Connection con = d.getCon();
			
			Statement s = con.createStatement();
			
		int y = s.executeUpdate("delete from register where pid='"+pid+"'");
			
		out.println("deleted ="+y+" Record");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
