function renderUserTable(user, table) {

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

    renderUserTable(user, table);
}

function renderFilmTable(film, table) {

    let innerHtml =
        '<thead class="thead-dark">' +
        '   <tr>' +
        '       <th scope="col">ID</th>' +
        '       <th scope="col">Заголовок</th>' +
        '       <th scope="col">Бюджет</th>' +
        '       <th scope="col">Год</th>' +
        '   </tr>' +
        '</thead>' +
        '<tbody>' +
        '<tr>' +
        '  <th scope="row">' + film['id'] + '</th>' +
        '  <td>' + film['title'] + '</td>' +
        '  <td>' + film['budget'] + '</td>' +
        '  <td>' + film['year'] + '</td>' +
        '</tr>' +
        '</tbody>';

    table.html(innerHtml);

}

const findFilm = async id => {
    const resp = await fetch(`/films/${id}`);
    const user = await resp.json();

    const table = $('#table');

    renderFilmTable(user, table);
}