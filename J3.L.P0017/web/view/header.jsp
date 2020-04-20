<%-- 
    Document   : menu
    Created on : Mar 9, 2020, 1:02:28 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <title>Menu Page</title>
    </head>
    <body>
        <div class="menu size-min">
            <div class="page-frame menu-inner">
                <ul>
                    <li class="text-my-font"><a href="home" class="${param.action eq 'home' ? 'active-menu' : ''}">My font page</a></li>
                        <c:if test="${not empty galleryTop}">
                            <c:forEach var="g" items="${galleryTop}">
                            <li class="text-gallery"><a href="gallery?galleryId=${g.galleryId}&page=1" class="${(g.galleryId eq galleryId) ? 'active-menu' : ''}">${g.name}</a></li>
                            </c:forEach>
                        </c:if>
                    <li><a href="contact" class="${param.action eq 'contact' ? 'active-menu' : ''}">Contact</a></li>
                </ul>
            </div>
        </div>
        <div class="title-wrapper size-min">
            <div class="page-frame title-wrapper-inner">
                <a><div class="logo"></div></a>
                <div class="text-logo">
                    <div class="title">PHOTOGRPHER</div>
                    <div class="subtitle">Welcome to this website</div>
                </div>
            </div>
        </div>
    </body>
</html>
