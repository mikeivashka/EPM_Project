<#import "parts/common.ftl" as c>
<@c.page>
    <h2>Ваш профиль</h2>
    <form method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="exampleInputEmail1">Адрес электронной почты</label>
                <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                       value="${user.email}">
            </div>

            <div class="form-group col-md-6">
                <label for="exampleInputPassword1">Пароль</label>
                <input type="password" class="form-control" id="exampleInputPassword1" name="password"
                       value="${user.password}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col">
                <label for="name">Имя</label>
                <input type="text" class="form-control" id="name" name="name" value="${user.name!''}">
            </div>
            <div class="form-group col">
                <label for="surname">Фамилия</label>
                <input type="text" class="form-control" id="surname" name="surname" value="${user.getSurname()!''}">
            </div>
        </div>
        <h3 style="padding-top: 5%">Информация для диетолога</h3>
        <div class="form-row">
            <div class="form-group col">
                <label for="age">Возраст</label>
                <input type="number" class="form-control" id="age" name="age" value="${user.age!''}">
            </div>
            <div class="form-group col">
                <label for="height">Рост, cм</label>
                <input type="number" class="form-control" id="height" name="height" value="${user.height!''}">
            </div>
            <div class="form-group col">
                <label for="weight">Вес, кг</label>
                <input type="number" class="form-control" id="weight" step="0.1" name="weight" value="${user.getWeight()}">
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-3">
                <div class="form-check">
                    <legend class="col-form-label pt-0">Пол</legend>
                    <input class="form-check-input" type="radio" name="gender" id="male" value="MALE"
                           <#if user.getGender().name()=="MALE">checked</#if>>
                    <label class="form-check-label" for="male">
                        Мужской
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="FEMALE"
                           <#if user.getGender().name()=="FEMALE">checked</#if>>
                    <label class="form-check-label" for="female">
                        Женский
                    </label>
                </div>
            </div>
            <div class="col-md-4">
                <legend class="col-form-label pt-0">Уровень вашей активности</legend>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="activity" id="none" value="NONE"
                           <#if user.getActivityLevel().name()=="NONE">checked</#if>>
                    <label class="form-check-label" for="none">
                        Отсутствует
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="activity" id="sedentary" value="SEDENTARY"
                           <#if user.getActivityLevel().name()=="SEDENTARY">checked</#if>>
                    <label class="form-check-label" for="sedentary">
                        Веду сидячий образ жизни
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="activity" id="lightly" value="LIGHTLY_ACTIVE"
                           <#if user.getActivityLevel().name()=="LIGHTLY_ACTIVE">checked</#if>>
                    <label class="form-check-label" for="lightly">
                        Легкая физическая активность, отсутствие физических нагрузок
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="activity" id="moderately"
                           value="MODERATELY_ACTIVE"
                           <#if user.getActivityLevel().name()=="MODERATELY_ACTIVE">checked</#if>>
                    <label class="form-check-label" for="moderately">
                        Тренируюсь 2-3 раза в неделю
                    </label>
                </div>
                <div>
                    <input class="form-check-input" type="radio" name="activity" id="very" value="VERY_ACTIVE"
                           <#if user.getActivityLevel().name()=="VERY_ACTIVE">checked</#if>>
                    <label class="form-check-label" for="very">
                        Веду активный образ жизни, занимаюсь более 3 раз в неделю
                    </label>
                </div>
            </div>
        </div>
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-lg btn-block">Сохранить</button>
        <#if message??>
            <h4 class="text-warning">${message}</h4>
        </#if>
    </form>
    </@c.page>