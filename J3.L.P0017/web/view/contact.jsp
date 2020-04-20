<%-- 
    Document   : Contact
    Created on : Apr 1, 2020, 12:32:22 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Page</title>
    </head>
    <body>
        <div class="my-body size-min">
            <div class="page-frame container">
                <div class="main">
                    <div class="capite">
                        Contact
                    </div>
                    <div class="capite photo-capite">
                        PHOTOGRAPHER
                    </div>
                    <div class="body-contact">
                        <table>
                            <tr>
                                <td>Address: </td>
                                <td>${contact.address}</td>
                            </tr>
                            <tr>
                                <td>City: </td>
                                <td>${contact.city}</td>
                            </tr>
                            <tr>
                                <td>Country: </td>
                                <td>${contact.country}</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td>Tel: </td>
                                <td>${contact.tel}</td>
                            </tr>
                            <tr>
                                <td>Email: </td>
                                <td>${contact.email}</td>
                            </tr>
                        </table>
                    </div>
                    <div class="map">
                        <img src="${contact.mapPath}">
                    </div>
                </div>
                <div class="right"><jsp:include page="right.jsp"/></div>
            </div>
        </div>
    </body>
</html>
