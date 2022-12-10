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
    <title>all the nijajajas in the dojojojo</title>
</head>
<body>
    <a href="/" >back to make dojo</a><br>
    <a href="/ninjas/new" >add a ninja to whatevr dojo you want</a>
    <br>
    
    <h1>all ninjas all doojojojo</h1>
    <table>
        <thead>
            <tr>
                <th>
                    First Name
                </th>
                <th>
                    Last Name
                </th>
                <th>
                    Age
                </th>
                <th>
                    Dojo
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ninjas}" var="ninja">
                <tr>
                    <td>
                        ${ninja.firstName}
                    </td>
                    <td>
                        ${ninja.lastName}
                    </td>
                    <td>
                        ${ninja.age}
                    </td>
                    <td>
                        <a href="/dojos/${ninja.dojo.id}">${ninja.dojo.name}</a>
                    </td>
                    
                </tr>
            </c:forEach>
    </table>
</body>
</html>