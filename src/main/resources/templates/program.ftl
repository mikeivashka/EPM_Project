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
    <div class="container mt-2">
        <table class="table table-bordered">
            <thead style="background-color: rgba(209, 231, 254, 1)">
            <tr>
                <th scope="col">Дата</th>
                <th scope="col">Сообщение</th>
                <th scope="col">Информация о тренировке</th>
                <th scope="col">Набор блюд на день</th>
            </tr>
            </thead>
            <#list recommendations as recommendation>
                <tr>
                    <td><#if recommendation.getDate()??>${recommendation.getDate()}</#if></td>
                    <td><#if recommendation.getText()??>${recommendation.getText()}</#if></td>
                    <td>
                        <#if recommendation.getActivity()??>
                            <ul>
                                <li>Тип: ${recommendation.getActivity().type.rus()}</li>
                                <li>Описание: ${recommendation.getActivity().description}</li>
                                <li>
                                    <a target="_blank" href=" ${recommendation.getActivity().link}">
                                    Нажмите для перехода
                                    </a>
                                </li>
                            </ul></#if>
                    </td>
                    <td>
                        <ol><#list recommendation.getDishes() as dish>
                            <li>${dish.title}(<a target="_blank" href="${dish.recepyLink}">Перейти к рецепту</a>),</li>
                        </#list>
                        </ol>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</@c.page>