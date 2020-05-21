<#import "parts/common.ftl" as c>
<@c.page>
<h1>Авторизируйтесь, чтобы продолжить пользоваться dietmanager</h1>
<form action="/login" method="post">
    <div><label>Email: <input type="email" name = "username"/></label></div>
    <div><label>Password <input type="password" name = "password"/></label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary" value="Sign In" style="margin-top: 10px">Войти</button>
</form>
<a href="/registration">Создать аккаунт</a>
</@c.page>