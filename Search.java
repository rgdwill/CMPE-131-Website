import java.sql.*;

public class Search{

	
	
	public static boolean validate(String title, String year, String genre, String id) {
		boolean status=false;
		
	try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/moviedb","root","");  
 
			Statement st=con.createStatement();
	rs = st.executeQuery("SELECT *" + " FROM our database" +" WHERE movieName LIKE"+ '"'+"%"+query+"%"+'"'); 

// Here  I have to search year, genre, and id , but I could not come up with the method....//
while(rs.next()) {
                 title= rs.getString("title");
                 year = rs.getString("year");
                 Genre= rs.getInt("genre");
                 id = rs.getString("id");
                 }


	catch(Exception e){ 
			System.out.println(e);} 
		
		return status;
	}
}
