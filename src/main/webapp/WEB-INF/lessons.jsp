<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet.model.Lesson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons</title>
</head>
<body>
<% List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons"); %>

<a href="/addLesson">Add Lesson</a>
<table border="1">
    <tr>
        <th>
            ID
        </th>
        <th>
            Picture
        </th>
        <th>
            Name
        </th>
        <th>
            Duration
        </th>
        <th>
            LecturerName
        </th>
        <th>
            Price
        </th>
        <th>
            User
        </th>
        <th>
            Delete
        </th>
        <th>
            Update
        </th>
    </tr>
    <%
        if (lessons != null && !lessons.isEmpty()) {
            for (Lesson lesson : lessons) { %>
    <tr>
        <td><%=lesson.getId()%>
        </td>
        <td><% if (lesson.getPicName() != null) { %>
            <img src="/downloadImage?imageName=<%=lesson.getPicName()%>" width="50">
            <% } else { %>
            <span>No Picture</span>
            <%}%>
        </td>
        <td><%=lesson.getName()%>
        </td>
        <td><%=lesson.getDuration()%>
        </td>
        <td><%=lesson.getLecturerName()%>
        </td>
        <td><%=lesson.getPrice()%>
        </td>
        <td><%=lesson.getUser().getName() + lesson.getUser().getSurname() %>
        </td>
        <td><a href="/deleteLesson?id=<%=lesson.getId()%>">delete</a>
        </td>
        <td><a href="/updateLesson?id=<%=lesson.getId()%>">update</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
