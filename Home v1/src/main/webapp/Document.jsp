<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Documents List</h1>
<table border="1">
<thead>
<tr>
<th>Document ID</th>
<th>Document Name</th>
<th>Document Description</th>
<th>Document Image</th>
</tr>
</thead>
<tbody>
<c:forEach var="document" items="${documents}">
<tr>
<td><c:out value="${document.documents_id}"/></td>
<td><c:out value="${document.documents_name}"/></td>
<td><c:out value="${document.documents_description}"/></td>
<td><c:out value="${document.documents_image}"/></td>
</tr>
</c:forEach>
</tbody>
</table>