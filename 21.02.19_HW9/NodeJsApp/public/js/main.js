function getFilms() {
    $.get("http://localhost:80/films", function (data) {
        let html = '';
        console.log('data')

        for (let i = 0; i < data.length; i++) {
            html += '<tr>' +
                '<td>' + data[i].id + '</td>' +
                '<td>' + data[i].title + '</td>' +
                '<td>' + data[i].boxOffice + '</td>' +
                '<td>' + data[i].budget + '</td>' +
                '<td>' + data[i].description + '</td>' +
                '<td>' + data[i].poster_storage_name + '</td>' +
                '<td>' + data[i].year + '</td>' +
                '</tr>';
        }

        $('#table_header').after(html);
    })
}