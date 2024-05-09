<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List of Users</h1>
<table border="1">
<thead>
<tr>
<th>User ID</th>
<th>User Name</th>
<th>Email</th>
<th>Password</th>
<th>Registration Date</th>
<th>Phone Number</th>
<th>Address</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}">
<tr>
<td><c:out value="${user.user_id}"/></td>
<td><c:out value="${user.username}"/></td>
<td><c:out value="${user.email}"/></td>
<td><c:out value="${user.password}"/></td>
<td><c:out value="${user.registration_date}"/></td>
<td><c:out value="${user.phone_number}"/></td>
<td><c:out value="${user.address}"/></td>
</tr>
</c:forEach>
</tbody>
</table>