<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order List</title>
</head>
<body>
<h2>Order List</h2>
<table border="1">
    <thead>
    <tr>
        <th>Order ID</th>
        <th>Order Date</th>
        <th>Employee ID</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.orderDate}</td>
            <td>${order.empId}</td>
            <td>
                <a href="OrderServlet?action=edit&orderId=${order.orderId}">Edit</a>
                <a href="OrderServlet?action=delete&orderId=${order.orderId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="OrderServlet?action=showForm">Add New Order</a>
</body>
</html>
