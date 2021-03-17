<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Employee CURD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<form:form modelAttribute="employeeForm" class="form-horizontal"
			action="save" method="post">
			<fieldset>
				<c:if test="${not empty success}">
					<font color="green">${success}</font>
				</c:if>
				<c:if test="${not empty error}">
					<font color="red">${error}</font>
				</c:if>

				<!-- Form Name -->
				<legend>Form Name</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Enter Name</label>
					<div class="col-md-4">
						<form:input path="name" id="name" type="text"
							placeholder="Enter Name" class="form-control input-md"
							required=""></form:input>
						<form:errors path="name" cssStyle="color:red" />

					</div>
				</div>

				<c:forEach items="${employeeForm.addresses}" var="addr"
					varStatus="row">
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="city">Enter
							City Name</label>
						<div class="col-md-4">
							<form:input path="addresses[${row.index}].city" id="city"
								type="text" placeholder="Enter city"
								class="form-control input-md" required=""></form:input>

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="pincode">Enter
							Pincode</label>
						<div class="col-md-4">
							<form:input path="addresses[${row.index}].pincode" id="pincode"
								type="text" placeholder="Enter Pincode"
								class="form-control input-md" required=""></form:input>

						</div>
					</div>
					<hr />
				</c:forEach>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button type="submit" name="" class="btn btn-primary">Create
							Account</button>
					</div>
				</div>

			</fieldset>
		</form:form>
		<h2>Employee Info Table</h2>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>ADDRESS</th>
					<th>ACTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.address}</td>
						<td><a href="modify?id=${employee.id}">Edit</a>|<a
							href="delete?id=${employee.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

