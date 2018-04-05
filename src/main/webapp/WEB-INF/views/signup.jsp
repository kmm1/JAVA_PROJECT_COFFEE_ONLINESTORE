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

    <title>Online shopping</title>

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

                <c:if test="${not empty message}">
                    <div class="col-xs-12">
                        <div class="alert alert-success alert-dismissible " id="success-alert">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                                ${message}
                        </div>
                    </div>
                </c:if>

                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Sign up</h4>
                        </div>
                        <div class="panel-body">

                            <sf:form method="POST" modelAttribute="user"
                                     action="${pageContext.request.contextPath}/register" class="form-horizontal">

                                <div class="form-group">
                                    <label for="name" class="control-label col-md-4">Name</label>
                                    <div class="col-md-8">
                                        <sf:input type="text" path="name" id="name" class="form-control"
                                                  placeholder="name"/>
                                        <sf:errors path="name" cssClass="help-block" element="em"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="email" class="control-label col-md-4">Email</label>
                                    <div class="col-md-8">
                                        <sf:input type="text" id="email" path="email" class="form-control"
                                                  placeholder="email"/>
                                        <sf:errors path="email" cssClass="help-block" element="em"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="password" class="control-label col-md-4">Password</label>
                                    <div class="col-md-8">
                                        <sf:input type="password" path="password" id="password" class="form-control"
                                                  placeholder="password"/>
                                        <sf:errors path="password" cssClass="help-block" element="em"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="confirmPassword" class="control-label col-md-4">Confirm Password</label>
                                    <div class="col-md-8">
                                        <sf:input type="password" path="confirmPassword" id="confirmPassword"
                                                  class="form-control"/>
                                        <sf:errors path="confirmPassword" cssClass="help-block" element="em"/>

                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit" class="btn btn-primary">
                                            Sign up <span class="glyphicon glyphicon-check"></span>
                                        </button>
                                    </div>
                                </div>
                            </sf:form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
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