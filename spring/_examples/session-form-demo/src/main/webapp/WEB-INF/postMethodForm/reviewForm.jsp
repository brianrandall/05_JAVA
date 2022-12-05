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
        <div>
            <label for="name">Movie:</label>
            <input type="text" name="movie">
        </div>
        <div>
            <label for="name">Comment:</label>
            <input type="text" name="comment">
        </div>
        <div>
            <label for="name">Rating:</label>
            <input type="text" name="rating">
        </div>
        <input type="submit" value="Submit">

</body>
</html>