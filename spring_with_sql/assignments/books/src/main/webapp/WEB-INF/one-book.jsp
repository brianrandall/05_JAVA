<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>look at this book</title>
</head>
<body>
    <h1>
        <c:out value="${oneBook.title}"/>
    </h1>
    <p>
        Description: <c:out value="${oneBook.description}"/><br/>
        Language: <c:out value="${oneBook.language}"/><br/>
        Number of pages: <c:out value="${oneBook.numberOfPages}"/><br/>
    </p>
    
</body>
</html>