<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 24.03.2018
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
    <div>
        <form action="${contextPath}/editPersonalData" method="post">
            <input type="submit" value="Edytuj dane"/>
        </form>

        <form action="${contextPath}/logout" method="post">
            <input type="submit" class="button red big" value="Wyloguj się" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>

</body>
</html>
