<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List of Agents</h1>
<table border="1">
<thead>
<tr>
<th>Agent ID</th>
<th>Agent Name</th>
<th>Contact Information</th>
<th>Email</th>
</tr>
</thead>
<tbody>
<c:forEach var="agent" items="${agents}">
<tr>
<td><c:out value="${agent.agentId}"/></td>
<td><c:out value="${agent.agentName}"/></td>
<td><c:out value="${agent.contactInformation}"/></td>
<td><c:out value="${agent.email}"/></td>
</tr>
</c:forEach>
</tbody>
</table>