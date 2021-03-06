<#import "../layout/base.ftl" as base>
<#import "/spring.ftl" as spring />

<@base.page>
<form class="form-signin" action="/account/login" method="post">
    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input id="email" name="email" class="form-control" placeholder="Email address" required="" autofocus="">
    <label for="email" class="sr-only">Password</label>
    <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
    <div class="checkbox">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <#if RequestParameters.error??>
        <p><@spring.message 'account.login.error'/></p>
    </#if>
</form>
</@base.page>