<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">
<@c.page>
    <div>
        <h2 class="mt-3">Добро пожаловать в систему DietManager!</h2>
        <#if !known>
            <div class="container">
                <p>
                    <a href="/login">Войдите в систему</a> или
                    <a href="/registration">зарегистрируйтесь</a><br>
                    чтобы продолжить пользоваться сервисом
                </p>
            </div>
        </#if>
        <a href="/management/activities">Manage activities</a>
    </div>
</@c.page>