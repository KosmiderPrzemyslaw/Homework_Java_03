<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 14.01.22
  Time: 12:27
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
<c:set var="tabSize" value="${empty size ? 10: size}"/>

<table>
    <c:forEach begin="1" end="${size}" varStatus="i">
        <tr>
            <c:forEach begin="1" end="${tabSize}" varStatus="j">
                <td>${i.index * j.index}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

<form>
    <select name="gender">
        <option value="M">Male</option>
        <option value="F">Female</option>
    </select>
</form>
</body>
</html>
