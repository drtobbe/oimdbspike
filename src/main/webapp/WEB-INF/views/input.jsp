<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="/css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="/css/main.css">

        <script src="/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->

        <!-- This code is taken from http://twitter.github.com/bootstrap/examples/hero.html -->

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Near Earth Objects (are closer than they appear)</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li class="nav-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form pull-right">
                            <input class="span2" type="text" placeholder="Email">
                            <input class="span2" type="password" placeholder="Password">
                            <button type="submit" class="btn">Sign in</button>
                        </form>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container">

           <form method="POST" action="addobservation">
           <p>Observation</p>

               <div class="well">
                   <p>Common Name</p>
                   <input id="name" name="name" type="text"/>

                   <p>Lat</p>
                   <input id="lat" name="lat" type="text"/>
                   <p>Long</p>
                   <input id="lng" name="lng" type="text"/>

                   <p>Altitude</p>
                   <input id="altitude" name="altitude" type="text"/>

                   <p>Direction</p>
                   <input id="direction" name="direction" type="text"/>

                   <p>ViewAngle</p>
                   <input id="angle" name="angle" type="text"/>

                   <div id="earth_div" style="width:600px;height:400px;border:1px solid gray; padding:2px;">

               </div>




               <input type="submit">
           </form>

            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


            <table class="table">
                <c:forEach items="${observations}" var="observation">
                    <tr>
                        <td>${observation.id}</td>
                        <td>${observation.lattitude}</td>
                        <td>${observation.longitude}</td>
                        <td>${observation.altitude}</td>
                        <td>${observation.direction}</td>
                        <td>${observation.viewAngle}</td>
                        <td>${observation.dateOfObservation}</td>
                        <td><a href="">Add Sighting</a></td>
                    </tr>
                </c:forEach>
            </table>
            <hr>

            <footer>
                <p>&copy; Company 2013</p>
            </footer>

        </div> <!-- /container -->

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.8.0.min.js"><\/script>')</script>

        <script src="/js/vendor/bootstrap.min.js"></script>

        <script src="/js/main.js"></script>
        <script src="http://www.webglearth.com/api.js"></script>
        <script>
            function initialize() {
                var options = { zoom: 3.0, position: [47.19537,8.524404] };
                var earth = new WebGLEarth('earth_div', options);
            }
        </script>

        <script>
            window.onload=function(){initialize();};
        </script>

    </body>
</html>