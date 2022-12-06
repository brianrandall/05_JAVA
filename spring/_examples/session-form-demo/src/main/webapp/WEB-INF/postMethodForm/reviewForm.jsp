<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>
        Review Form
    </h1>
    <form action="/form/process" method="post">
        <input type="hidden" name="uuid" value="12">
        <div>
            <label for="name">Movie:</label>
            <input type="text" name="movie">
            <span style="font-style: oblique; font-size: small; color: crimson">
                <c:out value="${movieError}"/>
            </span>
        </div>
        <div>
            <label for="name">Comment:</label>
            <input type="text" name="comment">
            <span style="font-style: oblique; font-size: small; color: crimson">
                <c:out value="${commentError}"/>
            </span>
        </div>
        <div>
            <label for="name">Rating:</label>
            <input type="text" name="rating">
            <span style="font-style: oblique; font-size: small; color: crimson">
                <c:out value="${ratingError}"/>
            </span>
        </div>
        <input type="submit" value="Submit">

</body>
</html>