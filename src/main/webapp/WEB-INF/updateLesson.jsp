<%@ page import="com.example.studentlessonservlet.model.Lesson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Lesson</title>
</head>
<body>
<%Lesson lesson = (Lesson) request.getAttribute("lesson"); %>
Update Lesson<br><br>
<form method="post" action="/updateLesson">
    <input type="hidden" name="lessonId" value="<%=lesson.getId()%>">
    Lesson name: <input type="text" name="lessonName" value="<%=lesson.getName()%>"><br>
    Lesson duration: <input type="number" step="1" min="1" max="120" value="<%=lesson.getDuration()%>"
                            name="lessonDuration"><br>
    Lesson lecturer name: <input type="text" name="lessonLecturerName" value="<%=lesson.getLecturerName()%>"><br>
    Lesson price: <input type="number" name="lessonPrice" value="<%=lesson.getPrice()%>"><br>
    Lesson picture: <input type="file" name="lessonPicName" value="<%=lesson.getPicName()%>"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
