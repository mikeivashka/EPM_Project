<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <h1>Новая рекомендация для: ${client.name}</h1>
        <p class="lead">
            Выберите блюда и тренировку на сегодня
        </p>
        <form method="post" action="/nutr/recommendations/new" class="form-row mt-3 mb-5 justify-content-between">
            <div class="form-group col-md-4">
                <p class="title">Сообщение для вашего клиента<br><small>Будьте вежливы и приветливы со своими клиентами</small></p>
                <textarea class="w-100" name="comment" type="text" placeholder="Оставьте сообщение для клиента"></textarea>
            </div>
            <div class="form-group col-md-4">
                <p>Список блюд<br><small>Зажмите CTRL и нажмите на блюдо,чтобы выделить</small></p>
                <select multiple="multiple" class="form-control w-100" size="10"
                        name="dishesId[]" required>
                    <#list dishes as dish>
                        <option value="${dish.id}">${dish.title}(${dish.caloriesCapacity} ккал)</option>
                    </#list>
                </select>
            </div>
            <div class="form-group col-md-4">
                <p>Тренировки<br><small>Выберите тренировку дня</small></p>
                <select  class="form-control w-100" size="10"
                        name="activity" required>
                    <#list activities as activity>
                        <option value="${activity.id}">${activity.description}(<a href="${activity.link}">ссылка</a>)</option>
                    </#list>
                </select>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="clientId" value="${client.id}">
            <button type="submit" class="btn btn-block btn-primary" style="margin-top: 10px">Отправить</button>
        </form>
    </div>
</@c.page>