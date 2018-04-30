<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%
String user=request.getParameter("un");
session.putValue("un",user);
String pw=request.getParameter("pw");

Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb","root","");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT password FROM users WHERE username='"+user+"'"); 

//Checks that username exists based on if the pointer is before a record
if(rs.next()) {
	//if entered password matches password in database return true
	if(rs.getString(1).equals(pw)) {
		//status = true;
		out.println("Welcome "+user+"!");
	}
	else
		out.println("Incorrect Username/Password");
}

else
	out.println("Incorrect Username/Password");
%>
<a href="index.html"><br/>Home</a>
</body>
</html>