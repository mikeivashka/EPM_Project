<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <h1>Список доступных блюд</h1>
        <p class="lead">Фильтры</p>
    </div>

    <form method="get" class="form-row mt-1 mb-5 justify-content-between" >
        <div class="form-group col-md-3">
            <label for="exampleInputEmail1">Название</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="dish_name_filter"
                   value="">
        </div>

        <div class="form-group col-md-3">
            <label for="exampleInputPassword1">Минимальная калорийность</label>
            <input type="number" class="form-control" id="exampleInputPassword1" name="minCalories"
                   value="0">
        </div>

        <div class="form-group col-md-3">
            <label for="exampleInputPassword1">Максимальная калорийность</label>
            <input type="number" class="form-control" id="exampleInputPassword1" name="maxCalories"
                   value="10000">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-block">Выбрать</button>
    </form>
    <table class="table table-responsive-md mt-5">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Ссылка на рецепт</th>
            <th scope="col">Калорийность</th>
            <th scope="col">Ингридиенты</th>

        </tr>
        </thead>
        <tbody>
        <#list dishes as dish>
            <tr>
                <td>${dish.title}</td>
                <td><a href="${dish.recepyLink}">${dish.recepyLink}</a></td>
                <td>${dish.caloriesCapacity}</td>
                <td><#list dish.ingredients as ingr>${ingr.title}<#sep><br></#list></td>
            </tr>
        </#list>
        </tbody>
    </table>

    <div class="container mt-5">
        <h1>Список доступных продуктов</h1>
        <p class="lead">Фильтры</p>
    </div>
    <form method="get" class="form-row mt-1 justify-content-center">
        <div class="form-group col-md-3">
            <label for="exampleInputEmail1">Название</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="prod_filter"
                   value="${prod_filter}">
        </div>
        <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-block">Выбрать</button>
    </form>
    <table class="table table-responsive-md mt-5">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Калорийность</th>

        </tr>
        </thead>
        <tbody>
        <#list products as prod>
            <tr>
                <td>${prod.title}</td>
                <td>${prod.caloriesCapacity}</td>
            </tr>
        </#list>
        </tbody>
    </table>
    <div class="container">
        <a href="/dishes/add/product">Добавить свой продукт...</a>
    </div>
    <#if message??>
        <h4 class="text-warning">${message}</h4>
    </#if>

</@c.page>