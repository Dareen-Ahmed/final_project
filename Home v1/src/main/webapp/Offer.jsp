<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List of Offers</h1>
<table border="1">
<thead>
<tr>
<th>Offer ID</th>
<th>Offer Description</th>
</tr>
</thead>
<tbody>
<c:forEach var="offer" items="${offers}">
<tr>
<td><c:out value="${offer.offer_id}"/></td>
<td><c:out value="${offer.offer_description}"/></td>
</tr>
</c:forEach>
</tbody>
</table>