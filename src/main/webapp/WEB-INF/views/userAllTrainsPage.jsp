<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head></head>
<body>
	<h3>All trains</h3>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>Train No</th>
				<th>Train Name</th>
				<th>Train Fare</th>
				<th>Train Type</th>
				<th>Train From</th>
				<th>Train To</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${trains}" var="train">
				<tr>
					<td><c:out value="${train.getTrainNo()}" /></td>
					<td><c:out value="${train.getTrainName()}" /></td>
					<td><c:out value="${train.getTrainFare()}" /></td>
					<td><c:out value="${train.getTrainType()}" /></td>
					<td><c:out value="${train.getStratingPoint()}" /></td>
					<td><c:out value="${train.getDestinationPoint()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3 style="color:red">${msg}</h3>

</body>
</html>