<#import "../layout/base.ftl" as base>
<@base.page>
Error occured due to <#if errorMessage??>${errorMessage}<#else>unknown reasons</#if>
</@base.page>