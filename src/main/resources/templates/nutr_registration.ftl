<#import "parts/common.ftl" as c>
<@c.page>
    <h1>Регистрация нового диетолога</h1>
    <form action="/nutr/registration" class="form-row mt-3 justify-content-center" method="post">

        <div class="form-group col-4">
            <label for="email">Электронный адрес</label>
            <input type="email" name="email" id="email" class="form-control" required/>
        </div>
        <div class="w-100"></div>
        <div class="form-group col-4">
            <label for="pwd">Пароль</label>
            <input type="password" name="password" id="pwd" class="form-control" required/>
        </div>
        <div class="w-100"></div>
        <div class="form-group col-4">
            <label for="name">Имя </label>
            <input type="text" name="name" id="name" class="form-control" required/>
        </div>
        <div class="w-100"></div>
        <div class="form-group col-4">
            <label for="surname">Фамилия</label>
            <input type="text" name="surname" id="surname" class="form-control" required/>
        </div>
        <div class="w-100"></div>
        <div class="form-group col-4">
            <label>Ваш стаж (год начала работы)</label>
            <input type="number" required name="experience" class="form-control">
        </div>
        <div class="w-100"></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
    </form>
    <#if message??>
        <div class="container mt-1 border-warning">
            <h4 class="text-warning">${message}</h4>
        </div>
    </#if>
    <div class="container mt-3">
        <a href="/login">У меня уже есть аккаунт</a><br>
        <a href="/registration">Регистрация для пользователей</a>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</@c.page>