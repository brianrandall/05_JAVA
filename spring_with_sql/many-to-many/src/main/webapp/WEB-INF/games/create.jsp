<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css"
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>create game</title>
</head>
<body>
    <form:form action = "/games/create" method="post" modelAttribute="game">
        <h1>create a  game</h1>
        <p>
            <form:label path="title">Title: </form:label>
            <form:input type="text" path="title" id="title" />
            <form:errors path="title" cssClass="error"/>
        </p>
        <p>
            <form:label path="formGenres">Genres: </form:label>
            <form:input type="text" path="formGenres" id="formGenres" />
            <form:errors path="formGenres" cssClass="error"/>
         </p>
        <input type="submit" value="Add Game">
    </form:form>
    
</body>
</html>