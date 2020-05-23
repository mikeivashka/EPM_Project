<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <h1>Ваши клиенты</h1>
        <p class="lead">
            Выберите клиента из списка и отправьте ему рекомендацию
        </p>
    </div>
    <table class="table table-responsive-md mt-5">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list clients as client>
            <tr>
                <td>${client_index+1}</td>
                <td>${client.name}</td>
                <td>${client.surname}</td>
                <td>
                    <form method="get" action="/nutr/recommendations/new">
                        <input type="hidden" name="clientId" value="${client.id}">
                        <button type="submit" class="btn btn-sm btn-outline-primary">Продолжить</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>