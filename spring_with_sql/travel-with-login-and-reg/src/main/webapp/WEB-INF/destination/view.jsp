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
    <h1>welcome to <c:out value="${destination.destinationName}" /></h1>
    <h3>is Recommended? : 
        <while>
            <c:choose>
                <c:when test="${destination.wouldRecommend == true}">
                    <c:out value="yes" />
                </c:when>
                <c:otherwise>
                    <c:out value="no" />
                </c:otherwise>
            </c:choose>
        </while>
    


</body>
</html>