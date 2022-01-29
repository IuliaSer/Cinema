<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: iserzhan
  Date: 1/24/22
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin </title>
</head>
<body>
    <form:form method="post" action="http://localhost:8080/Cinema_war/admin/panel/sessions">

        <select name="movieId" id="Select movie">
            <option value="">--Please choose a movie--</option>
            <c:forEach items="${movies}" var="movie">
                <option value="${movie.id}">
                    ${movie.title}, ${movie.year} <option/>
            </c:forEach>
        </select>

        <select name="hallId" id="Select hall">
            <option value="">--Please choose a hall--</option>
            <c:forEach items="${halls}" var="hall">
                <option value="${hall.serialNum}">
                        ${hall.amountOfSeats} <option/>
            </c:forEach>
        </select>

<%--        Time <form:input path="time"/>--%>
<%--        <br><br>--%>
<%--        Price <form:input path="price"/>--%>
<%--        <br><br>--%>
        <label style="background-color: darkgray" for="ticketPrice">Ticket price</label>
        <input type="text" id="ticketPrice" name="price" required>

        <label style="background-color: darkgray" for="time">Time</label>
        <input type="datetime-local" id="time" name="time" required>
        <input type = "submit" value = "Submit" />
    </form:form>
</body>
</html>
