<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <h3><a href="<c:url value="/home"/>">Product Management System</a></h3>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/home"/>">Products</a>
                </li>
                <li>
                    <a href="<c:url value="/users"/>">Users</a>
                </li>
                <li>
                    <c:choose>
                        <c:when test="${is_admin}">
                            <a href="<c:url value="/logout"/>">Logout</a>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value="/login"/>">Login</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
