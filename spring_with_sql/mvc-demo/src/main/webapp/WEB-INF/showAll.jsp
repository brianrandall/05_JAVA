<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>look at all our donations</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>
                    Donation
                </th>
                <th>
                    Donor Name
                </th>
                <th>
                    Quantity
                </th>
                <th>
                    Delete
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allDonations}" var="donation">
                <tr>
                    <td>
                        ${donation.donationName}
                    </td>
                    <td>
                        ${donation.donorName.userName}
                    </td>
                    <td>
                        ${donation.quantity}
                    </td>
                    <td>
                        <form action="/donations/${donation.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Delete ${donation.donorName.userName}'s ${donation.donationName}">
                        </form>
                </tr>
            </c:forEach>
    </table>
    <form action="/donations/search" method="get">
        <input type="text" name="searchTerm">
        <input type="submit" value="Search">
    </form>
    
</body>
</html>