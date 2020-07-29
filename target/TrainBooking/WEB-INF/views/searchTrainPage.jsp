<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>SearchTrainDetails</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h3>Search train by Locations</h3>

	<form action="searchTrainByDestination">
		<table>
			<thead>
				<tr>
					<th><h3>From</h3></th>
					<th><h3>To</h3></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="from"></td>
					<td><input type="text" name="to"></td>
				</tr>
				<tr>
					<td><input id="Search" type="submit" value="search" ></td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	
	<%-- <h3>${trains}</h3> --%>
		
	<table border="1">
	<div id="fasak">
		<thead>
			<tr>
				<th>Train Id</th>
				<th>TrainNo</th>
				<th>TrainName</th>
				<th>TrainType</th>
				<th>TrainFare</th>
				<th>stratingPoint</th>
				<th>destinationPoint</th>
			</tr>
		</thead>
		</div>
		<tbody>
			<c:forEach var="train" items="${trains}">
				<tr>
					<td><c:out value="${train.getId()}" /></td>
					<td><c:out value="${train.getTrainNo()}" /></td>
					<td><c:out value="${train.getTrainName() }" /></td>
					<td><c:out value="${train.getTrainType()}" /></td>
					<td><c:out value="${train.getTrainFare()}" /></td>
					<td><c:out value="${train.getStratingPoint()}" /></td>
					<td><c:out value="${train.getDestinationPoint()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h3>${msg}</h3>
</body>
<script type="text/javascript">
$(document).ready(function(){
	  $("#Search").click(function(){
	    $("#fasak").fadeToggle();
	  });
});

</script>
</html>