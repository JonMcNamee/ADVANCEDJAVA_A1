<%-- 
    Document   : checkout
    Created on : Nov 14, 2023, 11:41:25 AM
    Author     : JonMc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Monitor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>McNameeA1: Checkout</title>
    </head>
    <style>
        table, th, td {
            border: solid thin black;
            border-collapse: collapse;
        }
        td, th {
            padding: 15px;
        }
        form {
            padding: 10px;
        }
    </style>
    <body>
<h1>Checkout</h1>
    <form action="orderComplete.jsp" method="post">
    <table>
        <tr>
            <th>Part Number</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        
        <c:forEach var="order" items="${orderList}">
            <c:if test="${order.quantity > 0}">
                <tr>
                    <td>${order.monitor.getPartNum()}</td>
                    <td>${order.monitor.getDescription()}</td>
                    <td>${order.monitor.getPrice()}</td>
                    <td>${order.quantity}</td>
                    <td>${order.quantity * order.monitor.getPrice()}</td>
                </tr>
            </c:if>
        </c:forEach>
        
        <tr>
            <td colspan="4">Subtotal:</td>
            <td>${subTotal}</td>
        </tr>
        <tr>
            <td colspan="4">HST (${taxRate}):</td>
            <td>${hst}</td>
        </tr>
        <tr>
            <td colspan="4">Total:</td>
            <td name="total" value="total">${total}</td>
        </tr>
    </table>
    
        <input type="submit" value="Buy IT">
    </form>
    
    <form action="showOrders.jsp" method="get">
        <input type="submit" value="Continue Shopping">
    </form>    
</body>
</html>
