<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Transactions</title>
</head>
<body>
    <h1>List of Transactions</h1>
    <table border="1">
        <tr>
            <th>Transaction ID</th>
            <th>listing ID</th>
            <th>Buyer ID</th>
            <th>Seller ID</th>
            <th>Transaction Date</th>
            <th>Transaction Amount</th>
        </tr>
        <c:forEach var="transaction" items="${transactions}">
            <tr>
                <td><c:out value="${transaction.transaction_id}"/></td>
                <td><c:out value="${transaction.listing_id}"/></td>
                <td><c:out value="${transaction.buyer_id}"/></td>
                <td><c:out value="${transaction.seller_id}"/></td>
                <td><c:out value="${transaction.transaction_date}"/></td>
                <td><c:out value="${transaction.transaction_amount}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>