<%@ page import="com.example.studentlessonservlet.model.Student" %>
<%@ page import="com.example.studentlessonservlet.model.Lesson" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<%Student student = (Student) request.getAttribute("student"); %>
<%List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons"); %>
Update Student<br><br>
<form method="post" action="/updateStudent">
    <input type="hidden" name="studentId" value="<%=student.getId()%>">
    Student name: <input type="text" name="studentName" value="<%=student.getName()%>"><br>
    Student surname: <input type="text" value="<%=student.getSurname()%>" name="studentSurname"><br>
    Student email: <input type="text" name="studentEmail" value="<%=student.getEmail()%>"><br>
    Student age: <input type="number" name="studentAge" value="<%=student.getAge()%>"><br>
    Student picture: <input type="file" name="studentPicName" value="<%=student.getPicName()%>"><br>
    <select name="lessonId">
        <%
            for (Lesson lesson : lessons) {%>
        <option value="<%=lesson.getId()%>"><%=lesson.getName()%>
        </option>
        <%}%>
    </select>
    <input type="submit" value="Update">
</form>
</body>
</html>
