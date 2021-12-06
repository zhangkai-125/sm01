<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 2021/11/29
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/reg">
    <input name="username"><br>
    <input name="pwd"><br>
    <input name="age"><br>
    <input type="submit" value="reg">
</form>
</body>
</html>
