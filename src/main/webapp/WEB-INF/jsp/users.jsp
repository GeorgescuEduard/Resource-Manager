<% pageContext.setAttribute("activeTab", "users");  %>
<% pageContext.setAttribute("activeTab", "loggedUser");  %>
<!-- Page header -->
<%@ include file="header.jsp" %>
<%@ include file="navbar-controll.jsp" %>
    <!-- Page content -->

<div style="margin-top: 60px;" class="text-center">
    <h3>Users List</h3>
</div>
    <c:if test="${not empty message}">
        <div class="alert alert-success alert-dismissable">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            ${message}
        </div>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger alert-dismissable">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            ${errorMessage}
        </div>
    </c:if>

    <table class="table">
        <thead>
            <tr>
                <th>Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Username</th>
                <th>Email</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>
                        <c:out value="${user.userid}" />
                    </td>
                    <td>
                        <c:out value="${user.firstname}" />
                    </td>
                    <td>
                        <c:out value="${user.lastname}" />
                    </td>
                    <td>
                        <c:out value="${user.username}" />
                    </td>
                    <td>
                        <c:out value="${user.email}" />
                    </td>
                    <td><a href="<c:url value='/user/update?userid=${user.userid}'/>">Edit</a> | <a
                            href="<c:url value='/user/delete?userid=${user.userid}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Page footer -->
    <%@ include file="footer.jsp" %>