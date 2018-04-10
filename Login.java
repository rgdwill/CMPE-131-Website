import java.util.HashMap;

public class Login {
	//variables for user's input
	private String username = null;
	private String password =  null;
	//Indicates whether user is logged in or not
	boolean status = false;
	
	//constructor
	public void login(String username, String password, boolean status) {
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	//Check to see that what the user input exists and matches what's in the database
	public String validate(HashMap<String, String> db, String username, String password) {
		String update = null;
		
		if(db.containsKey(username) && password.equals(db.get(username))) {
			status = true;
			update = "You have successfully logged in!";
		}
		
		else
			update = "Username or Password was incorrect!";
		
		return update;
	}
}
