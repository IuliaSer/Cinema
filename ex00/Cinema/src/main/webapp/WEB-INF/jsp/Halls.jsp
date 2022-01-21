<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Movie halls</h2>
<div id="table1">
    <table>
        <tr>
            <td>Serial number</td>
            <td>Amount of seats</td>
        </tr>

        <c:forEach items="${halls}" var="hall">
        <tr>
            <td> ${hall.serialNum} </td>
            <td> ${hall.amountOfSeats} </td>
        </tr>
        </c:forEach>
    </table>
</div>
<br>

<input type="button" value="create new hall"
    onclick="window.location.href = 'halls/createHall';" />
<br> <br>
</body>
</html>
