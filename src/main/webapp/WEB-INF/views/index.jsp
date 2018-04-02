<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Insert title here</title>

</head>
<body>
<h1>USER</h1>
${user.email}

<c:forEach var="reg" items="${all}">
    <tr>
        <td><c:out value="${reg.name}"></c:out></td>
    </tr>
</c:forEach>




</body>
</html>