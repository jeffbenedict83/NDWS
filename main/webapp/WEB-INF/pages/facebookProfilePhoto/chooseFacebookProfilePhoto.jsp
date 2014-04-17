<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="fbppTotalContainer">
        <div class="buttonMaxTwoHundred"><input id="backToProfile" type="button" class="blueButton" value="Back to profile" /></div>
        <div id="profilePhotos"></div>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        $( "#backToProfile" ).click(function() {
            window.location = "/profile";
        });

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
                        var totalCount = 0;
                        for(var i = 0; i < json.userFacebookProfilePhotos.length; i++){
                            totalCount++;
                            innerHtml += "<div class='fbppContainer inlineBlock hideContainer'><img src='"+json.userFacebookProfilePhotos[i].facebookProfilePhotoPath+"' id='"+json.userFacebookProfilePhotos[i].id+"' />";
                                innerHtml += "<p class='photoControls'>";
                                    innerHtml += '<span id="radio'+i+'" class="inlineBlock">';
                                        var publicVisibilityText = '';
                                        var privateVisibilityText = '';
                                        if(json.userFacebookProfilePhotos[i].visibility == 0){
                                            privateVisibilityText = "checked=\"checked\"";
                                        }else{
                                            publicVisibilityText = "checked=\"checked\"";
                                        }
                                        innerHtml += "<input type='radio' id='radio1"+i+"' name='radioName"+i+"' "+publicVisibilityText+" onclick='updatePhotoVisibility(\""+json.userFacebookProfilePhotos[i].id+"\", \"1\")'><label for='radio1"+i+"'>Public</label>";
                                        innerHtml += "<input type='radio' id='radio2"+i+"' name='radioName"+i+"' "+privateVisibilityText+" onclick='updatePhotoVisibility(\""+json.userFacebookProfilePhotos[i].id+"\", \"0\")'><label for='radio2"+i+"'>Private</label>";
                                    innerHtml += '</span>';
                                innerHtml += "</p>";
                            innerHtml += "</div>";
                        }
                        var profilePhotosDiv = $('#profilePhotos');
                        profilePhotosDiv.html(innerHtml);

                        var images = profilePhotosDiv.find('img');
                        if(images != null && images != undefined && images.length != null && images.length != undefined && images.length > 0){
                            for(var i = 0; i < images.length; i++){
                                if(images[i].clientWidth >= images[i].clientHeight){
                                    images[i].className = 'fbppImageHeightGreaterThanWidth';
                                }else if(images[i].clientWidth < images[i].clientHeight){
                                    images[i].className = 'fbppImageHeightLessThanWidth';
                                }
                            }
                        }

                        var divsSurroundingImages = profilePhotosDiv.find('div');
                        if(divsSurroundingImages != null && divsSurroundingImages != undefined && divsSurroundingImages.length != null
                                && divsSurroundingImages.length != undefined && divsSurroundingImages.length > 0){
                            for(var i = 0; i < divsSurroundingImages.length; i++){
                                divsSurroundingImages[i].className = 'fbppContainer inlineBlock showContainer';
                            }
                        }

                        for(var i = 0; i < totalCount; i++){
                            $( "#radio"+i ).buttonset();
                        }
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

    function updatePhotoVisibility(id, visibility){
        $.ajax({
            type: "POST",
            url: "/updatePhotoVisibility",
            data : "photoId=" + id + "&visibility=" + visibility,
            success : function(response) {

            },
            error : function(e) {
                alert('error saving photo visibility');
            }


        });
    }
</script>