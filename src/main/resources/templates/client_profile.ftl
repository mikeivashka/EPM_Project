<#import "parts/common.ftl" as c>
<@c.page>
    <h2>Ваш профиль</h2>
    <form method="post">
        <div class="form-row mt-5">
            <div class="col-md-6">
                <h4>Личные данные</h4>
                <div class="form-group mt-5">
                    <label for="exampleInputEmail1">Адрес электронной почты</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                           value="${user.email} " required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Пароль</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password"
                           value="${user.password}" required>
                </div>
                <div class="form-group">
                    <label for="name">Имя</label>
                    <input type="text" class="form-control" id="name" name="name" value="${user.name!''}" required>
                </div>
                <div class="w-100"></div>
                <div class="form-group">
                    <label for="surname">Фамилия</label>
                    <input type="text" class="form-control" id="surname" name="surname" value="${user.getSurname()!''}"
                           required>
                </div>
            </div>
            <div class="col-md-6">
                <h4>Информация для диетолога</h4>
                <div class="form-group mt-5">
                    <label for="age">Возраст</label>
                    <input type="number" class="form-control" id="age" name="age" value="${user.age!''}">
                </div>
                <div class="w-100"></div>
                <div class="form-group">
                    <label for="height">Рост, cм</label>
                    <input type="number" class="form-control" id="height" name="height" value="${user.height!''}">
                </div>
                <div class="w-100"></div>
                <div class="form-group">
                    <label for="weight">Вес, кг</label>
                    <input type="number" class="form-control" id="weight" step="0.1" name="weight"
                           value="${user.getWeight()}">
                </div>
                <div class="form-group">
                    <legend class="col-form-label pt-0">Уровень активности</legend>
                    <select class="form-control" name="activity">
                        <option value="NONE" <#if user.getActivityLevel().name()=="NONE">selected</#if> >
                            Отсутствует
                        </option>
                        <option value="SEDENTARY"
                                <#if user.getActivityLevel().name()=="SEDENTARY">selected</#if> >Веду сидячий образ
                            жизни
                        </option>
                        <option value="LIGHTLY_ACTIVE"
                                <#if user.getActivityLevel().name()=="LIGHTLY_ACTIVE">selected</#if> >Легкая физическая
                            активность
                        </option>
                        <option value="MODERATELY_ACTIVE"
                                <#if user.getActivityLevel().name()=="MODERATELY_ACTIVE">selected</#if> >Еженедельные
                            тренировки
                        </option>
                        <option value="VERY_ACTIVE"
                                <#if user.getActivityLevel().name()=="VERY_ACTIVE">selected</#if> >Тренируюсь более 3
                            раз в
                            неделю
                        </option>
                    </select>
                    <div class="form-group">
                        <legend class="col-form-label pt-0">Пол</legend>
                        <select class="form-control" name = "gender">
                            <option value="MALE" <#if user.getGender().name()=="MALE">selected</#if> >Мужской</option>
                            <option value="FEMALE" <#if user.getGender().name()=="FEMALE">selected</#if> >Женский</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="margin-top: 3%" class="btn btn-primary btn-lg btn-block">Сохранить</button>
        <#if message??>
            <div class="border-warning">
                <h4 class="text-warning">${message}</h4>
            </div>
        </#if>
    </form>
</@c.page>