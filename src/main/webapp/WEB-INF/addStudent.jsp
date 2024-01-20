<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet.model.Lesson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Lesson</title>
</head>
<body>
Add Lesson<br>
<% List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons"); %>

<form method="post" action="/addStudent" enctype="multipart/form-data">
    Students name: <input type="text" name="studentName"><br>
    Students surname: <input type="text" name="studentSurname"><br>
    Students email: <input type="text" name="studentEmail"><br>
    Students age: <input type="number" name="studentAge"><br>
    Students User: <input type="hidden" name="user_id"><br>
    <select name="lesson_id">
        <%
            for (Lesson lesson : lessons) {%>
        <option value="<%=lesson.getId()%>"><%=lesson.getName()%>
        </option>
        <%}%>
    </select>
    <input type="file" name="picture">
    <input type="submit" value="Add">
</form>
</body>
</html>
