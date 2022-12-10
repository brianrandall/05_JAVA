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
    <title>new ninj</title>
</head>
<body>
    <form:form action = "/ninjas/new" method="post" modelAttribute="ninja">
       <p>
            <form:select path="dojo">
                <c:forEach items="${dojos}" var="dojo">
                    <form:option value="${dojo.id}" path="dojo"><c:out value="${dojo.name}" /> </form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="firstName">First Name: </form:label>
            <form:input type="text" path="firstName" id="firstName" />
            <form:errors path="firstName" cssClass="error"/>
        </p>
        <p>
            <form:label path="lastName">Last Name: </form:label>
            <form:input type="text" path="lastName" id="lastName" />
            <form:errors path="lastName" cssClass="error"/>
         </p>
         <p>
            <form:label path="age">Age: </form:label>
            <form:input type="number" path="age" id="age" />
            <form:errors path="age" cssClass="error"/>
         </p>
        <input type="submit" value="Add Ninja">
    </form:form>
    
</body>
</html>