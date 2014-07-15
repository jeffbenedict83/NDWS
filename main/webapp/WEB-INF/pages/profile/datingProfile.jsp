<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="horizontalAlignContentDatingProfile">
        <div class="signupFormLogin">
            <div class="userDatingProfileInformation">
                <form:form id="signupForm" modelAttribute="userDatingProfile" action="/addOrUpdateUserDatingProfile" method="POST">
                    <span class="signupBlue">Profile Information:</span>
                    <fieldset id="signupbody">
                        <fieldset>
                            <label for="gender">My Gender<span>*</span></label><br>
                            <form:errors path="gender" cssClass="errorTheme" />
                            <form:select path="gender" id="gender" items="${myGender}" />
                        </fieldset>
                        <fieldset>
                            <label for="genderInterest">Gender Interest<span>*</span></label><br>
                            <form:errors path="genderInterest" cssClass="errorTheme" />
                            <form:select path="genderInterest" id="genderInterest" items="${genderInterest}" />
                        </fieldset>
                        <fieldset>
                            <label for="age">My Age<span>*</span></label><br>
                            <form:errors path="age" cssClass="errorTheme" />
                            <form:select path="age" id="age" items="${age}" />
                        </fieldset>
                        <fieldset>
                            <label for="ageInterest">Age Interest<span>*</span></label><br>
                            <form:errors path="ageInterest" cssClass="errorTheme" />
                            <form:select path="ageInterest" id="ageInterest" items="${ageInterest}" />
                        </fieldset>
                        <fieldset>
                            <label for="shortDescription">Short Description About You<span>*</span></label><br>
                            <form:errors path="shortDescription" cssClass="errorTheme" />
                            <form:input path="shortDescription" id="shortDescription" />
                        </fieldset>
                        <input type="submit" id="signup" value="Save" />
                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
    <script>

    </script>
</div>
</div>
<!----end-content--->
<!----start-content--->
