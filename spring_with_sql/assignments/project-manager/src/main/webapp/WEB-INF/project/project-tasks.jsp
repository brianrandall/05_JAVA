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
    <title>${project.title} tasks</title>
</head>
<body>
    <div class="topnav">
        <h1>${project.title} tasks</h1>
        <a href="/">back to dashboard</a>
    </div>
    <span>Project Lead: ${project.lead.firstName}</span>
    <form:form action = "/projects/${project.id}/tasks" method="post" modelAttribute="task">
        <form:errors path="title" cssClass="error"/><br>
        <form:textarea path="title" rows="5" cols="50" />
        <input type="submit" value="Submit" />
    </form:form>
    <hr/>
    <div class="tasks">
        <c:forEach items="${project.tasks}" var="task">
            <div class="task">
                
                <span>added by ${task.creator.firstName} at <fmt:formatDate value="${task.createdAt}" pattern="MM-dd-yy, h:mm:ss a"/> </span><br>
                <span style="font-style: oblique;">///${task.title}</span>
            </div>
            
        </c:forEach>
    </div>
    
    
</body>
</html>