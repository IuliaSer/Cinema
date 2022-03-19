
<html>
<head>
    <title>Add movie</title>
</head>

<body>

    <form method="post" action="http://localhost:8080/Cinema_war/admin/panel/films/saveFilm" modelAttribute="movie" enctype="multipart/form-data">
        Title <input type="text" name="title"/>
        <br><br>
        Year <input type="text" name="year"/>
        <br><br>
        Age restriction <input type="text" name="ageRestriction"/>
        <br><br>
        Description <input type="text" name="description"/>
        <br><br>
        <input type="file" name="image" accept="image/*"/>
        <input type="submit" value="Submit" />
    </form>

</body>

</html>
