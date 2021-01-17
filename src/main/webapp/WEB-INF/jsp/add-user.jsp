<% pageContext.setAttribute("activeTab", "users");  %>
<%@ include file="header.jsp" %>
<!-- Page content (Begin)  -->

	<h1>Add User</h1>
	<form:form method="post" action="/register/add" modelAttribute="user" class="form-horizontal" >
	<div role="form">

		<div class="row">
			<spring:bind path="firstname">
			<div class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
				<label class="control-label col-md-3" for="firstname">Firstname</label>
				<div class="col-md-7">
					<form:input name="firstname" type="text" path="firstname" id="firstname" class="form-control input-sm"/>
					<form:errors path="firstname" cssStyle="help-inline"/>	                
				</div>
			</div>
			</spring:bind>
		</div>
		<div class="row">
			<spring:bind path="lastname">
			<div class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
				<label class="control-label col-md-3" for="lastname">Lastname</label>
				<div class="col-md-7">
					<form:input name="lastname" type="text" path="lastname" id="lastname" class="form-control input-sm"/>
					<form:errors path="lastname" cssStyle="help-inline"/>	                
				</div>
			</div>
			</spring:bind>
		</div>
	        <div class="row">
	        	<spring:bind path="username">
	            <div class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
	                <label class="control-label col-md-3" for="username">Username</label>
	                <div class="col-md-7">
	                    <form:input name="username" type="text" path="username" id="username" class="form-control input-sm"/>
	                    <form:errors path="username" cssStyle="help-inline"/>	                
	                </div>
	            </div>
	            </spring:bind>
        	</div>
        	
        	<div class="row">
	            <spring:bind path="email">
	            <div class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
	                <label class="control-label col-md-3" for="email">Email</label>
	                <div class="col-md-7">
	                    <form:input name="email" type="text" path="email" id="email" class="form-control input-sm"/>
	                    <form:errors path="email" cssStyle="help-inline"/>	                    
	                </div>
	            </div>
	            </spring:bind>
        	</div>
        	
        	 <div class="row">
	            <spring:bind path="password">
	            <div class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
	                <label class="control-label col-md-3" for="password">Password</label>
	                <div class="col-md-7">
	                    <form:password name="password" path="password" id="password" class="form-control input-sm"/>
	                    <form:errors path="password" cssStyle="help-inline"/>	                 
	                </div>
	            </div>
	            </spring:bind>
        	</div>
			
			
			<div class="row">
	            <div class="form-actions">
	                <input type="submit" value="Add" class="btn btn-default pull-right">
	            </div>
	        </div>
	 </div>
	</form:form>

<!-- Page content (End)    -->
<%@ include file="footer.jsp" %>