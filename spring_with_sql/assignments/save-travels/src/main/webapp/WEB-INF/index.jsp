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
    <h1>Save Travels!</h1>
    <table>
        <thead>
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${expenses}" var="expense">
                <tr>
                    <td><a href="/expenses/${expense.id}"> <c:out value="${expense.expenseName}" /> </a> </td>
                    <td> <c:out value="${expense.vendorName}" /> </td>
                    <td> $<c:out value="${expense.expenseAmount}" /> </td>
                    <td>
                        <div class="iHateTables">
                            <a href="/expenses/edit/${expense.id}">Edit</a>
                            <pre> | </pre>
                            <form action="/expenses/${expense.id}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <input type="submit" value="Delete">
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <form action="/expenses/search" method="get">
        <input type="text" name="searchTerm">
        <input type="submit" value="Search">
    </form>

    <h2>Add an expense:</h2>
    <form:form action = "/expenses/new" method="post" modelAttribute="expense">
       <p>
            <form:label path="expenseName">Expense Name:</form:label><br>
            <form:input type="text" path="expenseName" id="expenseName" />
            <form:errors path="expenseName" cssClass="error"/>
        </p>
        <p>
            <form:label path="vendorName">Vendor:</form:label><br>
            <form:input type="text" path="vendorName" id="vendorName" />
            <form:errors path="vendorName" cssClass="error"/>
        </p>
        <p>
            <form:label path="expenseAmount">Amount:</form:label><br>
            $<form:input type="text" path="expenseAmount" id="expenseAmount" />
            <form:errors path="expenseAmount" cssClass="error"/>
         </p>
         <p>
            <form:label path="description">Description:</form:label><br>
            <form:textarea path="description" id="description"/>
            <form:errors path="description" cssClass="error"/>
         </p>
        <input type="submit" value="Submit" cssClass="btn">
         
    </form:form>
    
</body>
</html>