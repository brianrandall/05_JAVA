<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <h2>
            Here's Your Omikuji!
        </h2>
        <div class="form-result">
            <span>
                In <c:out value="${number}"/> years, you will be living in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, <c:out value="${activity}"/> for a living. The next time you see a <c:out value="${livingThing}"/>, you will have good luck. Also <c:out value="${niceThing}"/>.
            </span>
        </div>
        <a href="/omikuji">start over</a>
    </div>
</body>
</html>