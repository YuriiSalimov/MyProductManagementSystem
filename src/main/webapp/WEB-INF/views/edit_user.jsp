<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html removeIntertagSpaces="true">
    <!DOCTYPE HTML>
    <html lang="en">
    <head>
        <title>Update User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/navbar.jsp"/>
    <div class="container">
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
                    &nbsp;&nbsp;
                </c:forEach>
            </div>
            <div class="form-group">
                <label>
                    <input type="radio" name="locked" value="true" required
                           <c:if test="${user.locked}">checked</c:if>/> Locked
                </label>
                &nbsp;&nbsp;
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
    </body>
    </html>
</compress:html>
<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
