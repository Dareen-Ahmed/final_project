<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List of Property Types</h1>
<table border="1">
<thead>
<tr>
<th>PropertyType ID</th>
<th>PropertyType Name</th>
</tr>
</thead>
<tbody>
<c:forEach var="propertytype" items="${propertytypes}">
<tr>
<td><c:out value="${propertytype.type_id}"/></td>
<td><c:out value="${propertytype.type_name}"/></td>
</tr>
</c:forEach>
</tbody>
</table>