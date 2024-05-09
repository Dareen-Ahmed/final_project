<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List of Cities</h1>
<table border="1">
<thead>
<tr>
<th>City ID</th>
<th>City Name</th>
</tr>
</thead>
<tbody>
<c:forEach var="city" items="${cities}">
<tr>
<td><c:out value="${city.cityId}"/></td>
<td><c:out value="${city.cityName}"/></td>
</tr>
</c:forEach>
</tbody>
</table>