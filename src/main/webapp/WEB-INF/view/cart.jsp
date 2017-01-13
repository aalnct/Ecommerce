<%@include file="/WEB-INF/view/template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class = "container-wrapper">

	<div class = "container">
	
	
				<section>
				
						<div class = "jumbotron">
						
								<div class = "container">
									
									<h3>Cart</h3>
									
								</div>
								
						
						</div>
				
				</section>
				
				<section class = "container">
						
						<div>
							<a class = "btn btn-danger pull-left"><span class = "glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
						</div>
						
						
						<table class = "table table-hover">
							<tr>
								<th>Product</th>
								<th>Unit Price</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Action</th>
							</tr>
							
							
							<tr>
									
									<td>ProductName</td>
									<td>ProductName</td>
									<td>ProductName</td>
									<td>ProductName</td>
									<td>Remove Buton</td>
								
							</tr>
							
							<tr>
								<th></th>
								<th></th>
								<th>Grand Total</th>
								<th>GrandTotal</th>
								<th></th>
							</tr>
							
						</table>
						
						<a href = "<spring:url value = "/productList"/>">Continue Shopping</a>
						
				</section>
			
	</div>
		

</div>




<%@include file="/WEB-INF/view/template/footer.jsp"%>