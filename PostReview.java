import java.sql.*;
import java.util.Scanner

public class PostReview{

	public void post(String title, String year, String genre, String id) {

		string review;
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb","root","");  
 
			Statement stmt=con.createStatement();
			
			
			ResultSet rs=stmt.executeQuery("SELECT movie to post review for”); 
			
			rs.beforeFirst();
			
			//Find movie to post a review to
			while(rs.next()) {
				if(rs.getString(“title”) == title && rs.getString("year”) == year && rs.getInt("genre") == genre && rs.getString("id") == id) {
					break;
				}
			}
			
			//Update movie with posted review
			Scanner scanIn = new Scanner(System.in);
       			review = scanIn.nextLine();
      		 	scanIn.close();

			rs.updateString(5, review);
			rs.updateRow();
			
			//close connection
			con.close();
		} 

		catch(Exception e){ 
			System.out.println(e);
		}
	}
}
