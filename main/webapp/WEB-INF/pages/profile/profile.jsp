<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="horizontalAlignContent">
        <div class="userProfileInformation">
            <form:form id="signupForm" modelAttribute="userProfile" action="/addOrUpdateUserProfile" method="POST">
                <span class="signupBlue">Profile Information:</span>
                <fieldset id="signupbody">
                    <fieldset>
                        <label for="firstName">First Name<span>*</span></label><br>
                        <form:errors path="firstName" cssClass="errorTheme" />
                        <form:input path="firstName" id="firstName" />
                    </fieldset>
                    <fieldset>
                        <label for="lastName">Last Name<span>*</span></label><br>
                        <form:errors path="lastName" cssClass="errorTheme" />
                        <form:input path="lastName" id="firstName" />
                    </fieldset>
                    <input type="submit" id="signup" value="Save" />
                </fieldset>
            </form:form>
        </div>
    </div>
    <%--    <script type="text/javascript">
            $(document).ready(function(){
                document.f.j_username.focus();
            });
        </script>--%>
</div>
<!----end-content--->
<%--
<!----start-content--->
<div class="content">
    this is where you can update your profile<br>
    <a href="/facebookIntegration">Integrate with facebook</a>
    <br>
    <a href="/landing">Go Back</a>
</div>
&lt;%&ndash;end-content&ndash;%&gt;--%>
