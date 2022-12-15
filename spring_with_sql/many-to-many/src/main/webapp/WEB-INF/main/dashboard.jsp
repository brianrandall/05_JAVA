<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css"
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>
                    Game Title
                </th>
                <th>
                    Genres
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allGames}" var="game">
                <tr>
                    <td>
                        ${game.title}
                    </td>
                    <td>
                        <c:forEach items="${game.genres}" var="genre">
                            ${genre.title}
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
    </table>
    
</body>
</html>