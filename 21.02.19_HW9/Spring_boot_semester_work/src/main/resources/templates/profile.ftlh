<#import "header.ftlh" as h>
<!doctype html>
<html lang="en">
<head>
    <title>Profile</title>

    <link rel="SHORTCUT ICON" href="/image/main_image.png">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <script src="https://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2016/validator/validator.min.js"></script>

    <@h.head_files>
    </@h.head_files>

    <link rel="stylesheet" href="/css/profile.css"/>
    <link rel="stylesheet" href="/css/root.css"/>
    <script src="/js/files.js"></script>
    <script src="/js/avatar_update.js"></script>


</head>
<body>

<@h.header>
</@h.header>

<@h.content>
    <div class="container mb-5" style="margin-top: 50px">
        <div id="main">

            <div class="row" id="real-estates-detail">
                <div class="col-lg-4 col-md-4 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <header class="panel-title">
                                <div class="text-center">
                                    <strong>Пользователь сайта</strong>
                                </div>
                            </header>
                        </div>
                        <div class="panel-body">
                            <div class="text-center" id="author">
                                <img src="/files/${user.avatarStorageName}"
                                     alt="avatar" style="width: 245px; height: 245px">

<#--                                <div id="photo" style="width: 245px; height: 245px"></div>-->

                                <h3>${user.getFirstName()} ${user.getLastName()}</h3>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-8 col-md-8 col-xs-12">
                    <div class="panel">
                        <div class="panel-body">
                            <ul id="myTab" class="nav nav-pills">
                                <li class="active"><a href="#detail" data-toggle="tab">О пользователе</a></li>
                                <li class=""><a href="#reviews" data-toggle="tab">Отзывы</a></li>
                                <li class=""><a href="#editing" data-toggle="tab">Редактировать</a></li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <hr>
                                <div class="tab-pane fade active in" id="detail">
                                    <h4 class="text-center"><strong>Профиль</strong></h4>
                                    <br>
                                    <table class="table table-th-block">
                                        <tbody>
                                        <tr>
                                            <td class="active">id:</td>
                                            <td>${user.getId()}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="active">Имя:</td>
                                            <td>${user.getFirstName()}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="active">Фамилия:</td>
                                            <td>${user.getLastName()}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="active">email:</td>
                                            <td>${user.getEmail()}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="active">Статус:</td>
                                            <td>
                                                <#if user.isConfirmed()>
                                                    Подтвержден
                                                <#else>
                                                    Не подтвержден
                                                </#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="active">Состояние:</td>
                                            <td>
                                                <#if user.isActive()>
                                                    Аккаунт активен
                                                <#elseif user.isBanned()>
                                                    Аккаунт забанен
                                                </#if>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>


                                <div class="tab-pane fade" id="reviews">
                                    <h4 class="text-center"><strong>Отзывы</strong></h4>
                                    <br>

                                    <br><br>
                                </div>

                                <div class="tab-pane fade" id="editing">
                                    <h4 class="text-center"><strong>Редактирование</strong></h4>
                                    <br>

                                    <div class="container col-12 row mb-5">
                                        <div class=" container col-8 pr-5">
                                            <input type="file" multiple='multiple' id="file" name="file"
                                                   placeholder="Имя файла..."/>
                                        </div>
                                        <div class="container col-2">
                                            <button onclick="sendFile()"
                                                    class="btn btn-outline-primary shadow p-2 rounded">
                                                Загрузить файл
                                            </button>
                                            <input type="hidden" id="file_hidden">
                                            <div class="filename"></div>
                                        </div>
                                    </div>

                                    <form
<#--                                            action="/profile?userForm" -->
                                            action="/profile"
                                            method="post"
                                          data-toggle="validator">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                        <input type="hidden" name="userId" value="${user.getId()}">
                                        <div class="form-group row">
                                            <label for="firstName" class="col-sm-2 col-form-label">Имя</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="firstName" name="firstName"
                                                       value="${user.getFirstName()}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="lastName" class="col-sm-2 col-form-label">Фамилия</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="lastName" name="lastName"
                                                       value="${user.getLastName()}">
                                            </div>
                                        </div>
                                        <div class="form-group row help">
                                            <label for="inputPassword" class="col-sm-2 col-form-label">Пароль</label>
                                            <div class="col-sm-5">
                                                <input type="password" data-toggle="validator" data-minlength="6"
                                                       class="form-control"
                                                       name="password1" id="inputPassword"
                                                       placeholder="Пароль">
                                                <span class="help-block text-dark">Минимум 6 символов</span>
                                            </div>
                                            <label for="inputPasswordConfirm"></label>
                                            <div class="col-sm-5">
                                                <input type="password" class="form-control"
                                                       name="password2" id="inputPasswordConfirm"
                                                       data-match="#inputPassword"
                                                       placeholder="Повторите пароль"
                                                       data-match-error="Пароли не совпадают!">
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-outline-primary shadow p-2 rounded">
                                            Сохранить
                                        </button>
                                    </form>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</@h.content>

</body>
</html>