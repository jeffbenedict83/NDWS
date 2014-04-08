<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="top-nav">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Features</a></li>
    </ul>
</div>
<div class="sign-ligin-btns">
    <ul>
        <li id="loginContainer"><a class="login" id="loginButton" href="<c:url value="/j_spring_security_logout" />"><span><i>Logout</i></span></a></li>
    </ul>
</div>
<div class="clear"> </div>