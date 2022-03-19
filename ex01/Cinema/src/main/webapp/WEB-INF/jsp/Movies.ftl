
<html>
<head>
    <title>Movies</title>
</head>
<body>
<h2> Movies </h2>
<style>
    table {
        border-spacing: 15px 5px;
    }
</style>
<div id="table">
    <table>
        <tr>
            <td> <b> Title </b> </td>
            <td> <b> Year </b> </td>
            <td> <b> Age restriction </b> </td>
            <td> <b> Description </b> </td>
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
