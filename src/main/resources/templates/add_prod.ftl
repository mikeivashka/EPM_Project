<#import "parts/common.ftl" as c>
<@c.page>
    <a href="/dishes">Вернуться к списку</a>
    <div class="container">
        <h1>Добавление продукта</h1>
    </div>
    <form method="post">
        <div class="form-row mt-3 justify-content-center">
            <div class="form-group col-md-3">
                <label for="exampleInputEmail1">Название</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="title"
                       value="" required>
            </div>
            <div class="form-group col-md-3">
                <label for="exampleInputEmail1">Калорийность</label>
                <input type="number" class="form-control" id="exampleInputEmail1" name="calories"
                       value="" required>
            </div>
        </div>
        <div class="form-row justify-content-center">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-lg">Создать</button>
        </div>
    </form>
    <#if success??>
        <div class="container mt-1">
            <h4 class="text-success">${success}</h4>
        </div>
    </#if>
    <#if failure??>
        <div class="container mt-1 border-warning">
            <h4 class="text-warning">${failure}</h4>
        </div>
    </#if>
</@c.page>