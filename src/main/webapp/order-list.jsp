<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order List</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <script>
        $(function() {
            $("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' });
        });
    </script>
</head>
<body>
<h2>Order List</h2>
<!-- Ngày -->
<form action="OrderServlet" method="get">
    <%--@declare id="date"--%><label for="date">Date: </label>
    <input type="text" id="datepicker" name="date">
    <input type="submit" value="Show Orders">
</form>

<!-- Thời gian -->
<form action="OrderServlet" method="get">
    <%--@declare id="startdate"--%>
    <label for="startDate">Start Date: </label>
    <input type="text" id="startdatepicker" name="startDate">
        <%--@declare id="enddate"--%>
    <label for="endDate">End Date: </label>
    <input type="text" id="enddatepicker" name="endDate">
    <input type="submit" value="Show Orders">
</form>

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
