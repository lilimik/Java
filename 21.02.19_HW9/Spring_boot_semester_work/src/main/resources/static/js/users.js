function renderTable(users, table) {

    let innerHtml =
        '<thead>\n' +
        '   <tr>\n' +
        '       <th scope="col">ID</th>' +
        '       <th scope="col">Email</th>' +
        '       <th scope="col">FirstName</th>' +
        '       <th scope="col">LastName</th>' +
        '   </tr>' +
        '</thead>' +
        '<tbody>';

    for (let i = 0; i < users.length; i++) {
        innerHtml += '<tr>';
        innerHtml += '  <th scope="row">' + users[i]['id'] + '</th>';
        innerHtml += '  <td>' + users[i]['email'] + '</td>';
        innerHtml += '  <td>' + users[i]['firstName'] + '</td>';
        innerHtml += '  <td>' + users[i]['lastName'] + '</td>';
        innerHtml += '</tr>';
    }

    innerHtml += '</tbody>';
    table.html(innerHtml);

}

function saveUser(email, firstName, lastName, password) {

    let data = {
        "email": email,
        "firstName": firstName,
        "lastName": lastName,
        "password": password
    };

    $.ajax({
        type: "POST", // метод запроса
        url: "/signUp", // url запроса
        data: JSON.stringify(data), // JSON-объект в JSON-строку
        // что происходит, если запрос прошел успешно
        success: function (response) {
            // рисуем таблицу на основе ответа на запрос
            renderTable(response, $('#table'))
        },
        // тип данных, который мы отправляем
        dataType: "json",
        contentType: "application/json"
    })

}