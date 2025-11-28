<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World JSP</title>
</head>
<body>
    <h1>Welcome to Hello World Servlet sadas</h1>
    
    <% if (request.getAttribute("message") != null) { %>
        <div style="margin: 20px 0; padding: 10px; background-color: #e8f5e9; border-radius: 4px;">
            <%= request.getAttribute("message") %>
        </div>
    <% } %>
    
    <form action="hello" method="get">
        <label for="name">Enter your name:</label>
        <input type="text" id="name" name="name">
        <input type="submit" value="Say Hello">
    </form>
</body>
</html>