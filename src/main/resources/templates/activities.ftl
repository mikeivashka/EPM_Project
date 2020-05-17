<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <@l.logout/>
    <div class="container" style="text-align: center">
        <h1>Управление тренировками</h1>
        <p class="lead">Сервис для управления базой тренировок</p>
    </div>
    <div class="container">
        <div class="row row-centered" style="padding-top: 5%">
            <div class="col-md-4" style="padding-left: 10%;">
                <form method="post">
                    <h3>Форма добавления новой тренировки</h3>
                    <p><input name="type" type="radio" value="POWER" placeholder="Силовая тренировка">Силовая тренировка
                    </p>
                    <p><input name="type" type="radio" value="CARDIO" placeholder="Кардио-тренировка">Кардио-тренировка
                    </p>
                    <p><input name="type" type="radio" value="OTHER" placeholder="Другое" checked="checked">Другое</p>
                    <br>
                    <input name="link" type="url" placeholder="https://example.com" pattern="https://.*">
                    <br>
                    <input name="description" type="text" placeholder="Введите описание тренировки здесь">
                    <br>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary" style="margin-top: 10px">Добавить</button>
                </form>
            </div>
            <div class="col-md-4">
                <h3>Список доступных тренировок</h3>
                <#list activities as activity>
                <div>
                    <p>Id: ${activity.id}</p>
                    <p>${activity.type}</p>
                    <a href="${activity.link}">Ссылка на тренировку</a>
                    <p>${activity.description}</p>
                </div>
                </#list>
            </div>
            <div class="col-md-4">
                <h3>Отфильтровать по типу</h3>
                <form method="get">
                    <p><input type="radio" name="filter" value="POWER"/>Силовая</p>
                    <p><input type="radio" name="filter" value="CARDIO"/>Кардио</p>
                    <p><input type="radio" name="filter" value="OTHER"/>Другое</p>
                    <button type="submit" class="btn btn-primary">Выбрать</button>
                </form>
                <form method="get">
                    <button type="submit" class="btn btn-light">Отмена</button>
                </form>
            </div>
        </div>
    </div>
</@c.page>