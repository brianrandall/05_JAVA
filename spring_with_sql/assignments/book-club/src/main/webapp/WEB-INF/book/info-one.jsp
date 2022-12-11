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
    <title>newboo</title>
</head>
<body>
    <div class="top">
        <h1 style="font-style: oblique;">${book.title}</h1>
        <a href="/">back to the shelvz</a>
    </div>
    <c:if test="${book.user.id == user.id}" >
        You read this book. here is what you thought about it
    </c:if>
    <c:if test="${book.user.id != user.id}" >
        <span style="color: red;">${book.user.name}</span> read <span style="color: purple;">${book.title}</span> by <span style="color: green;">${book.author}</span>.
        <p>here is what they thought about it...</p>
    </c:if>
    <hr/>
    <p style="font-style: oblique;">
        ${book.description}
    </p>
    <hr/>

    <c:if test="${book.user.id == user.id}" >
        <div class="edit-delete">
            <form action="/books/edit/${book.id}" method="get">
                <input type="submit" value="Edit ${book.title}">
            </form>
            <form action="/books/${book.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete ${book.title}">
            </form>
        </div>
    </c:if>
    
    
    
</body>
</html>