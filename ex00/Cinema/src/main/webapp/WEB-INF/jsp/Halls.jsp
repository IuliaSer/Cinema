<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="table1">
    <table style="width:80%">
        <tr>
            <td>Serial number</td>
            <td>Amount of seats</td>
        </tr>

        <c:forEach var="hall" items="$(halls)">
        <tr>
            <td> ${hall.serialNum} </td>
<%--            <td> ${hall.amountOfSeats} </td>--%>
        </tr>
        </c:forEach>
    </table>
</div>

<br> <br>
</body>
</html>
