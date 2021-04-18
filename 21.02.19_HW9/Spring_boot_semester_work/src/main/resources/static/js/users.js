function renderTable(user, table) {

    let innerHtml =
        '<thead class="thead-dark">' +
        '   <tr>' +
        '       <th scope="col">ID</th>' +
        '       <th scope="col">Email</th>' +
        '       <th scope="col">FirstName</th>' +
        '       <th scope="col">LastName</th>' +
        '   </tr>' +
        '</thead>' +
        '<tbody>' +
        '<tr>' +
        '  <th scope="row">' + user['id'] + '</th>' +
        '  <td>' + user['email'] + '</td>' +
        '  <td>' + user['firstName'] + '</td>' +
        '  <td>' + user['lastName'] + '</td>' +
        '</tr>' +
        '</tbody>';

    table.html(innerHtml);

}

const findUser = async id => {
    const resp = await fetch(`/users/${id}`);
    const user = await resp.json();

    const table = $('#table');

    renderTable(user, table);
}

function _findUser(user_id) {

   console.log(user_id)

    const data = {
        "id": user_id
    };

    $.ajax({
        type: "GET", // метод запроса
        url: `/users/${user_id}`, // url запроса
        // что происходит, если запрос прошел успешно
        success: function (response) {
            // рисуем таблицу на основе ответа на запрос
            console.log(response)
            renderTable(response, $('#table'))
        },
        // // тип данных, который мы отправляем
        // dataType: "json",
        // contentType: "application/json"
    })

}