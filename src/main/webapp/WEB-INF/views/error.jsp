<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html removeIntertagSpaces="true">
    <!DOCTYPE HTML>
    <html lang="en">
    <head>
        <title>Error <c:out value="${status}"/></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/navbar.jsp"/>
    <div class="container">
        <h4>
            <b>Error <c:out value="${status}"/></b>
        </h4>
        <h5>
            <c:out value="${message}"/>
        </h5>
    </div>
    </body>
    </html>
</compress:html>
<%-- Yurii Salimov (yuriy.alex.salimov@gmail.com) --%>
