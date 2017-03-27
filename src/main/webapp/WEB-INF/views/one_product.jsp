<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Product <c:out value="${product.title}"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>
        <a href="<c:url value="/home"/>">Product Management System</a> - <c:out value="${product.title}"/>
    </h3>
    <table class="table table-striped">
        <tr>
            <th>Title</th>
            <td><c:out value="${product.title}"/></td>
        </tr>
        <tr>
            <th>Manufacturer</th>
            <td><c:out value="${product.manufacturer}"/></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><c:out value="${product.description}"/></td>
        </tr>
        <tr>
            <th>Cost</th>
            <td><c:out value="${product.cost}"/></td>
        </tr>
    </table>
    <a href="<c:url value="/admin/product/delete/${product.id}"/>">
        <input type="submit" class="btn btn-default" value="Delete">
    </a>
    <a href="<c:url value="/admin/product/edit/${product.id}"/>">
        <input type="submit" class="btn btn-default" value="Edit">
    </a>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
