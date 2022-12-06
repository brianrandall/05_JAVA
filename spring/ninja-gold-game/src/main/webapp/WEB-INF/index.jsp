<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ngGame</title>
</head>
<body>
    <div class="top">
        <div>
            Your Gold: 
            <input type="number" placeholder="${goldAmount}">
        </div>
        
        <form action="/gold/reset" method="post">
            <input type="submit" value="Reset">
        </form>
    </div>
    <div class="actionContainer">
        <div class="action">
            <h2>Farm</h2>
            <p>(earns 10-20 golds)</p>
            <form action="/gold/process" method="post">
                <input type="hidden" name="building" value="farm">
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="action">
            <h2>Cave</h2>
            <p>(earns 5-10 golds)</p>
            <form action="/gold/process" method="post">
                <input type="hidden" name="building" value="cave">
                <input type="submit" value="Find Gold!">
            </form>
        </div>
        <div class="action">
            <h2>House</h2>
            <p>(earns 2-5 golds)</p>
            <form action="/gold/process" method="post">
                <input type="hidden" name="building" value="house">
                <input type="submit" value="Find Gold!">
            </form>
        </div>

        <c:if test="${goldAmount > 0}">
        <div class="action">
            <h2>Spa</h2>
            <p>(takes 5-20 gold)</p>
            <form action="/gold/process" method="post">
                <input type="hidden" name="building" value="spa">
                <input type="submit" type="hidden" value="Relax!">
            </form>
        </div>
         </c:if>
         <c:if test="${goldAmount <= 0 || goldAmount == null}">
            <span style="color: red; font-style: oblique">
                not enough gold 2 spa
            </span>
        </c:if>

        <div class="action">
            <h2>Quest</h2>
            <p>(earns/takes 0-50 golds)</p>
            <form action="/gold/process" method="post">
                <input type="hidden" name="building" value="isQuest">
                <input type="submit" value="Go on a quest!">
            </form>
        </div>
    </div>
    
    <h2>Activities:</h2>
    <div class="activityContainer">
        <c:forEach var="activity" items="${activities}">
            <c:if test = "${activity.contains('lost')}">
                    <span style="color: red;"><c:out value="${activity}"/></span><br/> 
            </c:if>
            <c:if test = "${activity.contains('got')}">
                <span style="color: green;"><c:out value="${activity}"/></span><br/>
            </c:if>
            <c:if test = "${activity.contains('spa')}">
                <span style="color: lightblue;"><c:out value="${activity}"/></span><br/>
            </c:if>
        </c:forEach>
    </div>


</body>
</html>