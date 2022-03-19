
<html>
<head>
    <title></title>
</head>
<body>

<h2> Movie sessions</h2>
<div id="sessions">
    <table>
        <tr>
            <td>Time</td>
            <td>Price</td>
            <td>Film</td>
            <td>Hall number</td>
        </tr>

            <#list sessions as session>

            <tr>
                <td> ${session.time} </td>
                <td> ${session.price} </td>
                <td> ${session.movie.title} </td>
                <td> ${session.hall.serialNum} </td>
            </tr>
        </#list>
    </table>
</div>
<br>

<input type="button" value="create"
       onclick="window.location.href = 'sessions/createSession';" />
<br> <br>
</body>
</html>
