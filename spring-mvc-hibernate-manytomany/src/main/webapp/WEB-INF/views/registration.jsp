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
		<form:form class="form-horizontal" action="add"
			modelAttribute="productForm">
			<fieldset>

				<!-- Form Name -->
				<legend>Form Name</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Enter
						Product Name</label>
					<div class="col-md-4">
						<form:input id="name" path="name" type="text"
							placeholder="Enter Product Name" class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="price">Enter
						Product Price</label>
					<div class="col-md-4">
						<form:input id="price" path="price" type="text"
							placeholder="Enter Product Price" class="form-control input-md" />

					</div>
				</div>

				<!-- Multiple Checkboxes (inline) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="colors">Colors</label>
					<div class="col-md-4">
						<c:forEach items="${productForm.colors}" var="color"
							varStatus="row">
							<label class="checkbox-inline" for="colors-0"> 
								<input type="checkbox" name="colors[${row.index}].id" value="${color.id}"/> ${color.color}  
							</label>
						</c:forEach>

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button id="" name="" class="btn btn-primary">Add Product</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</div>
</body>
</html>

