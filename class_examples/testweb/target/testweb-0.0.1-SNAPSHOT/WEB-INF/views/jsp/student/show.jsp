<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Student App</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Student Name</th>
				<th>Student RollNo</th>
			</tr>
		</thead>
		<tr>
			<td>${student.name}</td>
			<td>${student.rollNo}</td>
		</tr>
	</table>
</body>
</html>