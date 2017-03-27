<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>New User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>
        <a href="<c:url value="/home"/>">Product Management System</a> - New User
    </h3>
    <form role="form" class="form-horizontal" action="<c:url value="/admin/user/add"/>" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="password" placeholder="Password">
        </div>
        <div class="form-group">
            <c:forEach items="${roles}" var="role">
                <label>
                    <input type="radio" name="role" value="<c:out value="${role}"/>" checked required/>
                    <c:out value="${role}"/>
                </label>
            </c:forEach>
        </div>
        <div class="form-group">
            <label>
                <input type="radio" name="locked" value="true" required/> Locked
            </label>
            <label>
                <input type="radio" name="locked" value="false" checked required/> Not Locked
            </label>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Add">
        </div>
    </form>
</div>
</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
