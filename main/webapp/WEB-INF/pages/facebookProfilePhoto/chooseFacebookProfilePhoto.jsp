<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="fbppTotalContainer">
        <div id="profilePhotos"></div>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        $.ajax({
            type: "GET",
            url: "/getSavedFacebookProfilePhotos",
            success : function(response) {
                if(response != null && response != undefined){
                    var innerHtml = "Error loading your profile pictures";
                    var json = JSON.parse(response);
                    if(json != null && json != undefined && json.userFacebookProfilePhotos != null && json.userFacebookProfilePhotos != undefined &&
                            json.userFacebookProfilePhotos.length != null && json.userFacebookProfilePhotos.length != undefined &&
                            json.userFacebookProfilePhotos.length > 0){
                        innerHtml = "";
                        for(var i = 0; i < json.userFacebookProfilePhotos.length; i++){
                            innerHtml += "<div class='fbppContainer inlineBlock'><img src='"+json.userFacebookProfilePhotos[i].facebookProfilePhotoPath+"' id='"+json.userFacebookProfilePhotos[i].id+"' /></div>";
                        }
                        $('#profilePhotos').html(innerHtml);
                    }else{
                        alert('error');
                    }
                }
            },
            error : function(e) {
                $('#profilePhotos').html("Error: " + e);
            }
        });
    });
</script>