<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 14.01.22
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Parameter rows = ${rows}, cols = ${columns}</p>
<table>
    <c:forEach begin="1" end="${rows}" varStatus="i">
        <tr>
            <th>${i.index}</th>
            <c:forEach begin="1" end="${columns}" varStatus="j">
                <td> ${i.index * j.index}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
