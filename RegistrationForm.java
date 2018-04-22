import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

public class RegistrationForm extends JFrame{
	
	public static final JPanel panel = new JPanel();
	public static final JTextField username = new JTextField();
	public static final JTextField password = new JTextField();
	public static final JButton registration = new JButton();
	
	public RegistrationForm() {
		this.setTitle("Register");
		this.setSize(255, 255);
		this.setResizable(true);
		this.setVisible(true);
		
		registration.setPreferredSize(new Dimension(90, 50));
		registration.setText("Registraion");
		
		username.setPreferredSize(new Dimension(90, 20));
		password.setPreferredSize(new Dimension(90, 20));
		username.setToolTipText("Set Username");
		password.setToolTipText("Set Password");
		
		this.add(panel);
		panel.add(username, BorderLayout.WEST);
		panel.add(password, BorderLayout.WEST);
		panel.add(registration, BorderLayout.CENTER);
		
		registration.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection connect;
					String dbusername = "test0";
					String dbpassword = "test1";
					String database = "test2";
					String dbUrl = "jdbc:mysql://localhost/"+database;
					Class.forName("com.mysql.jdbc.Driver");
					connect = DriverManager.getConnection(dbUrl, dbusername, dbpassword);
					Statement statement = connect.createStatement();
					ResultSet resultSet = statement.executeQuery("");
					if(resultSet.next()) {
						if(resultSet.getString("UserID").equalsIgnoreCase(username.getText())) {
							JOptionPane.showMessageDialog(null, "This username has been registered");
						}
						else {
							PreparedStatement resultSetRegister = connect.prepareStatement("");
							resultSetRegister.setString(1, username.getText());
							resultSetRegister.setString(2, password.getText());
							resultSetRegister.executeUpdate();
							JOptionPane.showMessageDialog(null, "");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
