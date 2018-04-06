<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Coffee shop</title>

    <!-- Bootstrap Core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="/static/css/myapp.css" rel="stylesheet"/>


</head>

<body>

<div class="wrapper">

    <!-- Navigation -->
    <%@ include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    <div class="content">

        <!-- HomePage -->
        <c:if test="${userClickHome==true}">
            <%@include file="home.jsp" %>
        </c:if>

        <!-- Load only when user clickes about -->
        <c:if test="${userClickAbout==true}">
            <%@include file="about.jsp" %>
        </c:if>

        <!-- Load only when user clickes contact-->
        <c:if test="${userClickContact==true}">
            <%@include file="contact.jsp" %>
        </c:if>

        <!-- Load only when user clickes showCart-->
        <c:if test="${userClickShowCart==true}">
            <%@include file="cart.jsp" %>
        </c:if>

        <!-- Load only when user clickes showCart-->
        <c:if test="${userClickCheckOut==true}">
            <%@include file="checkout.jsp" %>
        </c:if>

        <!-- Load only when user clickes confirm-->
        <c:if test="${confirmOrder==true}">
            <%@include file="confirm.jsp" %>
        </c:if>

        <!-- Load only when admin clickes manage-->
        <c:if test="${showManagePage==true}">
            <%@include file="manage.jsp" %>
        </c:if>

        <!-- /.container -->
    </div>


    <%@include file="./shared/footer.jsp" %>
    <!-- /.container -->


    <!-- jQuery -->
    <script src="/static/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/static/js/bootstrap.min.js"></script>

</div>


</body>

</html>
