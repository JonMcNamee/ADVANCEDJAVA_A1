<%-- 
    Document   : showOrders
    Created on : Nov 14, 2023, 10:45:37 AM
    Author     : JonMc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Monitor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<Monitor> catalog = (ArrayList<Monitor>) request.getSession().getAttribute("catalog"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>McNameeA1: Show Orders</title>
    </head>
    <style>
            table, th, td {
                border: solid thin black;
                border-collapse: collapse;
            }
            td, th {
                padding: 15px;
            }
            input {
                margin-top: 15px;
                margin-bottom: 15px;
            }
    </style>
    <body>
        <h1>Monitor Catalog</h1>
        <form action="ProcessOrder" method="post">
        <input type="submit" value="Process Order">
        <table>
            <tr>
                <th>Part Number</th>
                <th>Description</th>
                <th>Resolution</th>
                <th>Refresh Rate</th>                
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            
            <c:forEach var="m" items="${catalog}">
                <tr>
                    <td>${m.getPartNum()}</td>
                    <td>${m.getDescription()}</td>
                    <td>${m.getResolution()}</td>
                    <td>${m.getRefreshRate()}</td>
                    <td>${m.getPrice()}</td>
                    <td>
                        <input type="number" name="quantity${m.getPartNum()}" value="0" min="0">
                    </td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </body>
</html>
