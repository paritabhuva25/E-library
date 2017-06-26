<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/materialize.min.css">	
	
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="panel panel-default" style="margin: 30px;">
		<div class="panel-heading">
			<h3 class="panel-title">ADD NEW BOOK HERE</h3>
		</div>
		<div class="panel-body" style="margin: 10px;">
			<form action="BookControllerServelet" method="POST">

				<input type="hidden" name="command" value="ADD" />

				<div class="form-group row">
					<label for="example-text-input" class="col-xs-3 col-form-label">Book
						Title</label>
					<div class="col-xs-9">
						<input class="form-control" type="text" name="booktitle">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-3 col-form-label">ISBN
						Number</label>
					<div class="col-xs-9">
						<input class="form-control" type="number" name="isbnnumber">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-3 col-form-label">Price</label>
					<div class="col-xs-9">
						<input class="form-control" type="number" name="price">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-3 col-form-label">Author
						Id Number</label>
					<div class="col-xs-9">
						<input class="form-control" type="number" name="authorId">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-3 col-form-label">Publisher
						Id Number</label>
					<div class="col-xs-9">
						<input class="form-control" type="number" name="publisherId">
					</div>
				</div>

				<div class="form-group row">
					<label for="example-number-input" class="col-xs-3 col-form-label">Total
						Quantity </label>
					<div class="col-xs-9">
						<input class="form-control" type="number" name="totlaquantity">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-3 col-form-label">Sold
						Quantity </label>
					<div class="col-xs-9">
						<input class="form-control" type="number" name="soldquantity">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-datetime-local-input"
						class="col-xs-3 col-form-label">Publication Date</label>
					<div class="col-xs-9">
						<input class="form-control" type="date"
							name="publicationDate">
					</div>
				</div>
				<div class="form-group row">
					<label for="example-datetime-local-input"
						class="col-xs-3 col-form-label">Purchase Date</label>
					<div class="col-xs-9">
						<input class="form-control" type="date"
							name="purchaseDate">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-xs-12">
						<div class="col-xs-3"></div>
						<div class="col-xs-3"></div>
						<div class="col-xs-3">
							<input class="form-control btn btn-primary save" type="submit"
								value="Save" />
						</div>
						<div class="col-xs-3"></div>
					</div>

				</div>

			</form>
		</div>
	</div>
</body>
</html>