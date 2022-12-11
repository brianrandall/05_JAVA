<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>all the books in the club</title>
</head>
<body>
    <div class="top">
        <h1>Welcome, <c:out value="${user.name}"/></h1>
        <a href="/logout">logout</a>
    </div>
    <div class="top">
        <span style="font-style: oblique;">
            Books from everyone's shelves.
        </span>
        <a href="/books/new">+ add a book</a>
    </div>
    <table>
        <thead>
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Title
                </th>
                <th>
                    Author Name
                </th>
                <th>
                    Posted By
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allBooks}" var="book">
                <tr>
                    <td>
                        ${book.id}
                    </td>
                    <td>
                        <a href="/books/${book.id}">
                            ${book.title}
                        </a>
                    </td>
                    <td>
                        ${book.author}
                    </td>
                    <td>
                        ${book.user.name}
                    </td>
                    
                </tr>
            </c:forEach>
    </table>
            
</body>
</html>