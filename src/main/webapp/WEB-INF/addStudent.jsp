<%@ page import="com.example.studentlessonservlet.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet.model.Lesson" %><%--
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
<% List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons"); %>

<form method="post" action="/addStudent" enctype="multipart/form-data">
    Students name: <input type="text" name="studentName"><br>
    Students surname: <input type="text" name="studentSurname"><br>
    Students email: <input type="text" name="studentEmail"><br>
    Students age: <input type="number" name="studentAge"><br>
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
