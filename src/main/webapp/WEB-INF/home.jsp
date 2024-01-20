<%@ page import="com.example.studentlessonservlet.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Hakob
  Date: 20.01.2024
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<% if (session.getAttribute("user") != null) {
    User user = (User) session.getAttribute("user");
%>
Welcome <%=user.getName() + " " + user.getSurname()%>  !!!<br>
<a href="/logout">Logout</a>
<%
    }
%>
<div style="margin: 0 auto">
    <a href="/lessons">View All Lessons</a><br>
    <a href="/students">View All Students</a>
</div>

</body>
</html>
