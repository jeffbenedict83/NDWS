<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!----start-content--->
<div class="content" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="horizontalAlignContentLogin">
        <div class="signupFormLogin">
            <form:form id="signupForm" modelAttribute="user" action="/addUser" method="POST">
                <span class="signupBlue">Signup:</span>
                <fieldset id="signupbody">
                    <fieldset>
                        <label for="signupemail">Email Address<span>*</span></label><br>
                        <form:errors path="emailAddress" cssClass="errorTheme" />
                        <form:input path="emailAddress" id="signupemail" />
                    </fieldset>
                    <fieldset>
                        <label for="signuppassword">Choose Password <span>*</span></label><br>
                        <form:errors path="password" cssClass="errorTheme" />
                        <form:password path="password" id="signuppassword" />
                    </fieldset>
                    <fieldset>
                        <label for="signuppassword1">Confirm Password <span>*</span></label><br>
                        <form:errors path="confirmPassword" cssClass="errorTheme" />
                        <form:password path="confirmPassword" id="signuppassword1" />
                    </fieldset>
                    <input type="submit" id="signup" value="Register Now!" />
                </fieldset>
            </form:form>
        </div>
        <div class="loginSpacer"></div>
        <div class="loginFormLogin">
            <form id="loginForm" action="<c:url value='/j_spring_security_check' />" method='POST'>
                <span class="loginPink">Login:</span>
                <fieldset id="body">
                    <fieldset>
                        <label for="j_username">Username</label>
                        <c:if test="${not empty error}">
                            <br>
                            <span class="errorTheme">${error}</span>
                        </c:if>
                        <input type="text" name="j_username" id="j_username" />
                    </fieldset>
                    <fieldset>
                        <label for="j_password">Password</label>
                        <input type="password" name="j_password" id="j_password" />
                    </fieldset>
                    <%--<label class="remeber" for="checkbox"><input type="checkbox" id="checkbox" />Remember me</label>--%>
                    <input type="submit" id="login" value="login" />
                </fieldset>
                <span><a href="#">Forgot your password?</a></span>
            </form>
        </div>
    </div>
<%--    <script type="text/javascript">
        $(document).ready(function(){
            document.f.j_username.focus();
        });
    </script>--%>
</div>
<!----end-content--->