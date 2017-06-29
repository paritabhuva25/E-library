<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="css/payment.css">
	
</head>
<body>

	<%@include file="header.jsp" %>
		<div class="container">
			<div class="panel panel-default" style="margin: 30px;">
			<div class="panel-heading col-xs-12">
				<div class="col-xs-3">
					<h3 class="panel-title">Buy Your Book</h3></div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3"></div>
				<div class="col-xs-3" style = "text-align: right;">
					<input class="form-control btn btn-defaukt save" type="submit"
						onclick="window.location.href='addbook.jsp'; return false;"
						value="Home" />
				</div>
			</div>				
			
			<div class="panel-body col-xs-12" style="margin: 10px;">
							
				
					<div class="row">	
						<div class="col-xs-12">	
							<div class="form-group">
								<label for="cardNumber">BOOK NAME</label>
								<label for="cardNumber">${THE_BOOK.bookTitle}</label>
							</div>
						</div>                            
					</div>
					
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<label for="cardNumber">BOOK PRICE</label>
								<label for="cardNumber"><c:out value="${THE_BOOK.price}"/></label>
							</div>                            
						</div>
					</div>
					<form role="form" id="payment-form" action="BuybookControllerServlet" method="POST">
					<input type="hidden" name="command" value="ADD" />
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="cardNumber">BOOK QUANTITY</label>
									<div class="input-group">
										<input type="tel"
											class="form-control"
											name="bookquantity"
											required autofocus 
											/>
										<span class="input-group-addon">Not more than ${THE_BOOK.quantity}</span>
									</div>
								</div>                            
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="cardNumber">CARD NUMBER</label>
									<div class="input-group">
										<input type="tel"
											class="form-control"
											name="cardNumber"
											placeholder="Valid Card Number"
											autocomplete="cc-number"
											required autofocus 
											/>
										<span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
									</div>
								</div>                            
							</div>
						</div>
						<div class="row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
									<input 
									type="tel" 
									class="form-control" 
									name="cardExpiry"
									placeholder="MM / YY"
									autocomplete="cc-exp"
									required 
									/>
								</div>
							</div>
						<div class="col-xs-5 col-md-5 pull-right">
							<div class="form-group">
								<label for="cardCVC">CV CODE</label>
								<input 
								type="tel" 
								class="form-control"
								name="cardCVC"
								placeholder="CVC"
								autocomplete="cc-csc"
								required
								/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<button class="btn btn-success btn-lg btn-block" type="submit">Buy Now!!</button>
						</div>
					</div>
					<div class="row" style="display:none;">
						<div class="col-xs-12">
							<p class="payment-errors"></p>
						</div>
					</div>
				</form>
			</div>       
		</div>
		

		</div>
	</body>
</html>