<#import "parts/common.ftl" as c>
<@c.page>
    <div class="container">
        <h1>Добавление продукта</h1>
    </div>
    <form method="post" class="form-row mt-1 justify-content-center">
        <div class="form-group col-md-3">
            <label for="exampleInputEmail1">Название</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="title"
                   value="">
        </div>
        <div class="form-group col-md-3">
            <label for="exampleInputEmail1">Калорийность</label>
            <input type="number" class="form-control" id="exampleInputEmail1" name="calories"
                   value="">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-sm">Создать</button>
    </form>
    <#if success??>
    <div class="container">
        <h4 class="text-success">${success}</h4>
    </div>
    </#if>
    <#if failure??>
        <div class="container">
            <h4 class="text-warning">${failure}</h4>
        </div>
    </#if>
</@c.page>