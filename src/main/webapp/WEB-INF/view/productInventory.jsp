<%@taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file = "/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">

   <div class = "container">
   		
   		<div class = "page-header">
   			
   			<br/><br/>
   			
   			<h3>Product Inventory</h3>
   			
   			<p class ="lead">Product Inventory Page</p>
   			
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
				   							<img src="${products.saveProductImage}" style  = "width:100%;"/>
				   						</td>
				   						
				   						<td>${products.productName}</td>
				   						<td>${products.productCategory}</td>
				   						<td>${products.productionCondition}</td>
				   						<td>${products.productPrice}</td>
				   						
				   						<td>
				   						<a href="<spring:url value="/productList/viewProduct/${products.productId}" />"
                    							><span class="glyphicon glyphicon-info-sign"></span></a>
                    							
                    					<a href="<spring:url value="/admin/productInventory/deleteProduct/${products.productId}" />"
                    							><span class="glyphicon glyphicon-remove"></span></a>
                    							
                    					<a href="<spring:url value="/admin/productInventory/editProduct/${products.productId}" />"
                    							><span class="glyphicon glyphicon-pencil"></span></a>		
                    					
                    					
                    					</td>
                    							
                    							
                    							
				   					</tr>
   					</c:forEach>
   			</table>
   				<a href = "<spring:url value = "/admin/productInventory/addProduct"/>" class = "btn btn-primary">Add Product</a>
   			</div></div></div>
<%@include file = "/WEB-INF/view/template/footer.jsp" %>