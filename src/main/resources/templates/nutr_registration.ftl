<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Регистрация нового диетолога</h1>
    <form action="/nutr/registration" method="post">

        <div class="form-group"><label>Электронный адрес: <input type="email" name="email" required/></label></div>
        <div class="form-group"><label>Пароль <input type="password" name="password" required/></label></div>
        <div class="form-group"><label>Имя <input type="text" name="name" required/></label></div>
        <div class="form-group"><label>Фамилия <input type="text" name="surname" required/></label></div>
        <div class="form-group"><label>С какого года вы работаете диетологом?<input type="number" required
                                                                                    name="experience"></label></div>
        <div class="form-group"><input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary" style="margin-top: 10px">Зарегистрироваться</button>
    </form>
    <#if message??>${message}<br></#if>
    <a href="/login">У меня уже есть аккаунт</a>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</@c.page>