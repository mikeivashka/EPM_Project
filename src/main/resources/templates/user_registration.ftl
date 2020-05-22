<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Регистрация нового пользователя</h1>
    <form action="/registration" method="post">
        <div class="form-group"><label>Электронный адрес: <input type="email" name="email" required/></label></div>
        <div class="form-group"><label>Пароль <input type="password" name="password" required/></label></div>
        <div class="form-group"><label>Имя <input type="text" name="name" required/></label></div>
        <div class="form-group"><label>Фамилия <input type="text" name="surname" required/></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button id="validate" type="submit" class="btn btn-primary" value="Sign In" style="margin-top: 10px">
            Зарегистрироваться
        </button>
    </form>
    <#if message??>${message}<br></#if>
    <a href="/login">У меня уже есть аккаунт</a>
    <a href="/nutr/registration">Регистрация для диетологов</a>
</@c.page>