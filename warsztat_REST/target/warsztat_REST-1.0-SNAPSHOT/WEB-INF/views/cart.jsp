<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 19.01.22
  Time: 06:53
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
<form:form method="post" action="/cartController">
    <label>
        Product:
        <input type="text" name="productName">
    </label>
    <br>
    <label>
        Quantity
        <input type="number" name="quantity">
    </label>
    <br>
    <label>
        <input type="submit" value="Send">
    </label>
</form:form>
</body>
</html>
