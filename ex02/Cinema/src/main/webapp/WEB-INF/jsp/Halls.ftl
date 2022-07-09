
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Movie halls</h2>
<style>
    table {
        border-spacing: 15px 5px;
    }
</style>

<div id="table">
    <table>
        <tr>
            <td> <b> Serial number </b> </td>
            <td> <b> Amount of seats </b> </td>
        </tr>

        <#list halls as hall>
            <tr>
            <td> ${hall.serialNum} </td>
            <td> ${hall.amountOfSeats} </td>
            </tr>
        </#list>

    </table>
</div>
<br>

<input type="button" value="create new hall"
    onclick="window.location.href = 'halls/createHall';" />
<br> <br>

</body>
</html>
