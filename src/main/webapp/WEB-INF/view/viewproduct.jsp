<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">

	<div class="container">

		<div class="page-header">

			<h1>Product Details</h1>

			<p class="lead">Detailed Information</p>

			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<%-- <img src = "<c:url value = "/resources/images/{products.productId}.png"/>" alt = "Image" style  = "width:100%;"/> --%>
						<img src = "${product.saveProductImage}" alt = "Image" style  = "width:100%;"/>
					</div>
					
					<div class = "col-md-5">
						<h3>${product.productName }</h3>
						<p>${product.productDescription }</p>
						<p>
								<strong>Manufacturer: </strong> ${product.productManufacturer }
						</p>
						<p>
							<strong>Category: </strong>${product.productCategory }
						</p>
						
						<p>
						<strong>Product Condition: </strong> ${product.productionCondition }</p>
						
						<p>
						<strong>Product Price: </strong> ${product.productPrice }</p>
					</div>
					
				</div>
			</div>
</div>
		<%@include file="/WEB-INF/view/template/footer.jsp"%>
</div></div>

			