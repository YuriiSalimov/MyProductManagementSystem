<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Update User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>
        <a href="<c:url value="/home"/>">Product Management System</a> - Edit User <c:out value="${user.username}"/>
    </h3>
    <form role="form" class="form-horizontal" action="<c:url value="/admin/user/update/${user.id}"/>"
          method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username"
                   value="<c:out value="${user.username}"/>">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="password" placeholder="Password"
                   value="<c:out value="${user.password}"/>">
        </div>
        <div class="form-group">
            <c:forEach items="${roles}" var="role">
                <label>
                    <input type="radio" name="role" value="<c:out value="${role}"/>" required
                           <c:if test="${role eq user.role}">checked</c:if>/>
                    <c:out value="${role}"/>
                </label>
            </c:forEach>
        </div>
        <div class="form-group">
            <label>
                <input type="radio" name="locked" value="true" required
                       <c:if test="${user.locked}">checked</c:if>/> Locked
            </label>
            <label>
                <input type="radio" name="locked" value="false" required
                       <c:if test="${!user.locked}">checked</c:if>/> Not Locked
            </label>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Update">
        </div>
    </form>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
