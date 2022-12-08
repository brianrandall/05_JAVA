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
    <title>Document</title>
</head>
<body>

    <a href="/dashboard">go back to dashboard</a>
    <form:form action = "/songs/new" method="post" modelAttribute="song">
       <p>
            <form:label path="title">Title:</form:label><br>
            <form:input type="text" path="title" id="title" />
            <form:errors path="title" cssClass="error"/>
        </p>
        <p>
            <form:label path="artist">Artist:</form:label><br>
            <form:input type="text" path="artist" id="artist" />
            <form:errors path="artist" cssClass="error"/>
        </p>
        <p>
            <form:label path="rating">Rating:</form:label><br>
            <form:input type="text" path="rating" id="rating" />
            <form:errors path="rating" cssClass="error"/>
         </p>
        <input type="submit" value="Add Song" cssClass="btn">
         
    </form:form>
    
</body>
</html>