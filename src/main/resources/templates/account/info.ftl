<#import "../layout/base.ftl" as base>
<#import "/spring.ftl" as spring />

<@base.page>
<form action="/account/update" method="post">
    <table>
        <tbody>
            <tr>
                <td><@spring.message 'account.info.name'/>/td>
                <td><@spring.formInput path="user.email"/></td>
            </tr>
            <tr>
                <td><@spring.message 'account.info.active'/></td>
                <td><@spring.formCheckbox path="user.active"/></td>
            </tr>
        </tbody>
    </table>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>
</@base.page>