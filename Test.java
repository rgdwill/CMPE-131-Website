import java.util.HashMap;
import java.util.Scanner;

public class Test extends Login {

	public static void main(String[] args) {
		String username;
		String password;
		Login user = new Login();
		
		//HashMap will act as database
		HashMap<String, String> db = new HashMap<String, String>();
		db.put("user", "pass");
		
		//User's Input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Username: ");
		username = input.nextLine();
		user.setUsername(username);
		System.out.print("Enter Password: ");
		password = input.nextLine();
		user.setPassword(password);
		input.close();
		
		//Results
		System.out.print(user.validate(db, username, password));
	}

}
