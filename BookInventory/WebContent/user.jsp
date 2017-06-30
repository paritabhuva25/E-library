<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%@include file="header.jsp" %>
	
	<div id="container">
		<h3>Add Student</h3>
		
		<form action="UserControllerServelet" method="POST">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>User name:</label></td>
						<td><input type="text" name="regusername" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><input type="password" name="regpassword" /></td>
					</tr>
					<tr>
						<td><label>Mobile Number:</label></td>
						<td><input type="tel" name="regmobno" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>