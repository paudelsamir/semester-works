<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String message = "";

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String user = request.getParameter("username");
        if (user != null && !user.isEmpty()) {
            session.setAttribute("loggedUser", user);
            message = "Welcome, " + user + "!";
        } else {
            message = "Fill the field!";
        }
    }
%>
<!DOCTYPE html>
<html>
<head><title>Register</title></head>
<body>
    <h2>Register</h2>
    <% if (!message.isEmpty()) { %>
        <p><b><%= message %></b></p>
    <% } %>
    <form method="post">
        Name: <input type="text" name="username" required><br>
        <input type="submit" value="Register">
    </form>
    <a href="login.jsp">Login</a>
</body>
</html>
