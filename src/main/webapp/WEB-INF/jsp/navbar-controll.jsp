<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: rgb(33,153,232)">
    <a class="navbar-brand text-white">Internet Banking</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:if test="${pageContext.request.requestURI.endsWith('/wallets.jsp')}">
            <li class="nav-item" >
                <a class="nav-link text-white btn btn-success" href="<c:url value='/wallet/add'/>"> Add Wallet</a>
            </li>
            </c:if>
            <c:if test="${pageContext.request.requestURI.endsWith('/users.jsp')}">
                <li class="nav-item" >
                    <a class="nav-link text-white btn btn-success" href="<c:url value='/register'/>"> Add Users</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.requestURI.endsWith('/transaction.jsp')}">
                <li class="nav-item" >
                    <a class="nav-link text-white btn btn-success" href="<c:url value='/transaction/add'/>"> Add Transaction</a>
                </li>
            </c:if>
            <li class="nav-item" >
                <a class="nav-link text-white" href="<c:url value='/wallets'/>">Wallets</a>
            </li>
            <li class="nav-item" >
                <a class="nav-link text-white" href="<c:url value='/users'/>">Users</a>
            </li>
            <li class="nav-item" >
                <a class="nav-link text-white" href="<c:url value='/transactions'/>">Transactions</a>
            </li>
        </ul>
    </div>
</nav>
