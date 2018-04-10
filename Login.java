import java.util.Scanner;

public class Login {
	private String username = null;
	private String password =  null;
	private String realUsername = "username";	//placeholder for username in database
	private String realPassword = "password";	//placeholder for password in database
	
	public void login(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	public String validate() {
		String update = null;
		
		if(username.equals(realUsername) && password.equals(realPassword))
			update = "You have successfully logged in!";
		
		else
			update = "Username or Password was incorrect!";
		
		return update;
	}
	
	public static void main(String[] args) {
		String username;
		String password;
		Login user = new Login();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Username: ");
		username = input.nextLine();
		user.setUsername(username);
		
		System.out.print("Enter Password: ");
		password = input.nextLine();
		user.setPassword(password);
		
		System.out.print(user.validate());
	}
	
}
