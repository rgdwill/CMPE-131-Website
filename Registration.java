//need to test

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class Registration {
	
	public static boolean Register(String un, String pw, String first, String last, String email) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/moviedb","root","");  
			
			Statement stmt=con.createStatement();
			
			ResultSet rs = stmt.executeQuery("CREATE USER 'un'@'jdbc:mysql://localhost:3306/moviedb' IDENTIFIED BY 'pw', 'first', 'last', 'email'");
			
			if(rs.isBeforeFirst()) {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}
	
}
