<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Register</h1>
        <form:form action="/users/login/register" method="post" modelAttribute="newUser">
        <label>User Name</label>
        <form:input path="userName" />
        <form:errors path="userName" cssClass="error"/>
        <label>Email</label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error"/>
        <label>Password</label>
        <form:input path="password" />
        <form:errors path="password" cssClass="error"/>
        <label>Confirm Password</label>
        <form:input path="confirm" />
        <form:errors path="confirm" cssClass="error"/>
        <input type="submit" value="Register" />
    </form:form>

    <h1>Login</h1>
    <form:form action="/users/login" method="post" modelAttribute="loginUser">
    <label>Email</label>
    <form:input path="email" />
    <form:errors path="email" cssClass="error"/>
    <label>Password</label>
    <form:input path="password" />
    <form:errors path="password" cssClass="error"/>
    <input type="submit" value="Login" />
    </form:form>

</body>
</html>