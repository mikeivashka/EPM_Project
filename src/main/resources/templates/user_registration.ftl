<#import "parts/common.ftl" as c>
<@c.page>
<h1>Регистрация нового пользователя</h1>
<form action="/registration" method="post" >
    <div><label>Электронный адрес: <input type="email" name = "email"required/></label></div>
    <div><label>Пароль <input type="password" name = "password" required/></label></div>
    <div><label>Имя <input type="text" name = "name" required/></label></div>
    <div><label>Фамилия <input type="text" name = "surname" required/></label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button id = "validate" type="submit" class="btn btn-primary" value="Sign In" style="margin-top: 10px">Зарегистрироваться</button>
</form>
    <#if message??>${message}</#if>
<a href="/login">У меня уже есть аккаунт</a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</@c.page>