<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!----start-banner---->
<div class="text-slider">
    <div class="wrap">
        <!---start-da-slider----->
        <div id="da-slider" class="da-slider">
            <div class="da-slide">
                <h2>Log Your Runs</h2>
                <p> Track your Progress Compete with your Friends</p>
                <a href="about.html" class="da-link">Find out More</a>
            </div>
            <div class="da-slide">
                <h2>Log Your Runs</h2>
                <p> Track your Progress Compete with your Friends</p>
                <a href="about.html" class="da-link">Find out More</a>
            </div>
            <div class="da-slide">
                <h2>Log Your Runs</h2>
                <p> Track your Progress Compete with your Friends</p>
                <a href="about.html" class="da-link">Find out More</a>
            </div>
            <div class="da-slide">
                <h2>Log Your Runs</h2>
                <p> Track your Progress Compete with your Friends</p>
                <a href="about.html" class="da-link">Find out More</a>
            </div>
            <div class="da-slide">
                <h2>Log Your Runs</h2>
                <p> Track your Progress Compete with your Friends</p>
                <a href="about.html" class="da-link">Find out More</a>
            </div>
            <nav class="da-arrows">
                <span class="da-arrows-prev"> </span>
                <span class="da-arrows-next"> </span>
            </nav>
        </div>
        <script src="<c:url value="/resources/js/jquery.cslider.js" />"></script>
        <script type="text/javascript">
                $(function() {
                    $('#da-slider').cslider({
                        autoplay	: true,
                        bgincrement	: 450
                    });

                });
        </script>
    </div>
</div>
<!---//End-da-slider----->
<!----//End-banner---->
<!----start-content--->
<div class="content">
    <div class="wrap">
        <!--- start-top-grids---->
        <div class="top-grids">
            <div class="top-grid">
                <div class="product-pic frist-product-pic">
                    <img src="/resources/images/watch-img.png" title="watch" />
                </div>
                <span><label>1</label></span>
                <div class="border"> </div>
                <a href="#">Sign Up</a>
            </div>
            <div class="top-grid">
                <div class="product-pic">
                    <img src="/resources/images/shoe-img.png" title="shoe" />
                </div>
                <span><label>2</label></span>
                <div class="border hide"> </div>
                <a href="#">Setup Preferences</a>
            </div>
            <div class="top-grid hide">
                <div class="product-pic">
                    <img src="/resources/images/lap-img.png" title="laptop" />
                </div>
                <span><label>3</label></span>
                <a href="#">Start The Hunt</a>
            </div>
            <div class="clear"> </div>
        </div>
    </div>
    <!--- start-top-grids---->
    <!---start-mid-grids--->
    <%--<div class="mid-grids">
        <div class="wrap">
            <div class="mid-grids-left">
                <img src="/resources/images/app-divices.jpg" title="divices" />
                <span> </span>
            </div>
            <div class="mid-grids-right">
                <h3> Get <span>Runkeeper</span> for your mobile</h3>
                <p>The Runkeeper app is available for both i<big>OS</big> and <big>Android</big> devices.</p>
                <ul class="fea">
                    <li><a href="#"><i>Log</i> your runs</a></li>
                    <li><a href="#"><i>Track</i> your Progress </a></li>
                    <li><a href="#">Get a <i>Virtual trainer</i></a></li>
                    <li><a href="#"><i>Complete</i> with your friends </a></li>
                    <li><a href="#"><i>Share</i> your routes</a></li>
                </ul>
                <div class="big-btns">
                    <ul>
                        <li><a class="and" href="#"> </a></li>
                        <li><a class="iphone" href="#"> </a></li>
                        <div class="clear"> </div>
                    </ul>
                </div>
            </div>
            <div class="clear"> </div>
        </div>
    </div>--%>
    <!---//End-mid-grids--->
</div>
<!----//End-content--->
