<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>pro man</title>
</head>
<body>
    <div class="topnav">
        <h1>Welcome ${user.firstName}</h1>
        <a href="/logout">Logout</a>
    </div>
    <div class="topnav">
        <h3>All projexxx</h3>
        <a href="/projects/new">++++++++++++ New project</a>
    </div>
    <hr/>
    <table>
        <thead>
            <tr>
                <th>Project name</th>
                <th>Team Lead</th>
                <th>Due Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${unassignedProjects}" var="project">
                <tr>
                    <td><a href="projects/${project.id}">${project.title}</a></td>
                    <td>${project.lead.firstName}</td>
                    <td><fmt:formatDate value="${project.dueDate}" pattern="MM-dd-yy"/></td>
                    <td>
                        <a href="/projects/join/${project.id}">join team</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <h3>Your Projects</h3>
    <hr/>
    <table>
        <thead>
            <tr>
                <th>Project name</th>
                <th>Team Lead</th>
                <th>Due Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${myProjects}" var="project">
                <tr>
                    <td><a href="projects/${project.id}">${project.title}</a></td>
                    <td>${project.lead.firstName}</td>
                    <td><fmt:formatDate value="${project.dueDate}" pattern="MM-dd-yy"/></td>
                    <c:if test="${project.lead.firstName == user.firstName}">
                        <td>
                            <a href="/projects/edit/${project.id}">Edit</a>
                        </td>
                    </c:if>
                    <c:if test="${project.lead.firstName != user.firstName}">
                        <td>
                            <a href="/projects/leave/${project.id}">Leave</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>    
</body>
</html>