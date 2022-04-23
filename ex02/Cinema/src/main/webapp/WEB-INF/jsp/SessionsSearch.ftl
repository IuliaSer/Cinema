
<html>
<head>
    <title>jQuery Ajax POST data Request and Response Example</title>

    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>

</head>
<body>

    <input type="text" name="search" id="search" placeholder="Enter a movie's name">

    <div id="ajaxResponse"></div>
    </div>

<script type="text/javascript">
    $(document).ready(function() {
        $("#search").keyup(function (e) {
            var movieTitle = $('#search').val();
            e.preventDefault();
            $("#ajaxResponse").html('');

            $.ajax({
                type: "GET",
                url: "sessions/search",
                data: {'movieTitle': movieTitle},
                dataType: "json",
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        $("#ajaxResponse").append('<div>' +
                            '<p><img src="data:image/png;base64,' + data[i].movie.imageUrl+'" width="150", height="200"></p>' +
                            '<p>' + data[i].time + '</p>' +
                            '<p><a href="sessions/' + data[i].sessionId + '">' + data[i].movie.title + '</a></p>' +
                            '</div>')

                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("Something really bad happened " + textStatus);
                    $("#ajaxResponse").html(jqXHR.responseText);
                },
                //capture the request before it was sent to server
                beforeSend: function (jqXHR, settings) {
                    //disable the button until we get the response
                    $('#myButton').attr("disabled", true);
                },
                //this is called after the response or error functions are finished
                //so that we can take some action
                complete: function (jqXHR, textStatus) {
                    //enable the button
                    $('#myButton').attr("disabled", false);
                }
            })
        })
    })
</script>

</body>
</html>