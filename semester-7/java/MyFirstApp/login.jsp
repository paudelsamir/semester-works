<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String loggedUser = (String) session.getAttribute("loggedUser");
%>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
    <% if (loggedUser != null) { %>
        <h2>Logged in as: <%= loggedUser %></h2>
        <a href="logout.jsp">Logout</a>
    <% } else { %>
        <h2>Not logged in</h2>
        <a href="register.jsp">Register</a>
    <% } %>
</body>
</html>
