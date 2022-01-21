<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Movies </h2>
<div id="table1">
    <table>
        <tr>
            <td>Title</td>
            <td>Year</td>
            <td>Age restriction</td>
            <td>Description</td>
        </tr>

        <c:forEach items="${movies}" var="movie">
            <tr>
                <td> ${movie.title} </td>
                <td> ${movie.year} </td>
                <td> ${movie.ageRestriction} </td>
                <td> ${movie.description} </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>

<input type="button" value="add movie"
       onclick="window.location.href = 'films/addFilm';" />
<br> <br>
</body>
</html>
