<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<a href="index.html"><br/>Home</a><br/>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%
String user=request.getParameter("un");
//session.putValue("un",user);
String pw=request.getParameter("pw");
String first=request.getParameter("first");
String last=request.getParameter("last");
String email=request.getParameter("email");

Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb","root","");
Statement stmt=con.createStatement();

//Check is the username or email is already linked to an account
ResultSet rs = stmt.executeQuery("SELECT username, email FROM users");
boolean exist = false;
while(rs.next()){
	if(rs.getString(1).equals(user)||rs.getString(2).equals(email))
		exist=true;	
}

//Check that values were entered in each field
if(user.equals("") || pw.equals("") || first.equals("") || last.equals("") || email.equals(""))
	out.println("Value not entered in one or more fields!");
	
else{
	if(!exist){
		stmt.executeUpdate("INSERT INTO users VALUE ('"+user+"', '"+pw+"', '"+first+"', '"+last+"', '"+email+"')");
		out.println("You have been Registered");
		con.close();
	}
	
	else
		out.println("The username or email entered is already linked to an existing account.");
}
%>
</br><br/>
<a href="Login.html">Login</a>
</body>
</html>
