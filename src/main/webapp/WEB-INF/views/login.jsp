<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <!-- <form action="${pageContext.request.contextPath}/home" method="post"> -->
        <form action="${pageContext.request.contextPath}/home" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" placeholder="Username" />
        <button type="submit">Login</button>
    </form>
</body>
</html>