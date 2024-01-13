<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet.model.Lesson" %>
<%@ page import="com.example.studentlessonservlet.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Hakob
  Date: 13.01.2024
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<% List<Student> students = (List<Student>) request.getAttribute("students"); %>

<a href="/addStudent">Add Student</a>
<table border="1">
    <tr>
        <th>
            ID
        </th>
        <th>
            Name
        </th>
        <th>
            Surname
        </th>
        <th>
            Email
        </th>
        <th>
            Age
        </th>
        <th>
        Lesson
        </th>
        <th>
            Delete
        </th>
    </tr>
    <%
        if (students != null && !students.isEmpty()) {
            for (Student student : students) { %>
    <tr>
        <td><%=student.getId()%>
        </td>
        <td><%=student.getName()%>
        </td>
        <td><%=student.getSurname()%>
        </td>
        <td><%=student.getEmail()%>
        </td>
        <td><%=student.getAge()%>
        </td>
        <td><%=student.getLesson()%>
        </td>
        <td><a href="/deleteStudent?id=<%=student.getId()%>">delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>