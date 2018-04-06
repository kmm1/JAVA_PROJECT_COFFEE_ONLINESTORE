<div class="container">

    <div class="row">

        <div class="col-md-3">
            <%@include file="shared/sidebar.jsp" %>
        </div>

        <div class="col-md-9">

            <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="slide-image"
                                     src="${pageContext.request.contextPath}/static/images/slide/1slider.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image"
                                     src="${pageContext.request.contextPath}/static/images/slide/2slider.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image"
                                     src="${pageContext.request.contextPath}/static/images/slide/3slider.jpg" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>

            </div>

            <div class="row">

                <div class="col-md-12">

                    <c:forEach items="${coffeeList}" var="coffee">
                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <h4 class="text-center"><span class="label label-info">${coffee.name}</span></h4>
                                <img src="${pageContext.request.contextPath}/static/images/${coffee.image}"
                                     class="img-responsive">
                                <div class="caption">
                                    <div class="row">
                                        <div class="col-md-6 col-xs-6">
                                            <h3>
                                                <a href="${pageContext.request.contextPath}/cart/add/product/${coffee.id}"
                                                   class="btn btn-success btn-product"><span
                                                        class="glyphicon glyphicon-shopping-cart"></span> <spring:message code="Buy" text="default"/></a></h3>
                                        </div>
                                        <div class="col-md-6 col-xs-6 price">
                                            <h3><label>$${coffee.price}</label></h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>

        </div>

    </div>

</div>
<!-- /.container -->

