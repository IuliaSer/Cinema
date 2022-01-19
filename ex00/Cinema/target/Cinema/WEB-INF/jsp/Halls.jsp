<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: iserzhan
  Date: 1/5/22
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
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

        <c:forEach var="halls" items="$(halls)">
        <tr>
            <td> ${halls.serialNum} </td>
            <td> ${halls.amountOfSeats} </td>
        </tr>
        </c:forEach>
    </table>
</div>

<br> <br>
</body>
</html>
