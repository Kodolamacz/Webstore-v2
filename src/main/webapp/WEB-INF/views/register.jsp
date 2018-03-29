<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 13.03.2018
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Registration process</title>
</head>
<body>

<form:form modelAttribute="user" action="${contextPath}/registration" method="post" acceptCharset="utf-8">
<form:errors path="*" element="table" cssClass="error"/>
    <table align="center">
        <tr>
            <td><form:label path="firstName"> Imię</form:label></td>
            <td><form:input path="firstName"></form:input></td>
            <td><form:errors path="firstName" cssClass="error"/> </td>
        </tr>

        <tr>
            <td><form:label path="lastName">Nazwisko</form:label></td>
            <td><form:input path="lastName"></form:input>
            <td><form:errors path="lastName" cssClass="error"/> </td>
        </tr>

        <tr>
            <td><form:label path="login" >Login</form:label></td>
            <td><form:input path="login"></form:input></td>
            <td><form:errors path="login" cssClass="error"/> </td>
        </tr>
        <tr>
            <td><form:label path="password">Hasło</form:label></td>
            <td><form:password path="password"></form:password></td>
            <td><form:errors path="password" cssClass="error"/> </td>

        </tr>
        <tr>
            <td><form:label path="matchingPassword">Powtórz hasło</form:label></td>
            <td><form:password path="matchingPassword"></form:password></td>
            <td><form:errors path="password" cssClass="error"/> </td>

        </tr>

        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"></form:input></td>
            <td><form:errors path="email" cssClass="error"/> </td>


        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Zarejestruj" /></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </table>

</form:form>

</form>
</body>
</html>
