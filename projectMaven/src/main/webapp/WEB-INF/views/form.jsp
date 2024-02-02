<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 02.08.23
  Time: 08:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="paramName" id="form" method="post" >
    <label>
        Name:
        <input type="text" name="paramName">
    </label><br>
    <label>
        Date
        <input type="date" name="paramDate">
    </label>
    <br>
    <label>
        ${paramName}
        ${paramDate}
        <input type="submit" value="send">
    </label>
</form:form>
</body>
</html>
