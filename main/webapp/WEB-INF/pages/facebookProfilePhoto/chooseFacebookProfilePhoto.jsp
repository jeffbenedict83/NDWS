<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="fbppTotalContainer">
        <div class="buttonMaxTwoHundred"><input id="backToProfile" type="button" class="blueButton" value="Back to profile" /></div>
        <div id="profilePhotosEnabled"></div>
        <div id="profilePhotosDisabled"></div>
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
                    var innerHtmlEnabled = "<span class=\"headerTextEnabledProfilePictures\">These photos will be visible:</span>";
                    var innerHtmlDisabled = "<span class=\"headerTextDisabledProfilePictures\">These photos will NOT be visible:</span>";
                    var json = JSON.parse(response);
                    if(json != null && json != undefined && json.userFacebookProfilePhotos != null && json.userFacebookProfilePhotos != undefined &&
                            json.userFacebookProfilePhotos.length != null && json.userFacebookProfilePhotos.length != undefined &&
                            json.userFacebookProfilePhotos.length > 0){
                        innerHtmlEnabled += "<ul id=\"sortable\" class=\"inlineBlock connectedSortable\">";
                        innerHtmlDisabled += "<ul id=\"sortable2\" class=\"inlineBlock connectedSortable\">";
                        var totalCount = 0;
                        for(var i = 0; i < json.userFacebookProfilePhotos.length; i++){
                            var whichInnerHtml = "enabled";
                            var tempInnerHtml = "";

                            tempInnerHtml += '<li class=\"sortableLI\" style=\"float:left\" id=\"'+"sortableImage"+json.userFacebookProfilePhotos[i].id+'\">';
                            totalCount++;
                            tempInnerHtml += "<div class='fbppContainer inlineBlock hideContainer'><img src='"+json.userFacebookProfilePhotos[i].facebookProfilePhotoPath+"' id='"+json.userFacebookProfilePhotos[i].id+"' />";
                                tempInnerHtml += '<span id="radio'+i+'" class="inlineBlock">';
                                if(json.userFacebookProfilePhotos[i].visibility == 0){
                                    whichInnerHtml = "disabled";
                                }else{
                                    whichInnerHtml = "enabled";
                                }
                            tempInnerHtml += "</div>";
                            tempInnerHtml += "</li>";
                            if(whichInnerHtml == "enabled"){
                                innerHtmlEnabled += tempInnerHtml;
                            }else{
                                innerHtmlDisabled += tempInnerHtml;
                            }
                        }
                        innerHtmlEnabled += "</ul>";
                        innerHtmlDisabled += "</ul>";
                        var profilePhotosEnabledDiv = $('#profilePhotosEnabled');
                        profilePhotosEnabledDiv.html(innerHtmlEnabled);
                        var profilePhotosDisabledDiv = $('#profilePhotosDisabled');
                        profilePhotosDisabledDiv.html(innerHtmlDisabled);

                        $( "#sortable, #sortable2" ).sortable({
                            connectWith: ".connectedSortable",
                            update: function(event, ui){
                                var sortable = $("#sortable");
                                var sortable2 = $("#sortable2");
                                updateOrdering('1', sortable.sortable("toArray"));
                                updateOrdering('0', sortable2.sortable("toArray"));

                            }
                        }).disableSelection();

                        var images = profilePhotosEnabledDiv.find('img');
                        if(images != null && images != undefined && images.length != null && images.length != undefined && images.length > 0){
                            for(var i = 0; i < images.length; i++){
                                if(images[i].clientWidth >= images[i].clientHeight){
                                    images[i].className = 'fbppImageHeightGreaterThanWidth';
                                }else if(images[i].clientWidth < images[i].clientHeight){
                                    images[i].className = 'fbppImageHeightLessThanWidth';
                                }
                            }
                        }

                        var images = profilePhotosDisabledDiv.find('img');
                        if(images != null && images != undefined && images.length != null && images.length != undefined && images.length > 0){
                            for(var i = 0; i < images.length; i++){
                                if(images[i].clientWidth >= images[i].clientHeight){
                                    images[i].className = 'fbppImageHeightGreaterThanWidth';
                                }else if(images[i].clientWidth < images[i].clientHeight){
                                    images[i].className = 'fbppImageHeightLessThanWidth';
                                }
                            }
                        }

                        var divsSurroundingImages = profilePhotosEnabledDiv.find('div');
                        if(divsSurroundingImages != null && divsSurroundingImages != undefined && divsSurroundingImages.length != null
                                && divsSurroundingImages.length != undefined && divsSurroundingImages.length > 0){
                            for(var i = 0; i < divsSurroundingImages.length; i++){
                                divsSurroundingImages[i].className = 'fbppContainer inlineBlock showContainer';
                            }
                        }

                        var divsSurroundingImages = profilePhotosDisabledDiv.find('div');
                        if(divsSurroundingImages != null && divsSurroundingImages != undefined && divsSurroundingImages.length != null
                                && divsSurroundingImages.length != undefined && divsSurroundingImages.length > 0){
                            for(var i = 0; i < divsSurroundingImages.length; i++){
                                divsSurroundingImages[i].className = 'fbppContainer inlineBlock showContainer';
                            }
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

    function updateOrdering(enabled, sortableArray){
        var finishedJSON = '';
        finishedJSON += "{";
            finishedJSON += "\"enabled\":\""+enabled+"\",";
                finishedJSON += "\"items\":[";
                for(var i = 0; i < sortableArray.length; i++){
                    finishedJSON += "{";
                    finishedJSON += "\"id\":\""+sortableArray[i].substr(13)+"\"";
                    finishedJSON += "}";
                    if(i != sortableArray.length-1){
                        finishedJSON += ",";
                    }
                }
                finishedJSON += "]";
        finishedJSON += "}";

        $.ajax({
            url: "/updatePhotoVisibilityJSON",
            type: "POST",
            dataType: "json",
            data: JSON.stringify({ finishedJSON: finishedJSON }),
            contentType: "application/json",
            mimeType: 'application/json',
            success: function(response) {
                /*alert("asdf");
                alert(response);*/
            },
            error : function(e) {
                alert('error saving photo visibility');
            }
        });

    }

    function updatePhotoVisibility(id, visibility){
        $.ajax({
            type: "GET",
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

<%--
<style>
    #sortable { list-style-type: none; margin: 0; padding: 0; width: 450px; }
    #sortable li { margin: 3px 3px 3px 0; padding: 1px; float: left; width: 100px; height: 90px; font-size: 4em; text-align: center; }
</style>
<script>
    $(function() {
        $( "#sortable" ).sortable();
        $( "#sortable" ).disableSelection();
    });
</script>
<ul id="sortable">
    <li class="ui-state-default">1</li>
    <li class="ui-state-default">2</li>
    <li class="ui-state-default">3</li>
    <li class="ui-state-default">4</li>
    <li class="ui-state-default">5</li>
    <li class="ui-state-default">6</li>
    <li class="ui-state-default">7</li>
    <li class="ui-state-default">8</li>
    <li class="ui-state-default">9</li>
    <li class="ui-state-default">10</li>
    <li class="ui-state-default">11</li>
    <li class="ui-state-default">12</li>
</ul>--%>
