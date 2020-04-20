<%-- 
    Document   : gallery
    Created on : Apr 1, 2020, 1:22:53 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gallery Page</title>
    </head>
    <body>
        <div class="my-body size-min">
            <div class="page-frame container">
                <div class="main">
                    <c:if test="${empty error}">
                        <jsp:useBean id="p" class="bean.PagingBeanImage"/>
                        <jsp:setProperty name="p" property="*"/>
                        <div class="name">
                            ${gallery.name}
                        </div>
                        <div class="image-main">
                            <c:if test="${not empty imagePath}">
                                <img src="${imagePath}"/>
                            </c:if>
                            <c:if test="${empty imagePath}">
                                <img src="${gallery.top1ImagePath}"/>
                            </c:if>
                        </div>
                        <div class="image-gallery">
                            <c:forEach var="img" items="${p.list}">
                                <c:url value="gallery" var="galleryUrl">
                                    <c:param name="galleryId" value="${param.galleryId}"/>
                                    <c:param name="page" value="${param.page}"/>
                                    <c:param name="imagePath" value="${img.imagePath}"/>
                                </c:url>
                                <a href="${galleryUrl}">
                                    <div class="image-background">
                                        <img src="${img.imagePath}"/>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="paging">
                            <c:forEach var="i" begin="1" end="${p.pages}" step="1">
                                <c:url value="gallery" var="next">
                                    <c:param name="galleryId" value="${param.galleryId}"/>
                                    <c:param name="page" value="${i}"/>
                                </c:url>
                                <c:if test="${i != param.page}">
                                    <a href="${next}">${i}</a>
                                </c:if>
                                <c:if test="${i == param.page}">
                                    <a class="active">${i}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </c:if>
                    <jsp:include page="error.jsp"/>
                </div>
                <div class="right"><jsp:include page="right.jsp"/></div>
            </div>
        </div>
    </body>
</html>
