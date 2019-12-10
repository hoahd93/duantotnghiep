<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" /></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        
        
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

        <!-- Latest compiled and minified CSS -->
        <link href="<c:url value="/customer/css/jquery-ui.min.css"/>" rel="stylesheet"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.js"></script>
        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <!-- Stylesheets -->
        <link href="<c:url value="/customer/css/font-awesome.min.css"/>" rel="stylesheet"/>

        <link href="<c:url value="/customer/css/flaticon.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/customer/css/slicknav.min.css"/>" rel="stylesheet"/>

        <link href="<c:url value="/customer/css/owl.carousel.min.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/customer/css/animate.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/customer/css/style.css"/>" rel="stylesheet"/>

        <style>
            #validation label {float:left;width:100%;}
            .error {color:#F00;}
        </style>
    </head>
    <body>
        <tiles:insertAttribute name="header" />  
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />

        <tiles:insertAttribute name="footer" />  
        <script src="<c:url value="/customer/js/jquery-3.2.1.min.js"/>"></script>

        <script src="<c:url value="/customer/js/jquery.slicknav.min.js"/>"></script>
        <script src="<c:url value="/customer/js/owl.carousel.min.js"/>"></script>
        <script src="<c:url value="/customer/js/jquery.nicescroll.min.js"/>"></script>
        <script src="<c:url value="/customer/js/jquery.zoom.min.js"/>"></script>
        <script src="<c:url value="/customer/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/customer/js/main.js"/>"></script>
    </body>
</html>
