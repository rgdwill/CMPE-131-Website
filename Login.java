import java.sql.*;

public class Login{
	//Check to see that what the user input exists and matches what's in the database
	public static boolean validate(String un, String pw) {
		boolean status=false;
		
		//Establish connection to MySQL
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/moviedb","root","");  
 
			Statement stmt=con.createStatement();
			
			//execute query for password for given username
			ResultSet rs=stmt.executeQuery("SELECT password FROM users WHERE username='"+un+"'");  
			rs.beforeFirst();
			rs.next();
			
			//if entered password matches password in database return true
			if(pw.equals(rs.getString(1))) {
				status = true;
			}
			//close connection
			con.close();
		} 

		catch(Exception e){ 
			System.out.println(e);}  
		return status;
	}  
}
