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
    <title>createusr</title>
</head>
<body>
    <h1>create user</h1>
    <form:form action = "/users/new" method="post" modelAttribute="user">
        <p>
            <form:label path="userName">Username</form:label>
            <form:input type="text" path="userName" id="userName" />
            <form:errors path="userName" cssClass="error"/>
        </p>
        <p>
            <form:label path="email">Email</form:label>
            <form:input type="text" path="email" id="email" />
            <form:errors path="email" cssClass="error"/>
        </p>
        <input type="submit" value="Create User">

    </form:form>
</body>
</html>