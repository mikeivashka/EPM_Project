<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <h1>Программа</h1>
        <p class="lead">
            Ваш диетолог - <b>${nutr.name} ${nutr.surname}
        </p>
        <form method="post" action="/user/program/unsubscribe">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-outline-danger">Отписаться</button>
        </form>
    </div>
    <div class="container">

    </div>
</@c.page>