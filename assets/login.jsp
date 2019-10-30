<%-- 
    Document   : login.jsp
    Created on : Oct 19, 2017, 5:01:40 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <!-- App favicon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
        <!-- App title -->
        <!--title>Hotel Management System - Customer Relationship Management</title-->
        <title>Verano (Built 04102019)</title>

        <!-- App css -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/core.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/components.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/switchery/switchery.min.css">
        
        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="${pageContext.request.contextPath}/js/modernizr.min.js"></script>
    </head>


    <body class="loginbg" style="background-image: url(${pageContext.request.contextPath}/images/loginbg.jpg)">
    <!--<body class="loginbg">-->

        <!-- Loader -->
        <div id="preloader">
            <div id="status">
                <div class="spinner">
                  <div class="spinner-wrapper">
                    <div class="rotator">
                      <div class="inner-spin"></div>
                      <div class="inner-spin"></div>
                    </div>
                  </div>
                </div>
            </div>
        </div>

        <!-- Begin page -->
        <div id="wrapper">
        </div>
        <!-- END wrapper -->
        <script>
            var resizefunc = [];
        </script>

        <!-- jQuery  -->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/detect.js"></script>
        <script src="${pageContext.request.contextPath}/js/fastclick.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.blockUI.js"></script>
        <script src="${pageContext.request.contextPath}/js/waves.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.slimscroll.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.scrollTo.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/switchery/switchery.min.js"></script>
        
        <!-- App js -->
        <script src="${pageContext.request.contextPath}/js/jquery.core.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.app.js"></script>
        
        <%@ include file="/WEB-INF/jspf/login.jspf"%>
        
        <script src="${pageContext.request.contextPath}/pages/@cmlogin@"></script>
    </body>
</html>
