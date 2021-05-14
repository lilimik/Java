<#import "header.ftlh" as h>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

    <@h.head_files>
    </@h.head_files>

    <link rel="stylesheet" href="/css/root.css">
    <link rel="stylesheet" href="/css/auth.css"/>

</head>
<body>

<@h.header>
</@h.header>

<@h.content>
    <div class="container mt-5" style="margin-top: 100px">
        <div class="row">

            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal pb-1" data-toggle="validator"
                      action="/signUp" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                    <span class="heading">РЕГИСТРАЦИЯ</span>
                    <div class="form-group">
                        <label for="inputEmail"></label><input type="email" name="email" class="form-control"
                                                               id="inputEmail" placeholder="Почта"
                                                               data-error="Вы не правильно ввели Ваш E-mail" required>
                        <i class="fa fa-envelope-open"></i>
                        <a href="#" class="fa fa-exclamation-circle"></a>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group">
                        <label for="inputFirstName"></label><input type="text" class="form-control" name="firstName"
                                                                   id="inputFirstName" placeholder="Имя"
                                                                   data-error="Вы не ввели ваше имя">
                        <i class="fa fa-wheelchair"></i>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group">
                        <label for="inputLastName"></label><input type="text" class="form-control" name="lastName"
                                                                  id="inputLastName" placeholder="Фамилия"
                                                                  data-error="Вы не ввели вашу Фамилию">
                        <i class="fa fa-wheelchair-alt"></i>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group">
                        <label for="inputPhone"></label><input type="number" class="form-control" name="phone"
                                                               id="inputPhone" placeholder="Телефон"
                                                               maxlength="11" minlength="4"
                                                               data-error="Вы не ввели ваш телефон">
                        <i class="fa fa-phone-alt"></i>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group help">
                        <label for="inputPassword"></label><input type="password" data-toggle="validator"
                                                                  data-minlength="6"
                                                                  class="form-control"
                                                                  name="password1" id="inputPassword"
                                                                  placeholder="Пароль" required>
                        <span class="help-block text-dark">Минимум 6 символов</span>
                        <i class="fa fa-lock"></i>
                        <a href="#" class="fa fa-exclamation-circle"></a>
                    </div>
                    <div class="form-group help">
                        <label for="inputPasswordConfirm"></label><input type="password" class="form-control"
                                                                         name="password2" id="inputPasswordConfirm"
                                                                         data-match="#inputPassword"
                                                                         placeholder="Повторите пароль"
                                                                         data-match-error="Пароли не совпадают!"
                                                                         required>
                        <div class="help-block with-errors"></div>
                        <i class="fa fa-lock"></i>
                        <a href="#" class="fa fa-exclamation-circle"></a>
                    </div>
                    <div class="form-group">
                        <div class="main-checkbox">
                            <input type="checkbox" id="checkbox1" data-error="Обязательно!" name="check" required>
                            <label for="checkbox1"></label>
                            <div class="help-block with-errors"></div>
                        </div>
                        <span class="text">Докажите, что Вы человек</span>
                        <button type="submit" class="btn btn-default">РЕГИСТРАЦИЯ</button>
                    </div>
                    <div class="form-group text-center">
                        <a class="text-dark" href="/signIn"><b>Уже есть аккант?</b></a>
                    </div>
                </form>
            </div>

        </div>
    </div>
</@h.content>

</body>
</html>