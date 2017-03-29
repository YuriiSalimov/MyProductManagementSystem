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
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<div class="container">
    <h4>Login</h4>
    <c:choose>
        <c:when test="${param.error ne null}">
            <div role="alert"><h5>Error</h5></div>
        </c:when>
        <c:when test="${param.logout ne null}">
            <div role="alert"><h5>Logout</h5></div>
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
</body>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
