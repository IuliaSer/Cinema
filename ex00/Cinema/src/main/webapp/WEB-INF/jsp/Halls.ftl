
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Movie halls</h2>
<div id="table1">
    <table>
        <tr>
            <td>Serial number</td>
            <td>Amount of seats</td>
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
