<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div>
        <@l.logout/>
        <h2 class="mt-3">Добро пожаловать в систему DietManager!</h2>
        <a href="/login">Sign in</a><br>
        <a href="/management/activities">Manage activities</a>
    </div>
</@c.page>