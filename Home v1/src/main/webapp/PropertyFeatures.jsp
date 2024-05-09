<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Property Features</title>
</head>
<body>
    <h1>List of Property Features</h1>
    <table border="1">
        <tr>
            <th>Feature ID</th>
            <th>Listing ID</th>
            <th>Feature Name</th>
            <th>Feature Value</th>
        </tr>
        <c:forEach var="propertyFeature" items="${propertyfeatures}">
            <tr>
                <td><c:out value="${propertyFeature.feature_id}"/></td>
                <td><c:out value="${propertyFeature.listing_id}"/></td>
                <td><c:out value="${propertyFeature.feature_name}"/></td>
                <td><c:out value="${propertyFeature.feature_value}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
