<#include "security.ftl">
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">Diet Manаger<br></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <#if known>
                <#if role!="ADMIN">
                    <li class="nav-item">
                        <a class="nav-link" href="/user/profile">Профиль</a>
                    </li>
                </#if>
                <#if role=="CLIENT">
                    <li class="nav-item">
                        <a class="nav-link" href="/user/program">Мой диетолог</a>
                    </li>
                </#if>
                <#if role != "CLIENT">
                    <#if role == "ADMIN">
                    <li class="nav-item">
                        <a class="nav-link" href="/user">Управление пользователями</a>
                    </li>
                    </#if>
                    <li class="nav-item">
                        <a class="nav-link" href="activities">Тренировки</a>
                    </li>
                </#if>
            </#if>
            </ul>
            <#if known>
                <div class="dropdown">
                    <button class="btn dropdown-toggle" style="background-color:transparent" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        ${name}
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <#if user.role!="ADMIN">
                        <li>
                            <form action="/user/profile" method="get">
                                <input class="btn"  style="background-color:transparent" type="submit" value="Профиль">
                            </form>
                        </li>
                        </#if>
                        <li role="separator" class="divider"></li>
                        <li>
                            <form action="/logout" method="post">
                                <input class="btn" style="background-color:transparent" type="submit" value="Выход">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </form>
                        </li>
                    </ul>
                </div>
            <#else >
                <form action="/login" method="get">
                    <input class="btn btn-light " type="submit" value="Войти"/>
                </form>
            </#if>

        </div>
    </nav>
</header>