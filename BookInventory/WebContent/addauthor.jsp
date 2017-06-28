<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="panel panel-default" style="margin: 30px;">
		<div class="panel-heading">
			<h3 class="panel-title">ADD NEW PUBLISHER HERE</h3>
		</div>
		<div class="panel-body" style="margin: 10px;">
			<form action="AuthorControllerServlet" method="POST">

				<input type="hidden" name="command" value="ADD" />

				<div class="form-group row">
					<label for="example-text-input" class="col-xs-3 col-form-label">Author Name
					</label>
					<div class="col-xs-9">
						<input class="form-control" type="text" name="authorname">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="example-number-input" class="col-xs-3 col-form-label">Book Name
						</label>
					<div class="col-xs-9">
						<input class="form-control" type="text" name="authorbookname">
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