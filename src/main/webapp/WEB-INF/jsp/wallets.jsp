<% pageContext.setAttribute("activeTab", "wallets");  %>
<!-- Page header -->
<%@ include file="header.jsp" %>
<%@ include file="navbar-controll.jsp" %>
<!-- Page content -->

<div style="margin-top: 60px;" class="text-center">
<h3>Wallets List</h3>
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
        <th>WalletId</th>
        <th>Name</th>
        <th>Description</th>
        <th>Amount</th>
        <th>UserId</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${wallets}" var="wallet">
        <tr>
            <td>
                <c:out value="${wallet.walletid}" />
            </td>
            <td>
                <c:out value="${wallet.name}" />
            </td>
            <td>
                <c:out value="${wallet.description}" />
            </td>
            <td>
                <c:out value="${wallet.amount}" /> RON
            </td>
            <td>
                <c:out value="${wallet.user.userid}" />
            </td>
            <td><a href="<c:url value='/wallet/update?walletid=${wallet.walletid}'/>">Edit</a> | <a
                    href="<c:url value='/wallet/delete?walletid=${wallet.walletid}'/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Page footer -->
<%@ include file="footer.jsp" %>