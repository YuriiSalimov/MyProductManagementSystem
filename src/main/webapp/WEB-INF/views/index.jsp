<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html removeIntertagSpaces="true">
    <!DOCTYPE HTML>
    <html lang="en">
    <head>
        <title>Product Management System</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/navbar.jsp"/>
    <div class="container">
        <h4>Products</h4>
        <c:if test="${is_admin}">
            <a href="<c:url value="/admin/product/new"/>">
                <input type="submit" class="btn btn-default" value="Add New">
            </a>
            <a href="<c:url value="/admin/product/delete/all"/>">
                <input type="submit" class="btn btn-default" value="Delete All">
            </a>
        </c:if>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Title</th>
                <th>Manufacturer</th>
                <th>Cost</th>
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
                    <c:if test="${is_admin}">
                        <td>
                            <a href="<c:url value="/admin/product/delete/${product.id}"/>">
                                <input type="submit" class="btn btn-default" value="Delete">
                            </a>
                            <a href="<c:url value="/admin/product/edit/${product.id}"/>">
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
</compress:html>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
