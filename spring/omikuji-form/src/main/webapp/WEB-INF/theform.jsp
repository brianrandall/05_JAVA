<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Send Omikuji</title>
</head>
<body>
    <div class="container">
        <h2>
            Send an Omikuji!
        </h2>
        <div class="formContainer">
            <form action="/omikuji/form/process" method="post">
                <p>
                    Pick any number from 5 to 25:
                    <br>
                    <input type="number" name="number" min="5" max="25" required>
                </p>
                <p>
                    Enter the name of a city:
                    <br>
                    <input type="text" name="city" required>
                </p>
                <p>
                    Enter the name of any real person, living or dead:
                    <br>
                    <input type="text" name="person" required>
                </p>
                <p>
                    Enter an activity. Can be a profession, hobby, or anything else:
                    <br>
                    <input type="text" name="activity" required>
                </p>
                <p>
                    Enter any type of living thing:
                    <br>
                    <input type="text" name="livingThing" required>
                </p>
                <p>
                    Say something nice:
                    <br>
                    <input type="textarea" name="niceThing" required>
                </p>
                <div class="formFooter">
                    <span style="font-style: oblique;">
                        Send and show to a friend!
                    </span>
                    <br>
                    <input type="submit" value="send">
                </div>
            </form>
        </div>
    </div>

</body>
</html>