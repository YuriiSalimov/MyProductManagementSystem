<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>
        <a href="<c:url value="/home"/>">Product Management System</a> - Edit Product <c:out value="${product.title}"/>
    </h3>
    <form role="form" class="form-horizontal" action="<c:url value="/admin/product/update/${product.id}"/>"
          method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Title"
                   value="<c:out value="${product.title}"/>">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="manufacturer" placeholder="Manufacturer"
                   value="<c:out value="${product.manufacturer}"/>">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="cost" placeholder="Cost"
                   value="<c:out value="${product.cost}"/>">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Update">
        </div>
    </form>
</div>
</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
