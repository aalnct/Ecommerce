<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Music Store</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

	<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
	
	<%-- <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"> --%>
    <!-- Custom styles for this template -->
    
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Music Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class=""><a href="<c:url value="/"/>">Home</a></li>
                        <li class = ""><a href="<c:url value="/productList"/>">Products</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                    
                    <ul class = "nav navbar-nav pull-right">
                    		<li>
                    			<a href = "<c:url value = "/admin"/>">Admin</a>
                    		</li>
                    		
                    		<li>
                    			<a href = "<c:url value = "/register"/>">Register</a>
                    		</li>
                    
                    </ul>
                    
                </div>
            </div>
        </nav>

    </div>
</div>

</body>
</html>