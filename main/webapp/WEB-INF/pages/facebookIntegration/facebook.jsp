<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="horizontalAlignContent">
        <div class="userProfileInformation">
            <form:form id="signupForm" modelAttribute="userFacebook" action="/addOrUpdateFacebookAccount" method="POST">
                <span class="signupBlue">Facebook Account Infromation:</span>
                <fieldset id="signupbody">
                    <fieldset>
                        <label for="facebookUsername">Facebook Username<span>*</span></label><br>
                        <form:errors path="facebookUsername" cssClass="errorTheme" />
                        <form:input path="facebookUsername" id="facebookUsername" />
                    </fieldset>
                    <fieldset>
                        <label for="facebookPassword">Facebook Password<span>*</span></label><br>
                        <form:errors path="facebookPassword" cssClass="errorTheme" />
                        <form:password path="facebookPassword" id="facebookPassword" />
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
<!----start-content--->