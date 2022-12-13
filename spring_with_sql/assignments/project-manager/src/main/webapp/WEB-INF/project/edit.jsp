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
    <title>edproj</title>
</head>
<body>
    <div class="top">
        <h1>edit a ${project.title}</h1>
        <a href="/">back to dashboard</a>
    </div>
    
    <form:form action = "/projects/edit/${project.id}" method="post" modelAttribute="project">
        <form:input type="hidden" path="lead" value="${user_id}" />
        <input type="hidden" name="_method" value="put" /> 
        <div class="errorDiv">
            <form:errors path="title" cssClass="error"/>
            <form:errors path="description" cssClass="error"/>
            <form:errors path="dueDate" cssClass="error"/>
        </div>
        <p>
            <form:label path="title">title: </form:label>
            <form:input type="text" path="title" id="title" />
            
            
        </p>
        <p>
            <form:label path="description">description: </form:label>
            <form:input type="text" path="description" id="description" />
            
         </p>
         <p>
            <form:label path="dueDate">Due Date: </form:label>
            <form:input type="date" path="dueDate" id="dueDate" />
         </p>
        <input type="submit" value="Submit">
    </form:form>
    
</body>
</html>