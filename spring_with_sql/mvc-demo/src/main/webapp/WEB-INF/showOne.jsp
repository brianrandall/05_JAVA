<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>look at all our donations</title>
</head>
<body>
    <h1>
        Donation: <c:out value = " ${oneDonation.donationName} "/>
    </h1>
    <h2>
        Donor: <c:out value = " ${oneDonation.donorName} "/>
    </h2>
    <h3>
        Quantity: <c:out value = " ${oneDonation.quantity} "/>
    </h3>
    
</body>
</html>