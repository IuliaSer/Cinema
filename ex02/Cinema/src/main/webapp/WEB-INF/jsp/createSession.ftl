
<html>
<head>
    <title>Admin </title>
</head>
<body>
    <form method="post" action="http://localhost:8080/admin/panel/sessions">

        <select name="movieId" id="Select movie">
            <option value="">--Please choose a movie--</option>
            <#list movies as movie>
                <option value="${movie.id}">
                    ${movie.title}, ${movie.year} <option/>
            </#list>
        </select>

        <select name="hallId" id="Select hall">
            <option value="">--Please choose a hall--</option>
            <#list halls as hall>
                <option value="${hall.serialNum}">
                        ${hall.amountOfSeats} <option/>
            </#list>
        </select>

        <label style="background-color: darkgray" for="ticketPrice">Ticket price</label>
        <input type="text" id="ticketPrice" name="price" required>

        <label style="background-color: darkgray" for="time">Time</label>
        <input type="datetime-local" id="time" name="time" required>
        <input type = "submit" value = "Submit" />
    </form>
</body>
</html>
