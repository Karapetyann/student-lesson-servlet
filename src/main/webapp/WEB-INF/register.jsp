<%--
  Created by IntelliJ IDEA.
  User: Hakob
  Date: 20.01.2024
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<%if (session.getAttribute("msg") != null) {%>
<span style="color: red"><%=session.getAttribute("msg")%></span>
<%session.removeAttribute("msg"); %>
<%}%>

<h2>Please enter your personal information</h2>
<br>
<form action="/register" method="post">
    name: <input type="text" name="name"/> <br>
    surname: <input type="text" name="surname"/> <br>
    email: <input type="text" name="email"/> <br>
    password: <input type="password" name="password"> <br>
    <input type="submit" value="register">
</form>
</body>
</html>
