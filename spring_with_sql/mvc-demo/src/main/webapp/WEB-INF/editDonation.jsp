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
    <title>edit donation</title>
</head>
<body>
    <form:form action = "/donations/edit/process/${donation.id}" method="post" modelAttribute="donation">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="donorName">Donor Name</form:label>
        <form:input type="text" path="donorName" id="donorName" />
        <form:errors path="donorName" cssClass="error"/>
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