<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${project.title} info</title>
</head>
<body>
    <div class="topnav">
        <h1>${project.title} details</h1>
        <a href="/">back to dashboard</a>
    </div>
    <div class="project">
        <h3>Project Description: ${project.description}</h3>
        <h3>Project Due Date: <fmt:formatDate value="${project.dueDate}" pattern="MM-dd-yy"/></h3>
        <h3>Project Lead: ${project.lead.firstName} ${project.lead.lastName}</h3>
    </div>
    <hr/>
    <div class="topnav">
        <a href="/projects/${project.id}/tasks">See tasks!</a>
        <c:if test="${project.lead.id == user_id}" >
            <form action="/books/${book.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete ${project.title}">
            </form>
    </c:if>
    </div>
</body>
</html>