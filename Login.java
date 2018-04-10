import java.util.Scanner;

public class Login {
	private String username = null;
	private String password =  null;
	private String realUsername = "username";
	private String realPassword = "password";
	private boolean status = false;
	
	public void login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
		
		if(this.username != realUsername)
			status = false;
		
		else
			status = true;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
		
		if(this.password != realPassword)
			status = false;
		
		else status = true;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String validate() {
		String update = null;
		
		if(status==true)
			update = "You have successfully logged in!";
		
		if(status==false)
			update = "Username/Password was incorrect!";
		
		return update;
	}
	
	public static void main(String[] args) {
		Login user = new Login();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Username: ");
		user.setUsername(input.nextLine());
		
		System.out.print("Enter Password: ");
		user.setPassword(input.nextLine());
		
		System.out.print(user.validate());
	}
	
}
