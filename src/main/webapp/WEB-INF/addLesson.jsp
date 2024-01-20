<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Lesson</title>
</head>
<body>
Add Lesson<br>

<form method="post" action="/addLesson" enctype="multipart/form-data">
    Lessons name: <input type="text" name="lessonName"><br>
    Lessons duration: <input type="number" step="1" min="1" max="120" value="40" name="lessonDuration"><br>
    Lessons lecturer name: <input type="text" name="lessonLecturerName"><br>
    Lessons price: <input type="number" name="lessonPrice"><br>
    Lessons User: <input type="hidden" name="user_id">
    Lessons picture: <input type="file" name="picture"><br>
    <input type="submit" value="Add">
</form>
</body>
</html>
