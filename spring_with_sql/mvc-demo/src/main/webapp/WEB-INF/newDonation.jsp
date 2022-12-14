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
    <title>time for a new donation</title>
</head>
<body>
    <form:form action = "new-donation" method="post" modelAttribute="donation">
       <p>
            <form:select path="donorName">
                <c:forEach items="${allUsers}" var="user">
                    <form:option value="${user.id}" path="donorName"><c:out value="${user.userName}" /> </form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="donationName">Donation</form:label>
            <form:input type="text" path="donationName" id="donationName" />
            <form:errors path="donationName" cssClass="error"/>
        </p>
        <p>
            <form:label path="quantity">Quantity</form:label>
            <form:input type="text" path="quantity" id="quantity" />
            <form:errors path="quantity" cssClass="error"/>
         </p>
        <input type="submit" value="Add Donation">
    </form:form>
    
</body>
</html>