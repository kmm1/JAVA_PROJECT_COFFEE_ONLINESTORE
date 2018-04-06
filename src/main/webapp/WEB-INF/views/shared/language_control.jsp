<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="nav navbar-nav navbar-left">
    <li class="dropdown">
        <a href="javascript:void(0)"
           class="btn btn-default dropdown-toggle"
           id="dropwown-menu1"
           data-toggle="dropdown"><spring:message code="Language" text="default"/>
            <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="?lang=en"><spring:message code="English" text="default"/></a>

            <li class="divider" role="separator">
            </li>
            <li><a href="?lang=ru"><spring:message code="Russian" text="default"/></a>

            </li>
        </ul>
    </li>
</ul>