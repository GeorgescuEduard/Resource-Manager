<% pageContext.setAttribute("activeTab", "wallet"); %>
<%@ include file="header.jsp" %>
<%@ include file="navbar-controll.jsp" %>
<!-- Page content (Begin) -->
<div class="container">
<div style="margin-top: 60px;" class="text-center" >
    <h3>Add a new wallet</h3>
</div>
<form:form method="post" modelAttribute="wallet">
    <div role="form">
        <div class="row d-flex justify-content-center">
            <spring:bind path="name">
                <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                    <label class="control-label" for="name">Name</label>
                        <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        <form:errors path="name" cssStyle="help-inline"/>
                </div>
            </spring:bind>
        </div>

        <div class="row d-flex justify-content-center">
            <spring:bind path="description">
                <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                    <label class="control-label" for="description">Description</label>
                        <form:input type="text" path="description" id="description" class="form-control input-sm"/>
                        <form:errors path="description" cssStyle="help-inline"/>
                </div>
            </spring:bind>
        </div>

        <div class="row d-flex justify-content-center">
            <spring:bind path="amount">
                <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                    <label class="control-label" for="amount">Amount</label>
                        <form:input type="text" path="amount" id="amount" class="form-control input-sm"/>
                        <form:errors path="amount" cssStyle="help-inline"/>
                </div>
            </spring:bind>
        </div>

        <div class="row d-flex justify-content-center">
            <spring:bind path="userId">
                <div class="form-group col-lg-4 ${status.error ? 'has-error' : ''}">
                    <label class="control-label" for="userId">UserId</label>
                        <form:select path="userId" required="true" class="form-control input-sm">
                            <form:option value="">--Select--</form:option>
                            <form:options items="${users}" itemLabel="userid" itemValue="userid"/>
                        </form:select>
                        <form:errors path="userId" cssStyle="help-inline"/>
                </div>
            </spring:bind>
        </div>

        <div class="row d-flex justify-content-center mt-4">
            <div class="form-actions text-center">
                <input type="submit" value="Add" class="btn btn-secondary pull-right">
            </div>
        </div>
    </div>
</form:form>
</div>

<!-- Page content (End) -->
<%@ include file="footer.jsp" %>