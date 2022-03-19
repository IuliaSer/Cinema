
<html>
<head>
    <title>Movies</title>
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

            <#list movies as movie>
            <tr>
                <td> ${movie.title} </td>
                <td> ${movie.year} </td>
                <td> ${movie.ageRestriction} </td>
                <td> ${movie.description} </td>
            </tr>
            </#list>

    </table>
</div>
<br>

<input type="button" value="add movie"
       onclick="window.location.href = 'films/addFilm';" />
<br> <br>
</body>
</html>
