<% pageContext.setAttribute("activeTab", "users"); %>
<!-- Page header -->
<%@ include file="header.jsp" %>
<!-- Page content (Begin) -->

<div class="container-fluid">
    <div class="row no-gutter">
        <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
        <div class="col-md-8 col-lg-6">
            <div class="login d-flex align-items-center py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-9 col-lg-8 mx-auto">
                            <h2 class="login-heading text-center" style="margin-bottom: 35%;"><b>Internet Banking</b>
                            </h2>
                            <h3 class="login-heading mb-4">Welcome back</h3>
                            <form:form method="post" modelAttribute="user" action="/login/user?username=${user.username}">
                                <spring:bind path="username">
                                    <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                        <form:input name="username" type="text" path="username" id="username"
                                                    placeholder="Username" class="form-control input-sm"/>
                                        <form:errors path="username" cssStyle="help-inline"/>
                                        <label for="username">Username</label>
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
                                    Log in
                                </button>
                            </div>
                                <div class="text-center">
                                    <a class="small" href="http://localhost:8080/register">Don't have an account?</a>
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