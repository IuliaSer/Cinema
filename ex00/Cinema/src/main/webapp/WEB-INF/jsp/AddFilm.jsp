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
<form:form action = "http://localhost:8080/Cinema_war/admin/panel/films/saveFilm" modelAttribute="movie">
    Title <form:input path="title"/>
    <br><br>
    Year <form:input path="year"/>
    <br><br>
    Age restriction <form:input path="ageRestriction"/>
    <br><br>
    Description <form:input path="description"/>
    <br><br>
    <input type = "submit" value = "Submit" />
</form:form>

<div id="imageForm">
    <br>
    <form:form action="http://localhost:8080/Cinema_war/admin/panel/films/savePoster" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="Upload" />
    </form:form>
</div>
</body>

</html>
