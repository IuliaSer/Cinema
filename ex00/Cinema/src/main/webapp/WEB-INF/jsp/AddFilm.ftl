
<html>
<head>
    <title>Add movie</title>
</head>

<body>

    <form method="post" action="http://localhost:8080/Cinema_war/admin/panel/films/saveFilm" modelAttribute="movie" enctype="multipart/form-data">
        Title <input name="title"/>
        <br><br>
        Year <input name="year"/>
        <br><br>
        Age restriction <input name="ageRestriction"/>
        <br><br>
        Description <input name="description"/>
        <br><br>
        <input type="file" name="image" accept="image/*"/>
        <input type="submit" value="Submit" />
    </form>

</body>

</html>
