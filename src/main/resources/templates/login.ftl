<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Авторизируйтесь, чтобы продолжить пользоваться DietManager</h1>
    <form action="/login" method="post" class="form-row mt-3 justify-content-center">
        <div class="form-group col-md-3">
            <label for="email">Электронный адрес</label>
            <input type="email" id="email" name="username" class="form-control"/>
        </div>
        <div class="w-100"></div>
        <div class="form-group col-md-3">
            <label for="pwd">Пароль</label>
            <input type="password" name="password" id="pwd" class="form-control"/>
        </div>
        <div class="w-100"></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary" value="Sign In" style="margin-top: 10px">Войти</button>
    </form>
    <div class="container mt-5">
        <a href="/registration">Создать аккаунт</a>
    </div>
    <#if RequestParameters.error??>
        <div class="container mt-1 border-warning">
            <h4 class="text-warning">Проверьте введенные данные</h4>
        </div>
    </#if>
</@c.page>