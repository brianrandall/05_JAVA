<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>
</head>
<body>
    welcome to my home page
    <br>
    <a href="/your_server/counter">have you ever wondered how many times this page has been loaded????????????</a>
    <br>
    <form action="/your_server/counter/increaseby2" method="post">
        <input type="submit" value="increase by 2">
    </form>
    <form action="/your_server/counter/increaseby4000" method="post">
        <input type="submit" value="increase by 4000 lol">
    </form>
    <form action="/your_server/counter/reset" method="post">
        <input type="submit" value="reset counter">
    </form>

</body>
</html>