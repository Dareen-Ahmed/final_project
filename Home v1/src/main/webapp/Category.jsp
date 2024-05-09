<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List of Categories</h1>
<table border="1">
<thead>
<tr>
<th>Category ID</th>
<th>Category Name</th>
</tr>
</thead>
<tbody>
<c:forEach var="category" items="${categories}">
<tr>
<td><c:out value="${category.categoryId}"/></td>
<td><c:out value="${category.categoryName}"/></td>
</tr>
</c:forEach>
</tbody>
</table>