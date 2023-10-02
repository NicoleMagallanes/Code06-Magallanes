<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:useBean id="records" type="java.sql.ResultSet" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JDBC UPDATE RECORDS</title>
</head>
<body>
<h2>UPDATE RECORDS</h2>
<form method="post" action="">
    <% while (records.next()) { %>
    <p>Name: Place name here</p>
    <p>Midterm Grade:
        <input name="midtermGrade" type="number" required value="<% records.getDouble("midterm")%>"/>
    </p>
    <p>Prefinal Grade:
        <input name="prefinal" type="number" required/>
    </p>
    <% } %>
</form>
</body>
</html>