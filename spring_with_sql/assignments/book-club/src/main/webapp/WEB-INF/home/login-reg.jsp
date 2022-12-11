<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>booooooooooklub</title>
</head>
<body>
    <h1>Book Club</h1>
    <span style="font-style: oblique;">
        A place for friends to share thoughts on books.
    </span>
    <div class="container">
        <div class="reg">
            <h2>Register</h2>
            <form:form action="/register" method="post" modelAttribute="newUser" cssClass="form">
                <p>
                    <label>name</label>
                    <form:input path="name" /><br>
                    
                </p>
                <p>
                    <label>email</label>
                    <form:input path="email" /><br>
                    
                </p>
                <p>
                    <label>password</label>
                    <form:input path="password" /><br>
                    
                </p>
                <p>
                    <label>confirm password</label>
                    <form:input path="passwordConfirmation" /><br>
                   
                </p>
                <p>
                    <input type="submit" value="Register" />
                </p>
                <div cssClass="errorDiv">
                    <form:errors path="name" cssClass="error"/>
                    <form:errors path="email" cssClass="error"/>
                    <form:errors path="password" cssClass="error"/> 
                    <form:errors path="passwordConfirmation" cssClass="error"/>
                </div>
            </form:form>
        </div>
        <div class="login">
            <h2>Login</h2>
            <form:form action="/login" method="post" modelAttribute="loginUser" cssClass="form">
                <p>
                    <label>email</label>
                    <form:input path="email" /><br>
                </p>
                <p>
                    <label>password</label>
                    <form:input path="password" /><br>
                </p>
                <p>
                    <input type="submit" value="Login" />
                </p>
                <div cssClass="errorDiv">
                    <form:errors path="email" cssClass="error"/>
                    <form:errors path="password" cssClass="error"/>
                </div>
            </form:form>
        </div>
    </div>
            
</body>
</html>