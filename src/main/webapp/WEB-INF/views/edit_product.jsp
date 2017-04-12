<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"/>
<div class="container">
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
            <input type="text" class="form-control" name="description" placeholder="Description"
                   value="<c:out value="${product.description}"/>">
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
</html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
