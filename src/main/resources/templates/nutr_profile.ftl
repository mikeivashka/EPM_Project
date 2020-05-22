<#import "parts/common.ftl" as c>
<@c.page>
    <h2>Ваш профиль</h2>
    <form method="post">
        <div class="container">
            <p>Ваш текущий рейтинг: ${user.rating}</p>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="exampleInputEmail1">Адрес электронной почты</label>
                <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                       value="${user.email}">
            </div>

            <div class="form-group col-md-6">
                <label for="exampleInputPassword1">Пароль</label>
                <input type="text" class="form-control" id="exampleInputPassword1" name="password"
                       value="${user.password}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col">
                <label for="name">Имя</label>
                <input type="text" class="form-control" id="name" name="name" value="${user.name!''}">
            </div>
            <div class="form-group col">
                <label for="surname">Фамилия</label>
                <input type="text" class="form-control" id="surname" name="surname" value="${user.getSurname()!''}">
            </div>
        </div>
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-lg btn-block">Сохранить</button>
        <#if message??>
            <h4 class="text-warning">${message}</h4>
        </#if>
    </form>
</@c.page>