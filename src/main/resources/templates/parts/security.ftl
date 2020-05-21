<#assign
    known= Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        known = true
        name = user.getName()
        role = user.role
    >
    <#else>
        <#assign
        name = ""
        role = ""
        >
</#if>