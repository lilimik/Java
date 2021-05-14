<#import "header.ftlh" as h>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>

    <@h.head_files>
    </@h.head_files>

    <link rel="stylesheet" href="/css/root.css">
    <script src="/js/admin.js"></script>

</head>
<body>

<@h.header>
</@h.header>

<@h.content>

    <div class="container mt-5">
        <div class="row">

            <div class="col-md-offset-3 col-md-6">
                <div class="container" style="width: 250px">
                    <div class="form-group">
                        <label for="user_id" class="text-white">id пользователя:</label>
                        <input type="number" class="form-control" name="user_id" id="user_id" required>
                    </div>

                    <button class="btn btn-primary" onclick="findUser($('#user_id').val())">
                        найти
                    </button>
                </div>
                <br>

                <table id="table" class="text-white table table-dark">

                </table>
            </div>
        </div>
    </div>

</@h.content>

</body>
</html>