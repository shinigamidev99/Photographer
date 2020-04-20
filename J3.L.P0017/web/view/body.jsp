<%-- 
    Document   : body
    Created on : Mar 29, 2020, 8:37:10 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Body Page</title>
    </head>
    <body>
        <div class="my-body size-min">
            <div class="page-frame container">
                <div class="main">
                    <c:if test="${empty error}">
                        <div class="image-main">
                            <img src="${contact.imagePath}"/>
                        </div>
                        <div class="name-image">
                            ${contact.nameImage}
                        </div>
                        <div class="content">
                            <jsp:useBean id="p" class="bean.PagingBean"/>
                            <jsp:setProperty name="p" property="*"/>
                            <c:forEach items="${p.list}" var="x">
                                <div class="infor">
                                    <div class="image-infor">
                                        <img src="${x.top1ImagePath}">
                                    </div>
                                    <div class="title-content">
                                        <a href="gallery?galleryId=${x.galleryId}&page=1">${x.title}</a>
                                    </div>
                                    <div>
                                        ${x.description}
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="paging">
                            <c:forEach var="i" begin="1" end="${p.pages}" step="1">
                                <c:url value="home" var="next">
                                    <c:param name="page" value="${i}"/>
                                </c:url>
                                <c:if test="${i != param.page && (not empty param.page || i != 1)}">
                                    <a href="${next}">${i}</a>
                                </c:if>
                                <c:if test="${i == param.page || (empty param.page && i == 1)}">
                                    <a class="active">${i}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                        <div class="about">
                            <div class="about-title">
                                About me
                            </div>
                            <div class="infor-me">
                                ${contact.about}
                            </div>
                        </div>
                    </c:if>
                    <jsp:include page="error.jsp"/>
                </div>
                <div class="right"><jsp:include page="right.jsp"/></div>
            </div>
        </div>
    </body>
</html>
