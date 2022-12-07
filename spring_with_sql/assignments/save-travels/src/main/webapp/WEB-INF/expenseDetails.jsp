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
    <h1> <c:out value="${expense.expenseName}" /> </h1>
    <a href="/expenses">home</a>
    
    <p>
        Expense Name: <c:out value="${expense.expenseName}" /><br>
        Expense Description: <c:out value="${expense.description}" /><br>
        Vendor: <c:out value="${expense.vendorName}" /><br>
        Amount: <c:out value="${expense.expenseAmount}" /><br>
    </p>
    
</body>
</html>