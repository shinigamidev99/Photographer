<%-- 
    Document   : home
    Created on : Mar 29, 2020, 8:22:29 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <c:if test="${param.action eq 'home'}">
            <jsp:include page="body.jsp"/>
        </c:if>
        <c:if test="${param.action eq 'contact'}">
            <jsp:include page="contact.jsp"/>
        </c:if>
        <c:if test="${param.action eq 'gallery'}">
            <jsp:include page="gallery.jsp"/>
        </c:if>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
