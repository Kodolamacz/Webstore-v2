<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<div class="alert-danger">
    <h3>You do not have permission to access this page!</h3>
</div>
<form action="${contextPath}/logout" method="post">
    <input type="submit" class="button red big" value="Sign in as different user" /> <input
        type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>