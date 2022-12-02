<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
    pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>
        Customer Name: <c:out value = "${name}"/>
        <br/>
    </h1>
    <h2>
        Item Name: <c:out value = "${itemName}"/><br/>
        Price: <c:out value = "${price}"/><br/>
        Description: <c:out value = "${description}"/><br/>
        Vendor: <c:out value = "${vendor}"/>
    </h2>
</body>
</html>

