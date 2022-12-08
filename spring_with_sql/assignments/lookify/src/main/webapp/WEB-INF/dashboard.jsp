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
    <title>good lookin dashboard</title>
</head>
<body>
    <div id="header">
        <a href="/songs/new">Add New</a>
        <a href="/search/top-ten">Top 10 Songs</a>
        <form action="/search/" method="get" id="song-search">
            <input type="text" name="search">
            <input type="submit" value="Search Artists">
        </form>
    </div>
    <table>
        <thead>
            <tr>
                <th>Song Title</th>
                <th>Artist</th>
                <th>Rating</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${song}" var="song">
                <tr>
                    <td><a href="/songs/${song.id}"> <c:out value="${song.title}" /> </a> </td>
                    <td> <c:out value="${song.artist}" /> </td>
                    <td> <c:out value="${song.rating}" /> </td>
                    <td>
                        <form action="/songs/${song.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Delete this">
                        </form>                       
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>