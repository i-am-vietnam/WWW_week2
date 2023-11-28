<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Order</title>
</head>
<body>
<h2>Edit Order</h2>
<form action="OrderServlet?action=update" method="post">
    <input type="hidden" name="orderId" value="${order.orderId}">
    Order Date: <input type="date" name="orderDate" value="${order.orderDate}" required><br>
    Employee ID: <input type="text" name="empId" value="${order.empId}" required><br>
    <input type="submit" value="Update Order">
</form>
<br>
<a href="OrderServlet?action=list">Back to Order List</a>
</body>
</html>
