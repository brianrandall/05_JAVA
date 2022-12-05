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
        form results
    </h1>
    <h2>
        movie:
    </h2>
    <c:out value="${movieFromSession}"/>
    <h2>
        comment:
    </h2>
    <c:out value="${commentFromSession}"/>
    <h2>
        rating:
    </h2>
    <c:out value="${ratingFromSession}"/>


</body>
</html>