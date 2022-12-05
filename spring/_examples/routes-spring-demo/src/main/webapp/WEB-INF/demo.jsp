<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
    pageEncoding = "ISO-8859-1" import ="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>demo</title>
</head>
<body>
        <% for(int i=0;i<5;i++){ %>
            <p>hello</p>
        <% } %>
        <br>
        <h3>
            The time is <%= new Date() %>
        </h3>
        <p>
            ${2+3}
        </p>

</body>
</html>

