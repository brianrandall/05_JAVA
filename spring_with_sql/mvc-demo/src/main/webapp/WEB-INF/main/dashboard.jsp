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
    <title>dash</title>
</head>
<body>
    <h1>dashboard</h1>
    <a href="/users/new">Create a new user</a>
    <a href="/donations/new-donation">Create a new donation</a>
    <br>
    <br>
    <h2>Donations</h2>
    <table>
        <thead>
            <tr>
                <th>Donation</th>
                <th>Donor</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allDonations}" var="donation">
                <tr>
                    <td><c:out value="${donation.donationName}"/></td>
                    <td><c:out value="${donation.donorName.userName}"/></td>
                    <td><c:out value="${donation.quantity}"/></td>
                </tr>
            </c:forEach>
    </table>
    <br>
    <br>
    <h2>Users</h2>
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th># of donations</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allUsers}" var="user">
                <tr>
                    <td><a href="/users/${user.id}"><c:out value="${user.userName}"/></a></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.donations.size()}"/></td>
                    <td>
                        <form action="/users/${user.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Delete ${user.userName}">
                        </form>
                        <a href="/users/${user.id}">Edit ${user.userName}</a>
                    </td>
                </tr>
            </c:forEach>
    
</body>
</html>