<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    this is where you can update your profile<br>
    <a href="/facebookIntegration">Integrate with facebook</a>
    <br>
    <a href="/landing">Go Back</a>
    <br>
    <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
</body>
</html>