<%--
  Created by IntelliJ IDEA.
  User: Hakob
  Date: 13.01.2024
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Lesson</title>
</head>
<body>
Add Lesson<br>

<form method="post" action="/addLesson">
    Lesson name: <input type="text" name="lessonName"><br>
    Lesson duration: <input type="number"  step="1"  min="1" max="120" value="40" name="lessonDuration"><br>
    Lesson lecturer name: <input type="text" name="lessonLecturerName"><br>
    Lesson price: <input type="number" name="lessonPrice"><br>
    <input type="submit" value="Add">
</form>
</body>
</html>
