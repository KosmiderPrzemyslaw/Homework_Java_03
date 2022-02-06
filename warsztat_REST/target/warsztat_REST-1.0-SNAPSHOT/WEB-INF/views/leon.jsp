<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 14.01.22
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Wartość z sesji leon: ${leon}</p>
<p>Wartość z sesji age: ${age}</p>

<form>
    <label>
        <select name="colors" multiple>
            <option value="red">red</option>
            <option value="blue">blue</option>
            <option value="yellow">yellow</option>
        </select>
    </label>
    <button type="submit">Submit</button>
</form>
</body>
</html>
