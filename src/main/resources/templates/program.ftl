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
    <div class="container text-center mt-5">
    <#list recommendations as rec>
        <div class="border-bottom row justify-content-around text-center">
            <p class="text-muted">
                Рекомендация от ${rec.date}
            </p>
            <div class="col-md-3">
                <h3></h3>
            </div>
        </div>
    </#list>
    </div>
    </div>
    <div class="container">

    </div>
</@c.page>