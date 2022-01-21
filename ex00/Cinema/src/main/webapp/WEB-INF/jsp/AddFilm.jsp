<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: iserzhan
  Date: 1/21/22
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action = "/admin/panel/films/saveFilm" modelAttribute="movie">
    Title: <input type = "text" name = "Title" />
    <br><br>
    Year: <input type = "text" name = "Year" />
    <br><br>
    Age restriction: <input type = "text" name = "Age restriction" />
    <br><br>
    Description: <input type = "text" name = "Description" />
    <br><br>
    <input type = "submit" value = "Submit" />
</form:form>
</body>
</html>
