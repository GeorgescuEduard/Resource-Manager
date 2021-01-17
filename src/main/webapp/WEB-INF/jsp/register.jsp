<% pageContext.setAttribute("activeTab", "users"); %>
<!-- Page header -->
<%@ include file="header.jsp" %>

<!-- Page content -->
<div class="container-fluid">
    <div class="row no-gutter">
        <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
        <div class="col-md-8 col-lg-6">
            <div class="login d-flex align-items-center py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9 col-lg-8 mx-auto">
                            <h2 class="login-heading text-center" style="margin-bottom: 5%;"><b>Internet Banking</b>
                            </h2>
                            <h3 class="login-heading mb-4">Sign In</h3>
                            <form:form method="post" action="/register/add" modelAttribute="user">
                                <div class="row">
                                    <spring:bind path="userid">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </spring:bind>
                                    <div class="input-group">
                                        <div class="col-6">
                                            <spring:bind path="firstname">
                                                <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                                    <form:input name="firstname" type="text" path="firstname"
                                                                id="firstname" placeholder="First name"
                                                                class="form-control input-sm"/>
                                                    <form:errors path="firstname" cssStyle="help-inline"/>
                                                    <label for="firstname">First name</label>
                                                </div>
                                            </spring:bind>
                                        </div>
                                        <div class="col-6">
                                            <spring:bind path="lastname">
                                                <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                                    <form:input name="lastname" type="text" path="lastname"
                                                                id="lastname" placeholder="Last name"
                                                                class="form-control input-sm"/>
                                                    <form:errors path="lastname" cssStyle="help-inline"/>
                                                    <label for="lastname">Last name</label>
                                                </div>
                                            </spring:bind>
                                        </div>
                                    </div>
                                </div>
                                <spring:bind path="username">
                                    <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                        <form:input name="username" type="text" path="username" id="username"
                                                    placeholder="Username" class="form-control input-sm"/>
                                        <form:errors path="username" cssStyle="help-inline"/>
                                        <label for="username">Username</label>
                                    </div>
                                </spring:bind>
                                <spring:bind path="email">
                                    <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                        <form:input name="email" type="text" path="email" placeholder="Email" id="email"
                                                    class="form-control input-sm"/>
                                        <form:errors path="email" cssStyle="help-inline"/>
                                        <label for="email">Email</label>
                                    </div>
                                </spring:bind>
                                <spring:bind path="password">
                                    <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                        <form:password name="password" path="password" id="password"
                                                       placeholder="Password" class="form-control input-sm"/>
                                        <form:errors path="password" cssStyle="help-inline"/>
                                        <label for="password">Password</label>
                                    </div>
                                </spring:bind>
                                <div class="d-flex justify-content-center">
                                <button type="submit"
                                        class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2">
                                    Create Account
                                </button>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="http://localhost:8080/login">Already have an account?</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>