<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Formerly LDS Singles</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/fav-icon.png" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <%--strat-slider--%>
    <%--<script src="<c:url value="/resources/js/jquery.min.js" />"></script>--%>
    <link href="<c:url value="/resources/css/slider-style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/ndws.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/modernizr.custom.28468.js" />"></script>
    <!---//strat-slider---->
    <!---start-login-script--->
    <!---//End-login-script--->
    <!-----768px-menu----->
    <link rel="stylesheet" href="/resources/css/jquery-ui.css">
    <script src="/resources/js/jquery-1.10.2.js"></script>
    <script src="/resources/js/jquery-ui.js"></script>



    <script src="<c:url value="/resources/js/login.js" />"></script>
    <link href="<c:url value="/resources/css/jquery.mmenu.all.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.mmenu.js" />"></script>
    <script type="text/javascript">
        //	The menu on the left
        $(function() {
            $('nav#menu-left').mmenu();
        });
    </script>
    <%--<c:if test="${not empty error}">
        <script type="text/javascript">
            $(function() {
                alert('Invalid Login');
            });
        </script>
    </c:if>--%>
    <!-----//768px-menu----->
</head>
<body>
<!---start-wrap---->
<!------start-768px-menu---->
<div id="page">
    <div id="header">
        <a class="navicon" href="#menu-left"> </a>
    </div>
    <nav id="menu-left">
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Features</a></li>
            <div class="clear"> </div>
        </ul>
    </nav>
</div>
<!------start-768px-menu---->
<!---start-header---->
<div class="header">
    <div class="wrap">
        <div class="header-left">
            <div class="logo">
                <a href="#">Formerly LDS Singles</a>
            </div>
        </div>
        <div class="header-right">
            <tiles:insertAttribute name="headerRight" />
        </div>
        <div class="clear"> </div>
    </div>
</div>
<!---//End-header---->
<tiles:insertAttribute name="body" />
<!---//End-wrap---->
<!---start-bottom-footer-grids---->
<div class="footer-grids">
    <div class="wrap">
        <div class="footer-grid">
            <h3>Quick Links</h3>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="javascript:openDialog('About Title', 'Need to send some awesome html for the about dialog')">About</a></li>
                <li><a href="javascript:openDialog('Features Title', 'Need to send some awesome html for the features dialog')">Features</a></li>
                <li><a href="/loginDirect">Login</a></li>
                <li><a href="/loginDirect">Sign Up</a></li>
            </ul>
        </div>
        <div class="footer-grid">
            <h3>More</h3>
            <ul>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">Support</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Terms and Conditions</a></li>
            </ul>
        </div>
        <div class="footer-grid">
            <h3>Connect With Us</h3>
            <ul class="social-icons">
                <li><a class="facebook" href="#"> </a></li>
                <li><a class="twitter" href="#"> </a></li>
                <li><a class="youtube" href="#"> </a></li>
            </ul>
            <p class="copy-right">Template by <a href="#">W3layouts</a></p>
        </div>
        <div class="footer-grid">
            <img src="/resources/images/fLogo.png"/>
        </div>
        <div class="clear"> </div>
    </div>
</div>
<!---//End-bottom-footer-grids---->
</body>
</html>
<div id="dialog" class="myMainDialog"></div>
<script>
    var target = $(this);

    $("#dialog").dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            duration: 300
        },
        hide: {
            effect: "explode",
            duration: 300
        },
        open: function (event, ui) {
            $(".ui-widget-overlay").css({
                opacity:0.3,
                filter: "Alpha(Opacity=100)",
                backgroundColor: "black",
                zIndex: 30
            });
        },
        modal: true,
        position: ['top', 150],
        zIndex: 1000,
        draggable: false
    });

    function openDialog(dialogTitle, dialogHtml){
        if(dialogHtml == null || '' == dialogHtml){
            dialogHtml = "this worked";
        }
        var theDialog = $("#dialog");
        theDialog.dialog("option", "title", dialogTitle);
        theDialog.html(dialogHtml);
        theDialog.dialog( "open" );
    }
</script>

