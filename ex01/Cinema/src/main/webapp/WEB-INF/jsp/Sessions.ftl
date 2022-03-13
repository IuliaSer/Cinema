
<html>
<head>
    <title></title>
</head>
<body>

<h2> Movie sessions</h2>

<style>
    table {
        border-spacing: 25px 5px;
    }
</style>

<div id="table">
    <table>
        <tr>
            <td> <b> Time  </b> </td>
            <td> <b> Price </b> </td>
            <td> <b> Film </b> </td>
            <td> <b> Hall number </b> </td>
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
