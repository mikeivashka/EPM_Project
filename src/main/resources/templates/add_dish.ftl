<#import "parts/common.ftl" as c>
<@c.page>
    <a href="/dishes">Вернуться к списку</a>
    <div class="container">
        <h1>Добавление блюда</h1>
        <p class="lead">Заполните все поля и отметьте продукты,<br>
            которые необходимо добавить в блюдо
        </p>
    </div>
    <form method="post" class="form-row mt-1 mb-5 justify-content-between">
        <div class="form-group col-md-3">
            <label for="exampleInputEmail1">Название</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="title"
                   value="${title!}" required>
        </div>

        <div class="form-group col-md-3">
            <label for="exampleInputPassword1">Калорийность готового блюда</label>
            <input type="number" class="form-control" id="exampleInputPassword1" name="calories"
                   value="${calories!} " required>
        </div>

        <div class="form-group col-md-3">
            <label for="link">Ссылка на рецепт</label>
            <input type="url" class="form-control" id="link" name="link" required value="${link!}">
        </div>
        </div>
        <div class="row justify-content-center">
            <legend class="col-form-label pt-0">Список продуктов<br><small>Зажмите CTRL и нажмите на продукт,чтобы выделить несколько</small></legend>
            <select style="width: 30%; height: 30%" multiple="multiple" class="form-control" size="10"
                    name="products[]" required>
                <#list products as prod>
                    <option value="${prod.id}">${prod.title}</option>
                </#list>
            </select>

            <div class="container">
                <#if success??>
                    <div class="container mt-1">
                        <h4 class="text-success">${success}, <a href="/dishes">вернуться к списку</a></h4>

                    </div>
                </#if>
                <#if failure??>
                    <div class="container mt-1 border-warning">
                        <h4 class="text-warning">${failure}</h4>
                    </div>
                </#if>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-block">Создать</button>
            </div>
        </div>
    </form>

</@c.page>