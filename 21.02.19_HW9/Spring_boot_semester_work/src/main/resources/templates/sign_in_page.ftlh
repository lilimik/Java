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

    <link rel="stylesheet" href="/css/auth.css"/>
    <link rel="stylesheet" href="/css/root.css"/>

</head>
<body>

<@h.header>
</@h.header>

<@h.content>
    <div class="container mt-5" style="margin-top: 100px">
        <div class="row">

            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal pb-1" data-toggle="validator"
                      action="/signIn" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                    <span class="heading">Авторизация</span>
                    <div class="form-group">
                        <label for="inputEmail"></label><input type="email" name="email" class="form-control"
                                                               id="inputEmail" placeholder="Почта"
                                                               data-error="Вы не правильно ввели Ваш E-mail"
                                                               required>
                        <i class="fa fa-envelope-open"></i>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="form-group help">
                        <label for="inputPassword"></label><input type="password" data-toggle="validator"
                                                                  data-minlength="6"
                                                                  class="form-control"
                                                                  name="password" id="inputPassword"
                                                                  placeholder="Пароль" required>
                        <i class="fa fa-lock"></i>
                        <a href="#" class="fa fa-exclamation-circle"></a>
                    </div>
                    <div class="form-group">
                        <div class="main-checkbox row">
                            <input type="checkbox" id="checkbox1" name="remember-me">
                            <label for="checkbox1"><span class="text ml-5">Запомнить</span></label>
                        </div>
                        <button type="submit" class="btn btn-default">войти</button>
                    </div>
                    <div class="form-group text-center">
                        <a class="text-dark" href="/signUp"><b>Еще не зарегистрированы?</b></a>
                    </div>
                </form>
            </div>

        </div>
    </div>
</@h.content>

</body>
</html>