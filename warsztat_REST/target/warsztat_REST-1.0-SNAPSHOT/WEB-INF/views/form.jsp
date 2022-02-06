<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 13.01.22
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/form">


    <label for="paramName"></label><input type="text" id="paramName" name="paramName">paramName

    <label for="paramDate"></label><input type="text" id="paramDate" name="paramDate">paramDate

    <button type="submit">Send</button>
</form:form>
</body>
</html>
