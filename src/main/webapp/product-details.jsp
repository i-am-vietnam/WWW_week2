<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<h2>Product Details</h2>
<c:if test="${product ne null}">
    <p>Product ID: ${product.productId}</p>
    <p>Name: ${product.name}</p>
    <p>Description: ${product.description}</p>
    <p>Unit: ${product.unit}</p>
    <p>Manufacturer: ${product.manufacturerName}</p>
    <p>Status: ${product.status}</p>
</c:if>

<h3>Product Images</h3>
<table border="1">
    <thead>
    <tr>
        <th>Image ID</th>
        <th>Path</th>
        <th>Alternative</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="image" items="${productImages}">
        <tr>
            <td>${image.imageId}</td>
            <td>${image.path}</td>
            <td>${image.alternative}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
