<#import "parts/common.ftl" as c>
<@c.page>
    <div class="row align-items-center">
        <div class="text-center col-md-8 col-md-offset-2">
        <h2>Список пользователей сервиса</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Role</th>
                <th>Created</th>
                <th>IsActive</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.role}</td>
                    <td>${user.createdOn}</td>
                    <td>
                        <form method="post">
                            <input type="checkbox" name = "active" value="active" <#if user.active>checked</#if> />
                            <input type="hidden" name = "id" value=${user.id} />
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <input type="hidden" name="role" value="${user.role}">
                            <button class="btn btn-danger btn-sm" type="submit">Подтвердить</button>
                        </form>

                    </td>
                </tr>
            </#list>
            </tbody>

        </table>
        </div>
    </div>
</@c.page>