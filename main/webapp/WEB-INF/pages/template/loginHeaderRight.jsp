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
        <li id="signupContainer"><a class="signup" id="signupButton" href="#"><span><i>Signup</i></span></a>
            <div class="clear"> </div>
            <div id="signupBox">
                <form id="signupForm" action="<c:url value='/addNewUser' /> " method="POST">
                    <fieldset id="signupbody">
                        <fieldset>
                            <label for="signupemail">Username<span>*</span></label>
                            <input type="text" name="username" id="signupemail" />
                        </fieldset>
                        <fieldset>
                            <label for="signuppassword">Choose Password <span>*</span></label>
                            <input type="password" name="password" id="signuppassword" />
                        </fieldset>
                        <fieldset>
                            <label for="signuppassword1">Confirm Password <span>*</span></label>
                            <input type="password" name="confirmPassword" id="signuppassword1" />
                        </fieldset>
                        <input type="submit" id="signup" value="Register Now!" />
                    </fieldset>
                </form>
            </div>
            <!-- Login Ends Here -->
        </li>
        <li id="loginContainer"><a class="login" id="loginButton" href="#"><span><i>Login</i></span></a>
            <div class="clear"> </div>
            <div id="loginBox">
                <form id="loginForm" action="<c:url value='/j_spring_security_check' />" method='POST'>
                    <fieldset id="body">
                        <fieldset>
                            <label for="j_username">Username</label>
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
            <!-- Login Ends Here -->
        </li>
        <div class="clear"> </div>
    </ul>
</div>
<div class="clear"> </div>