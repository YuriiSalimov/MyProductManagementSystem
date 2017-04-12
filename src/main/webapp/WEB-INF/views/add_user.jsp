<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>New User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<div class="container">
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
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
