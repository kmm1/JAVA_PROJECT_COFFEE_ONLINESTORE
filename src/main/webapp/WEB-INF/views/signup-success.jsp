<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--its neaded for spring security. without it ajax (our deactivation item does not work)--%>

    <title>Online shopping </title>


    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/css/myapp.css" rel="stylesheet"/>

</head>

<body>

<div class="wrapper">

    <!-- Navigation -->
    <%@ include file="./shared/navbar2.jsp" %>


    <!-- Page Content -->
    <div class="content">
        <div class="container">

            <div class="row">
                <!--Column to display personal Details -->
                <div class="col-sm-offset-4 col-sm-4">
                    <div class="text-center">
                        <h1>Welcome!</h1>
                        <h3>Onlineshooping.com</h3>
                        <div>
                            <a href="${pageContext.request.contextPath}/login" class="btn btn-success">Login
                                Here</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- /.container -->


    <%@include file="./shared/footer.jsp" %>
    <!-- /.container -->


    <!-- jQuery -->
    <script src="/static/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/static/js/bootstrap.min.js"></script>


</div>
</body>

</html>