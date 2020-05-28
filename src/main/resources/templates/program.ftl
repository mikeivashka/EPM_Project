<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <h1>Программа</h1>
        <p class="lead">
            Ваш диетолог - <b>${nutr.name} ${nutr.surname}</b>
        </p>
        <form method="post" action="/user/program/unsubscribe">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" class="btn btn-outline-danger">Отписаться</button>
        </form>
    </div>
    <div class="container-fluid text-center mt-5">
        <#list recommendations as rec>
            <p class="text-muted mt-5">
                Рекомендация от <b>${rec.date}</b>, автор - ${rec.author.name} ${rec.author.surname}
            </p>
            <div class="row justify-content-start text-center bg-light rounded pt-3 pb-3 border">
                <div class="col-md-3">
                    <h4>Сообщение</h4>
                    <p>
                        <#if rec.text != "">
                            ${rec.text}
                        <#else>
                            Нет
                        </#if>
                    </p>
                </div>
                <div class="col-md-6 border-left border-right">
                    <h3>Питание</h3>
                    <table class="table table-responsive-md mt-1">
                        <thead>
                        <tr>
                            <th scope="col">Название блюда</th>
                            <!--<th scope="col">Ингридиенты</th>-->
                            <th scope="col">Ссылка на рецепт</th>
                            <th scope="col">Калорийность</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list rec.dishes as dish>
                            <tr>
                                <td>${dish.title}</td>
                                <!--<td>
                                    <#list dish.ingredients as ingr>
                                        ${ingr.title}<#sep><br></#sep>
                                    </#list>
                                </td>-->
                                <td><a href="${dish.recepyLink}">Рецепт</a></td>
                                <td>${dish.caloriesCapacity}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-3">
                    <h3>Тренировка</h3>
                    <p><b>Тренировка дня</b> - ${rec.activity.type.rus()}</p>
                    <p><b>Cсылка на комплекс</b> - <a href="${rec.activity.link}">ссылка</a></p>
                    <p><b>Описание</b></p>
                    <p style="text-align: left">
                        ${rec.activity.description}
                    </p>

                </div>
            </div>
        </#list>
    </div>
    </div>
    <div class="container">

    </div>
</@c.page>