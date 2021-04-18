<#import "header.ftlh" as h>
<!doctype html>
<html lang="en">
<head>
    <title>Главная</title>

    <@h.head_files>
    </@h.head_files>

    <link rel="stylesheet" href="/css/root.css">
    <script src="/js/root.js"></script>

</head>
<body>

<@h.header>
</@h.header>

<@h.content>
        <div class="col-md-9" id="carousels">


            <div class="col-md-3 text-center position-fixed second_div border-left border-dark pad_div2"
                 style="background-color: white; height: 100%">


                <legend class="mb-0"><b>Фильтр</b></legend>

                <ul class="nav nav-tabs nav-fill" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link" id="genre" data-toggle="tab"
                           href="#for_genre" role="tab"
                           aria-controls="home" aria-selected="true">Жанр</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="country" data-toggle="tab"
                           href="#for_country" role="tab"
                           aria-controls="profile" aria-selected="false">Страна</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="restriction" data-toggle="tab"
                           href="#for_restriction"
                           role="tab"
                           aria-controls="contact" aria-selected="false">Ограничение</a>
                    </li>
                </ul>

                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="for_genre"
                         role="tabpanel"
                         aria-labelledby="genre">

                        <form id="genreForm">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                            <div class="col-form-label col-md-12 pt-0">
                                <h4 class=" col-md-10 text-center"><b>Все жанры:</b>
                                </h4>
                            </div>

                            <div class="scroll pl-0" style="width: 105%; height: 380px">

                                <fieldset class="form-group pt-3">
                                    <div class="row text-left">

                                        <#list genres as genre>
                                        <div class="form-check col-md-12 row">
                                            <input class="form-check-input col-md-6"
                                                   type="checkbox"
                                                   name="gridRadios"
                                                   id="${genre.getName()}"
                                                   value="${genre.getName()}">
                                            <label class="form-check-label col-md-6"
                                                   for="${genre.getName()}">
                                                ${genre.getName()}
                                            </label>
                                        </div>
                                        </#list>

                                </fieldset>

                            </div>

                            <button type="button"
                                    class="btn btn-outline-primary shadow p-2 rounded"
                                    onclick="findFilmsByGenres()">
                                найти
                            </button>

                        </form>


                    </div>
                    <div class="tab-pane fade" id="for_country" role="tabpanel"
                         aria-labelledby="countries">

                        <form>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                            <div class="col-form-label col-md-12 pt-0">
                                <h4 class=" col-md-10 text-center"><b>Страны:</b></h4>
                            </div>

                            <div class="scroll pl-0" style="width: 105%; height: 380px">

                                <fieldset class="form-group pt-3">
                                    <div class="row text-left">

                                        <#list countries as country>
                                        <div class="form-check col-md-12 row">
                                            <input class="form-check-input col-md-6"
                                                   type="checkbox"
                                                   name="gridRadios"
                                                   id="${country.getName()}"
                                                   value="${country.getName()}">
                                            <label class="form-check-label col-md-6"
                                                   for="${country.getName()}">
                                                ${country.getName()}
                                            </label>
                                        </div>
                                        </#list>

                                </fieldset>

                            </div>

                            <button type="button"
                                    class="btn btn-outline-primary shadow p-2 rounded"
                                    onclick="findFilmsByGenres()">
                                найти
                            </button>

                        </form>

                    </div>

                    <div class="tab-pane fade" id="for_restriction" role="tabpanel"
                         aria-labelledby="restriction">
                        <form>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                            <div class="col-form-label col-md-12 pt-0">
                                <h4 class=" col-md-10 text-center"><b>По возрасту:</b>
                                </h4>
                            </div>

                            <div class="scroll pl-0" style="width: 105%; height: 380px">

                                <fieldset class="form-group pt-3">
                                    <div class="row text-left">

                                        <fieldset class="form-group pt-3">
                                            <div class="row text-left">

                                                <#list restrictions as restriction>
                                                <div class="form-check col-md-12 row">
                                                    <input class="form-check-input col-md-6"
                                                           type="checkbox"
                                                           name="gridRadios"
                                                           id="${restriction.getId()}"
                                                           value="${restriction.getId()}">
                                                    <label class="form-check-label col-md-6"
                                                           for="${restriction.getId()}">
                                                        ${restriction.getId()}
                                                    </label>
                                                </div>
                                                </#list>

                                        </fieldset>

                                    </div>
                                </fieldset>

                            </div>

                            <button type="button"
                                    class="btn btn-outline-primary shadow p-2 rounded"
                                    onclick="findFilmsByGenres()">
                                найти
                            </button>

                        </form>
                    </div>
                </div>
            </div>

        </div>

</@h.content>
</body>
</html>
