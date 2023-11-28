<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<h1>Trang chủ</h1>
<h2>Quản lý sản phẩm</h2>
<ul>
  <li><a href="ProductServlet?action=list">View Product List</a></li>
</ul>

<h2>Quản lý đơn hàng</h2>
<ul>
  <li><a href="OrderServlet?action=list">View Order List</a></li>
  <li><a href="OrderServlet?action=showForm">Add New Order</a></li>
</ul>

</body>
</html>
