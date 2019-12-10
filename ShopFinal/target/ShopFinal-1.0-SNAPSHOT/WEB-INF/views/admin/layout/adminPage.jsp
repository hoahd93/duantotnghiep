<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" /></title>

        <!-- Bootstrap CSS-->
        <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"/>
        <!-- Font Awesome CSS-->
        <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/>
        <!-- Fontastic Custom icon font-->

        <!-- Google fonts - Poppins -->
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
        <!-- theme stylesheet-->
        <link href="<c:url value="/resources/css/style.default.css"/>" rel="stylesheet"/>
        <!-- Custom stylesheet - for your changes-->
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet"/>
        <script src="<c:url value="/resources/vendor/popper.js/umd/popper.min.js"/>"></script>
        <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/paging/jquery.twbsPagination.js"/>"></script>
        <script src="<c:url value="/resources/paging/jquery.twbsPagination.min.js"/>"></script>
        <style type="text/css">
            label {
                display: inline-block;

            }
            input[type="text"], input[type="password"] {
                display: inline-block;

            }
            label.error {
                display: inline-block;
                color:red;

            }
        </style>
    </head>
    <body>
        <div class="page">
            <tiles:insertAttribute name="header" />            
            <div class="page-content d-flex align-items-stretch">
                <tiles:insertAttribute name="menu" />
                <div class="content-inner">
                    <header class="page-header">
                        <div class="container-fluid">
                            <h2 class="no-margin-bottom">
                                <tiles:getAsString name="namelink" />
                            </h2>
                        </div>
                    </header>
                    <tiles:insertAttribute name="body" />
                    <hr>
                    <tiles:insertAttribute name="footer" />
                </div>
            </div>             


        </div>

        <!-- JavaScript files-->
<!--        <script src="<c:url value="/resources/paging/page.js"/>"></script>-->
        <script src="<c:url value="/resources/js/app.js"/>"></script>
        <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/vendor/jquery.cookie/jquery.cookie.js"/>"></script>
        <script src="<c:url value="/resources/vendor/chart.js/Chart.min.js"/>"></script>
        <script src="<c:url value="/resources/vendor/jquery-validation/jquery.validate.min.js"/>"></script>
        <script src="<c:url value="/resources/js/charts-home.js"/>"></script>
        <!-- Main File-->
        <script src="<c:url value="/resources/js/front.js"/>"></script>
    </body>
</html>
