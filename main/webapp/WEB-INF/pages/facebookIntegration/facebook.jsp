<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="fb-root"></div>
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '536303036482123',
            status     : true,
            xfbml      : true
        });
        FB.login(function(response) {
                if (response.authResponse) {
                    FB.api(
                            "/me/albums",
                            function (albumResponse) {
                                if (albumResponse && albumResponse.error != undefined) {
                                    /* handle the result */
                                    alert('error');
                                }else{
                                    alert(albumResponse);
                                    //var jsonObject = eval('(' + response + ')');
                                    //alert(jsonObject);
                                    //var data = jsonObject.data;
                                    //alert(data);
                                }
                            }
                    );

                    // The person logged into your app
                } else {
                    // The person cancelled the login dialog
                }
            },
            {scope: 'user_photos'}
        );


    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/all.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>
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