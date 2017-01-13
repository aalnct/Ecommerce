<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/view/template/header.jsp"%>

<div class="container-wrapper">

	<div class="container">

		<div class="page-header">

			<h1>Add Product Details</h1>

			<p class="lead">Complete following to add Products</p>

			<form:form method="POST" commandName="product" action = "${pageContext.request.contextPath}/admin/productInventory/addProduct"
			autocomplete="off" enctype="multipart/form-data">

				<div class="form-group">
						<label for="name">Name</label>
						<form:errors path = "productName" cssStyle="color:#ff0000"></form:errors>
						<form:input path="productName" id = "name" class  = "form-control"/>
				</div>
				
				<div class = "form-group">
					
					<label for = "category">Product Category</label>
					<label class = "checkbox-inline">
					<form:radiobutton path = "productCategory" id = "category" value = "instrument"/>&nbsp;&nbsp; Instrument
					</label>
					
					<label class = "checkbox-inline">
					<form:radiobutton path = "productCategory" id = "category" value = "record"/>&nbsp;&nbsp; Record
					</label>
					
					<label class = "checkbox-inline">
					<form:radiobutton path = "productCategory" id = "category" value = "accessory"/>&nbsp;&nbsp; Accessroy
					</label>
					
				</div>

				<div class="form-group">
						<label for="description">Description</label>
						<form:textarea path="productDescription" id = "description" class  = "form-control"/>
				</div>
				
				<div class="form-group">
						<label for="price">Price</label>
						<form:errors path = "productPrice" cssStyle="color:#ff0000"></form:errors>
						<form:input path="productPrice" id = "price" class  = "form-control"/>
				</div>
					
					
				<div class = "form-group">
					
					<label for = "category">Product Condition</label>
					<label class = "checkbox-inline">
					<form:radiobutton path = "productionCondition" id = "condition" value = "new"/>&nbsp;&nbsp; New
					</label>
					
					<label class = "checkbox-inline">
					<form:radiobutton path = "productionCondition" id = "condition" value = "used"/>&nbsp;&nbsp; Used
					</label>

				</div>
				
				<div class = "form-group">
					
					<label for = "status">Product Status</label>
					<label class = "checkbox-inline">
					<form:radiobutton path = "productStatus" id = "status" value = "active" />&nbsp;&nbsp; Active
					</label>
					
					<label class = "checkbox-inline">
					<form:radiobutton path = "productStatus" id = "status" value = "inactive"/>&nbsp;&nbsp; Inactive
					</label>

				</div>
				
				<div class="form-group">
						<label for="unitInStock">Unit in Stock</label>
						<form:errors path = "unitInStcok" cssStyle="color:#ff0000"></form:errors>
						<form:input path="unitInStcok" id = "unitInStcok" class  = "form-control"/>
				</div>
				
				<div class="form-group">
						<label for="manufacturer">Manufacturer</label>
						<form:input path="productManufacturer" id = "manufacturer" class  = "form-control"/>
				</div>
				
				<div class = "form-group">
						<label for="image" class = "control-lable">Upload Image</label>
						<form:input path="productImage" id = "productImage" type = "file" class = "form:input-large"/>
				</div>
			
				<br><br>
				
				<input type = "submit" value = "submit" class = "btn btn-default">
				<a href = "<c:url value = "/admin/productInventory" />" class = "btn btn-default">Cancel</a>
				<input type="button" id = "reset" class = "btn btn-warning" value = "Reset">
				 
			</form:form>

		</div>
		<%@include file="/WEB-INF/view/template/footer.jsp"%>
	</div>
</div>

