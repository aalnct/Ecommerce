<%@include file="/WEB-INF/view/template/header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<div ng-app = "loginController">
		<div class = "container-wrapper">
				
				<div class = "container">
					
						
				
						<div id = "login-box">
						
						
							<h2>Please Login</h2>
							
							<c:if test="${not empty message}">
								<div class = "message">
									<c:out value="${message}"/>
								</div>
								
							</c:if>
							
							
							<form name = "loginForm" action = "<c:url value = "/j_spring_security_check"/>" method = "post">
							
							<c:if test="${not empty error}">
								<div class = "error" style = "color:#ff0000;">
									<c:out value="${error}"/>
								</div>
							</c:if>
							
									<div class = "form-group" style = "width: 15%;">
										<label for = "username">UserName : </label>
										<input type ="text" id = "username" name = "username" class = "form-control"/>
									</div>
									
									<div class = "form-group" style = "width: 15%;">
										<label for = "password">Password : </label>
										<input type = "password" id = "password" name = "password" class = "form-control">
									</div>
									
									
									<input type = "submit" value = "Submit" class = "btn btn-success">
									
									<input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token }">
							</form>
						
						
						</div>
				
				</div>
		
		</div>

</div>


<%@include file="/WEB-INF/view/template/footer.jsp"%>