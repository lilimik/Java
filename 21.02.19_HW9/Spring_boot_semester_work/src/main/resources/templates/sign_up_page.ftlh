<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

    <link rel="SHORTCUT ICON" href="/image/main_image.png">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <script src="https://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2015/b-v3-3-6/bootstrap.min.js"></script>
    <script src="https://bootstraptema.ru/plugins/2016/validator/validator.min.js"></script>
    <link rel="stylesheet" href="/css/sign_up_style.css"/>
    <link rel="stylesheet" href="/css/root_style.css"/>

</head>
<body>

<div class="container mt-5">
    <div class="row">

        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal pb-1" data-toggle="validator"
                  action="/signUp" method="post">
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
                <div class="form-group help">
                    <label for="inputPassword"></label><input type="password" data-toggle="validator" data-minlength="6"
                                                              class="form-control"
                                                              name="password" id="inputPassword"
                                                              placeholder="Пароль" required>
                    <span class="help-block text-dark">Минимум 6 символов</span>
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-exclamation-circle"></a>
                </div>
<#--                <div class="form-group help">-->
<#--                    <label for="inputPasswordConfirm"></label><input type="password" class="form-control"-->
<#--                                                                     name="password2" id="inputPasswordConfirm"-->
<#--                                                                     data-match="#inputPassword"-->
<#--                                                                     placeholder="Повторите пароль"-->
<#--                                                                     data-match-error="Пароли не совпадают!" required>-->
<#--                    <div class="help-block with-errors"></div>-->
<#--                    <i class="fa fa-lock"></i>-->
<#--                    <a href="#" class="fa fa-exclamation-circle"></a>-->
<#--                </div>-->
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" id="checkbox1" data-error="Обязательно!" name="check" required>
                        <label for="checkbox1"></label>
                        <div class="help-block with-errors"></div>
                    </div>
                    <span class="text">Докажите, что Вы человек</span>
                    <button type="submit" class="btn btn-default">РЕГИСТРАЦИЯ</button>
                </div>
<#--                <div class="form-group text-center">-->
<#--                    <a class="text-dark" href="${pageContext.request.contextPath}/signIn"><b>Уже есть аккант?</b></a>-->
<#--                </div>-->
            </form>
        </div>

    </div>
</div>

</body>
</html>