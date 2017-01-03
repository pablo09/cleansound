<#macro page>
    <html>
        <#include "header.ftl">
        <body>
            <#include "navbar.ftl">
            <div class="container">
                <#nested>
            </div>
        </body>
        <#include "footer.ftl">
    </html>
</#macro>