<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath}/home" class="navbar-brand"><spring:message code="Home" text="default"/></a>
        </div>
        <%@ include file="language_control.jsp" %>

    </div>
</nav>
