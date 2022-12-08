<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>top ten</title>
</head>

<body>
    <div id="header">
        <span>Top Ten Songs</span>
        <a href="/dashboard">dashboard</a>
    </div>
    <div id="top-ten">
        <table>
            <thead>
                <tr>
                    <th>
                        rating
                    </th>
                    <th>
                        title
                    </th>
                    <th>
                        artist
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${song}" var="song">
                    <tr>
                        <td>
                            <c:out value="${song.rating}" />
                        </td>
                        <td>
                            <a href="/songs/${song.id}">
                                <c:out value="${song.title}" />
                            </a>
                        </td>
                        <td>
                            <c:out value="${song.artist}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </div>
</body>
</html>