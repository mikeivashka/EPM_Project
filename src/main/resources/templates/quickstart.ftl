<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <h1>Самое время выбрать диетолога</h1>
    <p class="lead">Выберите диетолога из списка профессионалов<br>
        работающих с нашими клиентами. Вы всегда сможете изменить свой выбор в профиле.
    </p>
</div>
    <table class="table table-responsive-md mt-5">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Опыт работы</th>
            <th scope="col">Рейтинг</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list nutritionists as nutr>
            <tr>
                <td>${nutr_index+1}</td>
                <td>${nutr.name}</td>
                <td>${nutr.surname}</td>
                <td>Работает с ${nutr.experience} года</td>
                <td>${nutr.rating}</td>
                <td>
                    <form method="post" action="/user/program/save">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="hidden" name="nutrId" value="${nutr.id}">
                        <button type="submit" class="btn btn-outline-primary">Выбрать</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>