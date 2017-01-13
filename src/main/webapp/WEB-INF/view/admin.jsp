<%@include file = "/WEB-INF/view/template/header.jsp" %>

<div class="container-wrapper">

   <div class = "container">
   		
   		<div class = "page-header">
   			
   			<br/><br/>
   			
   			<h3>All Products</h3>
   			
   			<p class ="lead">Please Add a new Product - Admin</p>
   			
   			</div>
   			
   			<c:if test="${pageContext.request.userPrincipal.name != null}">
            <h4>
                Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
            </h4>
        </c:if>
   			
   					<h3>
   						<a href = "<c:url value="/admin/productInventory"/>">
   							Product Inventory
   						</a>
   					</h3>
   					
   					
   					<p>View, Check and Modify Product Inventory</p>
   					
   					<%@include file = "/WEB-INF/view/template/footer.jsp" %>
   			
   			</div></div>
   			
   			
