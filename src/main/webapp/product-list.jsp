<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<table border="1">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Unit</th>
        <th>Manufacturer</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productId}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.unit}</td>
            <td>${product.manufacturerName}</td>
            <td>${product.status}</td>
            <td>
                <a href="ProductServlet?action=showDetails&productId=${product.productId}">Details</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
