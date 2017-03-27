<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>
        <a href="<c:url value="/home"/>">Product Management System</a> - Login
    </h3>
    <c:choose>
        <c:when test="${param.error ne null}">
            <div role="alert"><h4>Error</h4></div>
        </c:when>
        <c:when test="${param.logout ne null}">
            <div role="alert"><h4>Logout</h4></div>
        </c:when>
    </c:choose>
    <form action="<c:url value="/login"/>" method="post">
        <div class="form-group">
            <input id="username" class="form-control" type="text" name="username" required autofocus
                   placeholder="Username">
        </div>
        <div class="form-group">
            <input id="password" class="form-control" type="password" name="password" required
                   placeholder="Password">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Submit">
        </div>
    </form>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
