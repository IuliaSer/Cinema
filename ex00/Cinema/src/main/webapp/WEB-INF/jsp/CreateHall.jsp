<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: iserzhan
  Date: 1/21/22
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/admin/panel/halls" modelAttribute="hall">
    Serial num: <input type = "text" name = "Serial num" />
    <br><br>
    Amount of seats: <input type = "text" name = "Amount of seats" />
    <br><br>
    <input type = "submit" value = "Submit" />
</form:form>

</body>
</html>
