<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Listings</h1>
<table border="1">
    <thead>
        <tr>
            <th>Listing ID</th>
            <th>City ID</th>
            <th>Category ID</th>
            <th>Agent ID</th>
            <th>Offer ID</th>
            <th>Type ID</th>
            <th>Document ID</th>
            <th>Bedrooms</th>
            <th>Bathrooms</th>
            <th>Square Footage</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="listing" items="${listings}">
            <tr>
                <td><c:out value="${listing.listing_id}"/></td>
                <td><c:out value="${listing.city_id}"/></td>
                <td><c:out value="${listing.category_id}"/></td>
                <td><c:out value="${listing.agent_id}"/></td>
                <td><c:out value="${listing.offer_id}"/></td>
                <td><c:out value="${listing.type_id}"/></td>
                <td><c:out value="${listing.document_id}"/></td>
                <td><c:out value="${listing.bedrooms}"/></td>
                <td><c:out value="${listing.bathrooms}"/></td>
                <td><c:out value="${listing.square_footage}"/></td>
                <td><c:out value="${listing.price}"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>