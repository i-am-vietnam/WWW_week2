<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Order</title>
</head>
<body>
<h2>Add Order</h2>
<form action="OrderServlet?action=add" method="post">
    Order Date: <input type="date" name="orderDate" required><br>
    Employee ID: <input type="text" name="empId" required><br>
    <input type="submit" value="Add Order">
</form>
<br>
<a href="OrderServlet?action=list">Back to Order List</a>
</body>
</html>
