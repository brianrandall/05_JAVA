<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
    pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>fruit stuff</title>
</head>
<body>
    <h1>
        Fruit Store
    </h1>
    
    <p>
    <div class ="tableDiv">
        <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${fruitsFromController}" var="fruit">
            <tr>
                <td>
                    <c:out value="${fruit.name}"/>
                </td>
                <td>
                    <c:out value="${fruit.price}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
    </p>
</div>
    
</body>
</html>

