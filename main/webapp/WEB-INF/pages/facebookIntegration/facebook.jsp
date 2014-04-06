<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: jeffreyb08
  Date: 4/6/14
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    This is where you would integrate with facebook.<br>
    <a href="/profile">Go Back</a>
    <br>
    <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
</body>
</html>