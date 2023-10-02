<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="records" type="java.sql.ResultSet" scope="request"/>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grade Computation using JDBC</title>
</head>
<body>
	<h2 align="center">List of Student Records</h2>
	<table border="1" cellpadding="2px" cellspacing="2px" align="center">
		<tr>
			<th>#</th>
			<th>Student ID</th>
			<th>Name</th>
			<th>Midterm Grade</th>
			<th>Pre-Final Grade</th>
			<th>Final Grade</th>
			<th>Remarks</th>
			<th>Actions</th>
		</tr>
		<% while (records.next()) { %>
			<tr>
				<td align="center"><b><%= records.getInt("id")%></b></td>
				<td align="center"><b><%= records.getString("student_id")%></b></td>
				<td><b><%= records.getString("name")%></b></td>
				<td align="center"><b><%= records.getDouble("midterm")%></b></td>
				<td align="center"><b><%= records.getDouble("prefinal")%></b></td>
				<td align="center"><b><%= records.getDouble("final")%></b></td>
				<td align="center"><b><%= records.getString("remarks")%></b></td>
				<td align="center">
					<form action="deleterecord.action" method="post">
						<input name="recordId" type="text" value="<%= records.getInt("id")%>" />
						<input type="submit" value="DELETE RECORD"/> <!-- Logically Delete the data (not hard delete) -->
					</form>
				</td>
			</tr>
		<% } %>
	
	</table>
	
	<form action="index.html">
		<input type="submit" value ="GO BACK"/>
	</form>
</body>
</html>