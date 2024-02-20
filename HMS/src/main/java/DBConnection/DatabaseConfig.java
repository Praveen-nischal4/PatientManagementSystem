package DBConnection;
import java.sql.*;

public class DatabaseConfig {

	 Connection con;
	 Statement s;
	 
	 public DatabaseConfig()                //public constructor
	 {
		 try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","955455Praveen");
			 		
		 }catch(SQLException | ClassNotFoundException e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
	 public Connection getCon()             //create a method to return connection object
	 {
		 return con;
	 }
}
