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
                        <form:input path="lastName" id="lastName" />
                    </fieldset>
                    <fieldset>
                        <label for="username">Username<span>*</span></label><br>
                        <form:errors path="username" cssClass="errorTheme" />
                        <form:input path="username" id="username" />
                    </fieldset>
                    <input type="submit" id="signup" value="Save" />
                </fieldset>
            </form:form>
        </div>
        <a href="javascript:testFacebook()">Integrate With Facebook</a>
        <div id="fb-root"></div>
        <script>
            window.fbAsyncInit = function() {
                FB.init({
                    appId      : '536303036482123',
                    status     : true,
                    xfbml      : true
                });
            };

            (function(d, s, id){
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {return;}
                js = d.createElement(s); js.id = id;
                js.src = "//connect.facebook.net/en_US/all.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));

            function testFacebook(){
                FB.login(function(response) {
                            if (response.authResponse) {
                                FB.api(
                                    "/me/albums",
                                    function (albumResponse) {
                                        if (albumResponse && albumResponse.error != undefined) {
                                            /* handle the result */
                                            alert('error');
                                        }else{
                                            if(albumResponse != null && albumResponse != undefined && albumResponse.data != null && albumResponse.data != undefined &&
                                                    albumResponse.data.length != null && albumResponse.data.length != undefined && albumResponse.data.length > 0){
                                                for(var i = 0; i < albumResponse.data.length; i++){
                                                    var temp = albumResponse.data[i];
                                                    if(temp.type == 'profile'){
                                                        var albumId = temp.id;
                                                        var fql = "SELECT src_big FROM photo WHERE album_object_id='"+albumId+"'";
                                                        FB.api({
                                                                    method: 'fql.query',
                                                                    query: fql
                                                                },
                                                                function(fqlResponse){
                                                                    if (fqlResponse.error != undefined) {
                                                                        alert('error in fql');
                                                                    } else {
                                                                        if(fqlResponse != null && fqlResponse != undefined && fqlResponse.length != null && fqlResponse != undefined &&
                                                                                fqlResponse.length > 0){
                                                                            $.ajax({
                                                                                type: "GET",
                                                                                url: "/saveFacebookProfilePhotos",
                                                                                data : "fqlResponse=" + JSON.stringify(fqlResponse),
                                                                                success : function(response) {
                                                                                    window.location = "/chooseFacebookPhotos";
                                                                                },
                                                                                error : function(e) {
                                                                                    alert('Error: ' + e);
                                                                                }
                                                                            });
                                                                        }else{
                                                                            alert('no photos in the album');
                                                                        }
                                                                    }
                                                                }
                                                        );
                                                    }
                                                }
                                            }else{
                                                alert('Either no albums to show, or error getting albums');
                                            }
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
            }
            function tester2(fqlResponse){

            }
        </script>
    </div>
</div>
<!----end-content--->
<!----start-content--->
