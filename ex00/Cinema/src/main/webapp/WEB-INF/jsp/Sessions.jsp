<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: iserzhan
  Date: 1/24/22
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2> Movie sessions</h2>
<div id="table1">
    <table>
        <tr>
            <td>Time</td>
            <td>Price</td>
            <td>Film</td>
            <td>Hall number</td>
        </tr>

        <c:forEach items="${sessions}" var="session">
            <tr>
                <td> ${session.time} </td>
                <td> ${session.price} </td>
                <td> ${session.movie.title} </td>
                <td> ${session.hall.serialNum} </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>

<input type="button" value="create"
       onclick="window.location.href = 'sessions/createSession';" />
<br> <br>
</body>
</html>
