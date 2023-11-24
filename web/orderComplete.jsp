<%-- 
    Document   : orderComplete
    Created on : Nov 14, 2023, 1:02:48?PM
    Author     : JonMc
--%>

<% double total = (Double) request.getSession().getAttribute("total"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>McNameeA1: Order Complete</title>
    </head>
    <body>
        <h1>Your order is being processed</h1>
        <h2>Your total is: $${total}</h2>
    </body>
</html>
