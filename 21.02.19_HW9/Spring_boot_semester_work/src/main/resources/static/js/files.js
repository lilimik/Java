function sendFile() {
    // данные для отправки
    let formData = new FormData();
    // забрал файл из input
    let files = ($('#file'))[0]['files'];
    // добавляю файл в formData
    [].forEach.call(files, function (file, i, files) {
        formData.append("file", file);
    });

    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        processData: false,
        contentType: false
    })
        .done(function (response) {
            let fileUrl = 'http://localhost:80/files/' + response;
            $('#photo').append('<img src = "' + fileUrl + '"/>');
        })
        .fail(function () {
            alert('Error')
        });
}
