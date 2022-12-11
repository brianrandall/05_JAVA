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
    <title>newboo</title>
</head>
<body>
    <div class="top">
        <h1>add a book to your shelf!</h1>
        <a href="/">back to the shelvz</a>
    </div>
    
    <form:form action = "/books/edit/${book.id}" method="post" modelAttribute="book">
        <form:input type="hidden" path="user" value="${user_id}" />
        <input type="hidden" name="_method" value="put" />
        <div class="errorDiv">
            <form:errors path="title" cssClass="error"/>
            <form:errors path="author" cssClass="error"/>
            <form:errors path="description" cssClass="error"/>
        </div>
        <p>
            <form:label path="title">title: </form:label>
            <form:input type="text" path="title" id="title" />
            
            
        </p>
        <p>
            <form:label path="author">author: </form:label>
            <form:input type="text" path="author" id="author" />
            
         </p>
         <p>
            <form:label path="description">thoughts: </form:label>
            <form:textarea type="text" rows="5" cols="30" path="description" id="description" />
         </p>
        <input type="submit" value="submit changes" />
    </form:form>
    
</body>
</html>