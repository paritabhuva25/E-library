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
	<%@include file="header.jsp" %>
	
		<div class="panel panel-default" style="margin: 30px;">
			<div class="panel-heading col-xs-12">
				<div class="col-xs-3">
					<h3 class="panel-title">Your Library is here !!</h3>
				</div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3" style = "text-align: right;">
					<input class="form-control btn btn-defaukt save" type="submit"
						value="Add book" />
				</div>
			</div>				
			</div>
			<div class="panel-body" style="margin: 10px;">
				<table>
			
				<tr>
					<th>Book Title</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Price</th>
				</tr>
				<c:forEach var="tempbook" items="${BOOK_LIST}">
					
					<!-- set up a link for each student 	-->
					<c:url var="tempLink" value="BookControllerServelet">
						<c:param name="command" value="LOAD" />
						<c:param name="bookId" value="${tempbook.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="BookControllerServelet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>		 									
					<tr>
						<td> ${tempbook.bookTitle} </td>
						<td> ${tempbook.authorId} </td>
						<td> ${tempbook.publisherId} </td>
						<td> ${tempbook.price} </td>
						
					</tr>
				
				</c:forEach>
				
			</table>
			</div>
		</div>
</body>
</html>