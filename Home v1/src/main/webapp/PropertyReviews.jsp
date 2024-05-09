<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Property Reviews</title>
</head>
<body>
	<table border="1">
	<h1>Property_Reviews</h1>
		<tr>
			<th>Review ID</th>
			<th>Listing ID</th>
			<th>User ID</th>
			<th>Rating</th>
			<th>Review Text</th>
			<th>Review Date</th>
		</tr>
		<c:forEach var="propertyReview" items="${propertyReviews}">
		<tr>
			<td>${propertyReview.review_id}</td>
			<td>${propertyReview.listing_id}</td>
			<td>${propertyReview.user_id}</td>
			<td>${propertyReview.rating}</td>
			<td>${propertyReview.review_text}</td>
			<td>${propertyReview.review_date}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>