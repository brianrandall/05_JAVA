<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>look at all of our books</title>
</head>
<body>
    <h1>
        all of the books in the entire universe
    </h1>
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
                    Language
                </th>
                <th>
                    Number of pages
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allBooks}" var="book">
                <tr>
                    <td>
                        <c:out value="${book.id}"/>
                    </td>
                    <td>
                        <a href="<c:out value="${book.id}"/>"> <c:out value="${book.title}"/> </a>
                    </td>
                    <td>
                        <c:out value="${book.language}"/>
                    </td>
                    <td>
                        <c:out value="${book.numberOfPages}"/>
                    </td>
                </tr>
            </c:forEach>
    </table>
    
</body>
</html>