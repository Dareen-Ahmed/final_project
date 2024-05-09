<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Property Images</title>
</head>
<body>
    <h1>List of Property Images</h1>
    <table border="1">
        <tr>
            <th>Image ID</th>
            <th>Listing ID</th>
            <th>Image URL</th>
        </tr>
        <c:forEach var="propertyImage" items="${propertyImages}">
            <tr>
                <td><c:out value="${propertyImage.image_id}"/></td>
                <td><c:out value="${propertyImage.listing_id}"/></td>
                <td><c:out value="${propertyImage.image_url}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>