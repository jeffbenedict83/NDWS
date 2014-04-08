<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Formerly LDS Singles</title>
    <link href="<c:url value="/resources/mytheme/css/style.css" />" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="/resources/mytheme/images/fav-icon.png" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <%--strat-slider--%>
    <script src="<c:url value="/resources/mytheme/js/jquery.min.js" />"></script>
    <link href="<c:url value="/resources/mytheme/css/slider-style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/mytheme/css/ndws.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/mytheme/js/modernizr.custom.28468.js" />"></script>
    <!---//strat-slider---->
    <!---start-login-script--->
    <script src="<c:url value="/resources/mytheme/js/login.js" />"></script>
    <!---//End-login-script--->
    <!-----768px-menu----->
    <link href="<c:url value="/resources/mytheme/css/jquery.mmenu.all.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/mytheme/js/jquery.mmenu.js" />"></script>
    <script type="text/javascript">
        //	The menu on the left
        $(function() {
            $('nav#menu-left').mmenu();
        });
    </script>
    <c:if test="${not empty error}">
        <script type="text/javascript">
            $(function() {
                alert('Invalid Login');
            });
        </script>
    </c:if>
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
                <li><a href="#">About Features</a></li>
                <li><a href="/login">Login</a></li>
                <li><a href="#">Sign Up</a></li>
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
            <h3>Newsletter</h3>
            <p>Subscribe to our newsletter to keep up-to-date with all the latest news.</p>
            <form>
                <input type="text" class="text" value="Your Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Name';}">
                <input type="text" class="text" value="Your Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Email';}">
                <input type="submit" value="subscribe" />
            </form>
        </div>
        <div class="clear"> </div>
    </div>
</div>
<!---//End-bottom-footer-grids---->
</body>
</html>

