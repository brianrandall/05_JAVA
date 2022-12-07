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
    <title>save travels!</title>
</head>
<body>
    <h1>Edit <c:out value="${expense.expenseName}"/> </h1>
    
    <form:form action = "/expenses/edit/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">
       <p>
            <form:label path="expenseName">Expense Name</form:label>
            <form:input type="text" path="expenseName" id="expenseName" />
            <form:errors path="expenseName" cssClass="error"/>
        </p>
        <p>
            <form:label path="vendorName">Vendor</form:label>
            <form:input type="text" path="vendorName" id="vendorName" />
            <form:errors path="vendorName" cssClass="error"/>
        </p>
        <p>
            <form:label path="expenseAmount">Amount $</form:label>
            <form:input type="text" path="expenseAmount" id="expenseAmount" />
            <form:errors path="expenseAmount" cssClass="error"/>
         </p>
         <p>
            <form:label path="description">Description</form:label><br>
            <form:textarea path="description" id="description"/>
            <form:errors path="description" cssClass="error"/>
         </p>
        <input type="submit" value="Submit">
        
    </form:form>
    
</body>
</html>