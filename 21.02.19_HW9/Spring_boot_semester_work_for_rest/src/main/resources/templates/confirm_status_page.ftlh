<#import "header.ftlh" as h>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Confirm</title>

    <@h.head_files>
    </@h.head_files>

    <link rel="stylesheet" href="/css/root.css">

</head>
<body>

<@h.header>
</@h.header>

<@h.content>

    <div class="col-md-offset-5" style="margin-top: 100px;">

        <div class="card text-center border border-dark rounded-1" style="width: 30rem; height: 16rem;">
            <div class="card-body">
                <h4 class="card-title"><b>Подтверждение аккаунта</b></h4>
                <hr>
                <p class="card-text">
                    <#if confirmStatus??>
                        Ваш аккаунт успешно подтвержден!
                    <#else>
                        Недействительный код подтверждения
                    </#if>
                </p>
                <a href="/" class="btn btn-primary">На главную</a>
            </div>
        </div>

    </div>

</@h.content>

</body>
</html>