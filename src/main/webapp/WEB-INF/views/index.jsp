<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Product Management System</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <h3><a href="<c:url value="/home"/>">Product Management System</a></h3>
        </div>
    </div>
</nav>
<div class="container">
    <h4>Products</h4>
    <a href="<c:url value="/admin/product/new"/>">
        <input type="submit" class="btn btn-default" value="Add new product">
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Manufacturer</th>
            <th>Cost</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>
                    <a href="<c:url value="/product/${product.id}"/>">
                        <c:out value="${product.title}"/>
                    </a>
                </td>
                <td><c:out value="${product.manufacturer}"/></td>
                <td><c:out value="${product.cost}"/></td>
                <td>
                    <a href="<c:url value="/admin/product/delete/${product.id}"/>">
                        <input type="submit" class="btn btn-default" value="Delete">
                    </a>
                    <a href="<c:url value="/admin/product/edit/${product.id}"/>">
                        <input type="submit" class="btn btn-default" value="Edit">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">
    <h4>Users</h4>
    <a href="<c:url value="/admin/user/new"/>">
        <input type="submit" class="btn btn-default" value="Add new user">
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Username</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td>
                    <a href="<c:url value="/admin/user/delete/${user.id}"/>">
                        <input type="submit" class="btn btn-default" value="Delete">
                    </a>
                    <a href="<c:url value="/admin/user/edit/${user.id}"/>">
                        <input type="submit" class="btn btn-default" value="Edit">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
