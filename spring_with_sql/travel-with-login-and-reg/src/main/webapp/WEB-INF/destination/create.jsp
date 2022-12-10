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
    <title>destyyy</title>
</head>
<body>
    <h1>add a destination</h1>

    <form:form action="/destinations/create" method="post" modelAttribute="destination">
        <form:input type="hidden" path="traveler" value="${user_id}" />
            <label>Destination Name</label>
                <form:input path="destinationName" />
                <form:errors path="destinationName" cssClass="error"/>
            <label>Recommended?</label>
                <form:checkbox path="wouldRecommend" value="true" />
                <form:errors path="wouldRecommend" cssClass="error"/>
            <input type="submit" value="Create" />
    </form:form>


</body>
</html>