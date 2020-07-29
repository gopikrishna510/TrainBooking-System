<html>
<head>
<title>Save Train_Page</title>
</head>
<body>
	<h3>Add Train</h3>
	<form action="saveTrain" method="post">
	<table>
		<tbody>
			<tr>
				<td>Train No</td>
				<td><input type="text" name="trainNo"></td>
				<td><h3 style="color:red;">${trainNo}</h3></td>
			</tr>
            <tr>
				<td>Train Name</td>
				<td><input type="text" name="trainName"></td>
				<td><h3 style="color:red;">${trainName}</h3></td>
			</tr>
			<tr>
				<td>Train Type</td>
				<td><input type="text" name="trainType"></td>
				<td><h3 style="color:red;">${trainType}</h3></td>
			</tr>
			<tr>
				<td>Train Fare</td>
				<td><input type="number" name="trainFare"></td>
				<td><h3 style="color:red;">${trainFare}</h3></td>
			</tr>
			<tr>
				<td>Starting Point</td>
				<td><input type="text" name="stratingPoint"></td>
				<td><h3 style="color:red;">${stratingPoint}</h3></td>
			</tr>
			<tr>
				<td>Destination Point</td>
				<td><input type="text" name="destinationPoint"></td>
				<td><h3 style="color:red;">${destinationPoint}</h3></td>
			</tr>
			<tr>
				<td><input type="submit" value="add_train"></td>
			</tr>
		</tbody>
	</table>
	</form>
	<h3 style="color:red;">${msg}</h3>
</body>
</html>