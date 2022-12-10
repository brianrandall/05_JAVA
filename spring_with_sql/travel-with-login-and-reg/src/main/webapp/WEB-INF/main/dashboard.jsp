<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>dash</title>
</head>
<body>
    <h1>Dashboard <c:out value="${loggedInUser.userName}" /> </h1>
    <a href="/users/logout">Logout</a>

    <table>
        <thead>
            <tr>
                <th>Destination Name</th>
                <th>Traveler</th>
                <th>Recommended?</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${destinations}" var="destination">
                <tr>
                    <td><a href="/destinations/${destination.id}">  <c:out value="${destination.destinationName}" /></a></td>
                    <td><c:out value="${destination.traveler.userName}" /></td>
                    <td>
                        <while>
                            <c:choose>
                                <c:when test="${destination.wouldRecommend == true}">
                                    <c:out value="yes" />
                                </c:when>
                                <c:otherwise>
                                    <c:out value="no" />
                                </c:otherwise>
                            </c:choose>
                        </while>
                    </td>
                    <td>
                        <a href="/destinations/edit/${destination.id}">Edit</a>
                        <form action="/destinations/${destination.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Delete ${donation.destinationName}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>