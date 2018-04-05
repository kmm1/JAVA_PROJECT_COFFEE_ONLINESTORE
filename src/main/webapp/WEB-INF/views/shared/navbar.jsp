<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home Page</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li>
                    <a href="${pageContext.request.contextPath}/about">About</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/contact">Contact</a>
                </li>
                <security:authorize access="hasAnyAuthority('ADMIN')">
                    <li id="manageProducts">
                        <a href="${pageContext.request.contextPath}/manage/configuration">Manage Products</a>
                    </li>
                </security:authorize>
            </ul>


            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="isAnonymous()">
                    <li id="register">
                        <a href="${pageContext.request.contextPath}/register">Sign up</a>
                    </li>
                    <li id="login">
                        <a href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <li class="dropdown" id="userCart">
                        <a href="javascript:void(0)"
                           class="btn btn-default dropdown-toggle"
                           id="dropwown-menu1"
                           data-toggle="dropdown">${userDto.name}
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <security:authorize access="hasAnyAuthority('USER')">
                                <li>
                                    <a href="${pageContext.request.contextPath}/cart/show">
                                        <span class="glyphicon glyphicon-shopping-cart"></span>
                                        <span class="badge">${userDto.numberOfProductsInCart}</span>
                                        - &#36; ${userDto.cartTotal}
                                    </a>
                                </li>
                                <li class="divider" role="separator">
                                </li>
                            </security:authorize>
                            <li><a href="${pageContext.request.contextPath}/perform-logout">LogOut</a>
                            </li>
                        </ul>
                    </li>
                </security:authorize>
            </ul>

            <%@ include file="language_control.jsp" %>


        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
