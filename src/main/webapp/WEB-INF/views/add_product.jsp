<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>New Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>
        <a href="<c:url value="/home"/>">Product Management System</a> - New Product
    </h3>
    <form role="form" class="form-horizontal" action="<c:url value="/admin/product/add"/>" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Title">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="manufacturer" placeholder="Manufacturer">
        </div>
        <div class="form-group">
            <input type="number" class="form-control" name="cost" placeholder="Cost">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Add">
        </div>
    </form>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
