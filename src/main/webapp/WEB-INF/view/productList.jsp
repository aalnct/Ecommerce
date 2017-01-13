<%@taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file = "/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">

   <div class = "container">
   		
   		<div class = "page-header">
   			
   			<br/><br/>
   			
   			<h1>All Products</h1>
   			
   			<p class ="lead">Checkout all products available now</p>
   			
   			<table class = "table table-striped table-hover">
   					<thead>
   						<tr class = "bg-success">
   							<th>Photo Thumb</th>
   							<th>Product Name</th>
   							<th>Category</th>
   							<th>Condition</th>
   							<th>Price</th>
   							<th></th>
   						</tr>
   					</thead>
   					<c:forEach items="${product}" var = "products">
				   					<tr>
				   						<td>
				   							<img src = "<c:url value = "/resources/images/{products.productId}.png"/>" alt = "Image" style  = "width:100%;"/>
				   						</td>
				   						
				   						<td>${products.productName }</td>
				   						<td>${products.productCategory}</td>
				   						<td>${products.productionCondition}</td>
				   						<td>${products.productPrice}</td>
				   						<td>
				   						<td><a href="<spring:url value="/productList/viewProduct/${products.productId}" />"
                    							><span class="glyphicon glyphicon-info-sign"></span></a></td>
				   					</tr>
   					</c:forEach>
   			</table>
   			</div></div></div>
   			
<%@include file = "/WEB-INF/view/template/footer.jsp" %>