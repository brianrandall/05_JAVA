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
    <title>jstl demo</title>
</head>
<body>
    <h1>
        JSTL demo
    </h1>
    <p>
        <c:out value = "${nameFromController}"/>
    </p>
    <p>
        <c:out value = "${ageFromController}"/>
    </p>
    <p>
        Hungry? <c:out value = "${isHungryFromController}"/>
    </p>
    <h2>
        If statements
    </h2>
    <p>
        <c:if test = "${isHungryFromController}">
            <c:out value = "${nameFromController}"/>
            is hungry
        </c:if>
    </p>
    <p>
        <c:if test = "${nameFromController.length() > 3}">
            <c:out value = "${nameFromController}"/>
            is longer than 3 characters
        </c:if>
    </p>
    <h2>
        if / else (aka choose / when / otherwise)
    </h2>
    <p>
        <c:choose>
            <c:when test = "${ageFromController < 21}">
                <c:out value = "${nameFromController}"/>
                is less than 21
            </c:when>
            <c:otherwise>
                <c:out value = "${nameFromController}"/>
                is older than 21
            </c:otherwise>
        </c:choose>
    </p>
    <h2>
        for each
    </h2>
    <p>
        <c:forEach var = "x" items = "${usersFromController}" >
            <c:out value = "${x}"/>
            <br/>
        </c:forEach>
    </p>
    <h2>
        Styling
    </h2>
    <div class = "styleTest">
        <c:out value = "${nameFromController}"/>
    </div>





</body>
</html>

