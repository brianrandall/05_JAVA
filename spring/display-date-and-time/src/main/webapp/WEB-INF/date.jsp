<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
    pageEncoding = "ISO-8859-1" import = "java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>

<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Date</title>
</head>
<body>
${alert}
    <div class="date">
    <p>
        <fmt:formatDate pattern = "EE, MM/d/yyyy" 
         value = "${date}" />
    </p>
    <p>
        <a href="/">Home</a>
    </p>
    </div>
</body>
</html>

