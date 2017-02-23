<nav class="navbar navbar-static-top navbar-light bg-faded">
    <a href="#" class="navbar-brand">CleanSound</a>
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Tunes</a>
        </li>
    </ul>

    <ul class="nav navbar-nav float-xs-right">
        <#if navbarUser??>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   <a href="account/info">${navbarUser.username}</a>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <form action="/account/logout" method="post">
                        <button class="dropdown-item">Logout</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        <#else>
            <li class="nav-item">
                <a class="nav-link" href="/account/login">Sign in</a>
            </li>
        </#if>

    </ul>


</nav>