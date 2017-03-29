<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Product Management System</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<div class="container">
    <h4>Users</h4>
    <c:if test="${is_admin}">
        <a href="<c:url value="/admin/user/new"/>">
            <input type="submit" class="btn btn-default" value="Add New">
        </a>
        <a href="<c:url value="/admin/user/delete/all"/>">
            <input type="submit" class="btn btn-default" value="Delete All">
        </a>
    </c:if>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Username</th>
            <th>Role</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.role}"/></td>
                <c:if test="${is_admin}">
                    <td>
                        <a href="<c:url value="/admin/user/delete/${user.id}"/>">
                            <input type="submit" class="btn btn-default" value="Delete">
                        </a>
                        <a href="<c:url value="/admin/user/edit/${user.id}"/>">
                            <input type="submit" class="btn btn-default" value="Edit">
                        </a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
