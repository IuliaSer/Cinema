<html>
<head>
	<title></title>
</head>
<body>

<h2> About a movie</h2>
<div id="sessions">
	<table>
		<tr>
			<td> <b> Time </b> </td>
			<td> <b> Price </b> </td>
			<td> <b> Film </b> </td>
			<td> <b> Hall number </b> </td>
		</tr>

			<tr>
				<td> ${session.time} </td>
				<td> ${session.price} </td>
				<td> ${session.movie.title} </td>
				<td> ${session.hall.serialNum} </td>

			</tr>
	</table>
</div>
<br>
<img src="data:image/png;base64, ${session.movie.imageUrl} " style="height: 200px; width: 150px;">

</body>
</html>
