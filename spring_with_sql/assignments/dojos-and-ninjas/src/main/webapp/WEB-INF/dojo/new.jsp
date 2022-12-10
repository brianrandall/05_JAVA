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
    <title>make a dojo</title>
</head>
<body>
    <h1>create a dojo</h1>
    <form:form action = "/dojos/new" method="post" modelAttribute="dojo">
        <p>
            <form:label path="name">Dojo Name</form:label>
            <form:input type="text" path="name" />
            <form:errors path="name" cssClass="error"/>
        </p>
        <input type="submit" value="Create Dojo">

    </form:form>
</body>
</html>