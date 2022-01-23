<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="http://localhost:8080/Cinema_war/admin/panel/halls" modelAttribute="hall">
    Amount of seats <form:input path="amountOfSeats"/>
    <br><br>
    <input type = "submit" value = "Submit" />
</form:form>

</body>
</html>
