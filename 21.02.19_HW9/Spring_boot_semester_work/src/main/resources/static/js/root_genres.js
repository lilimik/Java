function renderCarousels(mapFilms, carousels) {

    const keys = Object
        .keys(mapFilms)
        .map(genre => ({genre, films: mapFilms[genre]}))
        .map(({genre, films}, i) => {

            let innerHtml =
                '<div class="pb-3">' +
                '<h3 class="text-light text-center" id="for_carouselExampleFade' + i + '"><a class="none_link_line" href="#">' + genre + '</a>' +
                '</h3>' +
                '</div>' +


                '<div id="carouselExampleFade' + i + '" class="carousel slide pb-0 pt-0 row" data-ride="carousel">' +

                '    <a class="carousel-control-prev col-md-1" href="#carouselExampleFade' + i + '" role="button" data-slide="prev">' +
                '        <span class="carousel-control-prev-icon" aria-hidden="true"></span>' +
                '        <span class="sr-only bg-link-carousel">Previous</span>' +
                '    </a>' +

                '<div class="carousel-inner col-md-10">';

            let num = 0;
            for (let j = 0; j < films.length; j++) {
                if (num === 0) {
                    if (j === 0) {

                        innerHtml += '<div class="carousel-item active">' +
                            '<div class="container text-center ">' +

                            '<div class="text-center pl-0 pr-0 container d-flex flex-row ">';

                    } else {

                        innerHtml += '<div class="carousel-item">' +
                            '<div class="container text-center ">' +

                            '<div class="text-center pl-0 pr-0 container d-flex flex-row ">';

                    }
                }


                if (num < 3) {
                    innerHtml += '<div class="block col-md-6 col-xl-3 ">' +
                        '<div class="card shadow " style="width: auto">' +
                        '<img src= "https://hype.tech/covers/1913/hype-ru-cover-clean-7011.jpg" class="card-img-top" alt="Red roses">' +
                        '<div class="card-body p-0">' +
                        '<h5 class="card-title pt-1 mb-1">' + films[j].title + '</h5>' +
                        '<div class="text-center">' +
                        '<small><b> Год:</b>' + films[j].year + '</small>' +
                        '</div>' +
                        '<div class="scroll">' +
                        '<p class="card-text p-2">' + films[j].description + '</p>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>';

                    num++;
                    if (num === 3 || j === films.length - 1) {

                        innerHtml += '</div>' +
                            '</div>' +
                            '</div>';

                        num = 0;
                    }
                }
            }

            innerHtml += '</div>' +
                '<a class="carousel-control-next col-md-1" href="#carouselExampleFade' + i + '" role="button"' +
                ' data-slide="next">' +
                '<span class="carousel-control-next-icon" aria-hidden="true"></span>' +
                '<span class="sr-only">Next</span>' +
                '</a>' +
                '</div>';

            return innerHtml;
        })

    keys.forEach(key => carousels.append(key))
}


function findFilmsByGenres() {

    let data = [];

    $('#genreForm').find(`input:checked`).each(function () {
        data.push($(this).val());
    });

    $.ajax({
        type: "POST", // метод запроса
        url: "/genreForm", // url запроса
        data: JSON.stringify(data), // JSON-объект в JSON-строку
        // что происходит, если запрос прошел успешно
        success: function (response) {
            renderCarousels(response, $('#carousels'))
        },
        // тип данных, который мы отправляем
        dataType: "json",
        contentType: "application/json"
    })

}