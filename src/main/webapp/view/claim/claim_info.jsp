<%--suppress JSAnnotator --%>
<%--suppress ALL --%>
<jsp:useBean id="userInfo" scope="request" type="entity.User"/>
<jsp:useBean id="userList" scope="request" type="java.util.ArrayList<entity.User>"/>
<jsp:useBean id="claimInfo" scope="request" type="entity.Claim"/>
<jsp:useBean id="refusingReasonList" scope="request" type="java.util.ArrayList<entity.RefusingReason>"/>
<jsp:useBean id="refusingReasonTrashList" scope="request" type="java.util.ArrayList<entity.RefusingReason>"/>
<jsp:useBean id="refusingReasonCancelList" scope="request" type="java.util.ArrayList<entity.RefusingReason>"/>
<jsp:useBean id="cityList" scope="request" type="java.util.ArrayList<entity.City>"/>
<jsp:useBean id="productList" scope="request" type="java.util.ArrayList<entity.Product>"/>
<jsp:useBean id="commentList" scope="request" type="java.util.ArrayList<entity.Comment>"/>
<jsp:useBean id="orderList" scope="request" type="java.util.ArrayList<entity.Order>"/>
<jsp:useBean id="headerInfo" scope="request" type="entity.HeaderInfo"/>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Claim info</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/table.css">

    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css"/>
    <link href="../../resources/datetimepicker/css/base.css" rel="stylesheet">
    <link href="../../resources/datetimepicker/css/tempusdominus-bootstrap-4.css" rel="stylesheet">


    <script src="https://code.jquery.com/jquery-3.2.1.slim.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.4/moment-with-locales.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment-timezone/0.5.14/moment-timezone-with-data-2012-2022.min.js"></script>
    <script src="../../resources/datetimepicker/js/base.js"></script>
    <script src="../../resources/datetimepicker/js/tempusdominus-bootstrap-4.js"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
            
    <script>
        $(document).ready(function () {
            $('#submitComment').click(function (event) {
                var commentText = $('#comment_text').val();
                var claimId = $('#claim_id').val();
                var userId = $('#user_id').val();
                $.get('CommentServlet', {
                    comment_text: commentText,
                    claim_id: claimId,
                    user_id: userId
                }, function (responseText) {
                    $('#welcometext').html(responseText);
                });
                document.getElementById("commentSubmitForm").reset();

            });
        });
    </script>

    <script>
        var cityAlreadyLoad = false;
        var loadedCity = null;
    </script>
</head>
<body>
<jsp:include page="/view/included_parts/fixed_top_navbar.jsp"/>
<div style="margin-top: 1%"></div>
<form>
    <input hidden type="text" class="form-control" name="claim_id" value="${claimInfo.claimId}"
           title="ClaimID">
    <input hidden type="text" class="form-control" name="user_id" value="${userInfo.userId}"
           title="UserID">
    <section>
        <div class="row">
            <div class="col">
                <c:if test="${(claimInfo.statusId eq 3) or (claimInfo.statusId eq 4) or (claimInfo.statusId eq 5)}">
                    <div class="row">
                        <div class="col">
                        </div>
                        <div class="col">
                            <button type="submit" class="btn btn-secondary btn-block" name="DoubleButton"
                                    value="true">Дубль
                            </button>
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="col">
                <div style="text-align: center;">
                    <h2>Заявка №${claimInfo.claimCode}</h2>
                </div>
            </div>
            <div class="col">
                <%--<c:if test="${claimInfo.statusId eq (1;2;3;4;5)}">--%>
                <%--<div class="row">--%>
                <%--<div class="col">--%>
                <%--<button type="button" class="btn btn-info btn btn-block" data-toggle="collapse"--%>
                <%--data-target="#leadsIP"--%>
                <%--aria-expanded="false" aria-controls="collapseExample">--%>
                <%--PH 3--%>
                <%--</button>--%>
                <%--</div>--%>
                <%--<div class="col">--%>
                <%--<button type="button" class="btn btn-info btn btn-block" data-toggle="collapse"--%>
                <%--data-target="#leadsPH"--%>
                <%--aria-expanded="false" aria-controls="collapseExample">--%>
                <%--IP 6--%>
                <%--</button>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</c:if>--%>
            </div>
            <div class="w-100"></div>
            <div class="col"></div>
            <div class="col">
                <c:if test="${claimInfo.currentUserId ne null}">
                    <div style="text-align: center;">
                        <h4> Ведущий оператор : ${claimInfo.currentUserTitle}</h4>
                    </div>
                </c:if>
            </div>
            <div class="col">
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <select class="custom-select" title="Оператор" name="operatorId">
                                <option value="" selected>Оператор</option>
                                <c:forEach var="userList" items="${userList}">
                                    <option value="${userList.userId}">${userList.fio}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col">
                        <button type="submit" class="btn btn-primary btn-block" name="ChangeOperator"
                                value="true">Назначить оператора
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <section>
        <div class="row">
            <div class="col">
                <div class="collapse" id="leadsIP">
                    <div style="text-align: center;">
                        <h6>IP</h6>
                    </div>
                    <div class="card card-body">
                        <div class="tbl-header">
                            <table cellpadding="0" cellspacing="0" border="0">
                                <thead>
                                <tr>
                                    <th>Дата</th>
                                    <th>Продукт</th>
                                    <th>ФИО</th>
                                    <th>Телефон</th>
                                    <th>Статус</th>
                                    <th>Комментарий</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <table cellpadding="0" cellspacing="0" border="0">
                            <tbody>
                            <tr>
                                <th>Дата</th>
                                <th>Продукт</th>
                                <th>ФИО</th>
                                <th>Телефон</th>
                                <th>Статус</th>
                                <th>Комментарий</th>
                            </tr>
                            <tr>
                                <th>Дата</th>
                                <th>Продукт</th>
                                <th>ФИО</th>
                                <th>Телефон</th>
                                <th>Статус</th>
                                <th>Комментарий</th>
                            </tr>
                            <tr>
                                <th>Дата</th>
                                <th>Продукт</th>
                                <th>ФИО</th>
                                <th>Телефон</th>
                                <th>Статус</th>
                                <th>Комментарий</th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="collapse" id="leadsPH">
                    <div style="text-align: center;">
                        <h6>Phone Number</h6>
                    </div>
                    <div class="card card-body">
                        <div class="tbl-header">
                            <table cellpadding="0" cellspacing="0" border="0">
                                <thead>
                                <tr>
                                    <th>Дата</th>
                                    <th>Продукт</th>
                                    <th>ФИО</th>
                                    <th>Телефон</th>
                                    <th>Статус</th>
                                    <th>Комментарий</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <table cellpadding="0" cellspacing="0" border="0">
                            <tbody>
                            <tr>
                                <th>Дата</th>
                                <th>Продукт</th>
                                <th>ФИО</th>
                                <th>Телефон</th>
                                <th>Статус</th>
                                <th>Комментарий</th>
                            </tr>
                            <tr>
                                <th>Дата</th>
                                <th>Продукт</th>
                                <th>ФИО</th>
                                <th>Телефон</th>
                                <th>Статус</th>
                                <th>Комментарий</th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>
<c:if test="${(claimInfo.statusId eq 3) or (claimInfo.statusId eq 4) or (claimInfo.statusId eq 5)}">
<section>
    <div class="row">
        <div class="col">
            <button type="button" class="btn btn-light btn-lg btn-block" data-toggle="collapse"
                    data-target="#scriptHeader"
                    aria-expanded="false" aria-controls="collapseExample">
                Скрипты
            </button>
        </div>
        <div class="col">
            <button type="button" class="btn btn-light btn-lg btn-block" data-toggle="collapse"
                    data-target="#answerHeader"
                    aria-expanded="false" aria-controls="collapseExample">
                Возражения
            </button>
        </div>
        <div class="col">
            <button type="button" class="btn btn-light btn-lg btn-block" data-toggle="collapse"
                    data-target="#itemHeader"
                    aria-expanded="false" aria-controls="collapseExample">
                Характеристика
            </button>
        </div>
        <div class="col">
            <button type="button" class="btn btn-light btn-lg btn-block" data-toggle="collapse"
                    data-target="#clinicHeader"
                    aria-expanded="false" aria-controls="collapseExample">
                Клиники
            </button>
        </div>
    </div>
</section>
</c:if>

<section>
    <div class="row">
        <div class="col">
            <div class="collapse" id="scriptHeader">
                <div class="card card-body">
                    <p>${headerInfo.scriptInfo}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="collapse" id="itemHeader">
                <div class="card card-body">
                    <p>${headerInfo.itemInfo}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="collapse" id="answerHeader">
                <div class="card card-body">
                    <p>${headerInfo.answerInfo}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="collapse" id="clinicHeader">
                <div class="card card-body">
                    <p>${headerInfo.clinicInfo}</p>
                </div>
            </div>
        </div>
    </div>
</section>


<form>
    <section>
        <div class="row">
            <div class="col">
                <%--<form>--%>
                <div class="row">
                    <input hidden type="text" class="form-control" name="claim_id" value="${claimInfo.claimId}"
                           title="ClaimID">
                    <input hidden type="text" class="form-control" name="user_id" value="${userInfo.userId}"
                           title="UserID">

                    <div class="col-12">
                        <h4>Данные о клиенте</h4>
                        <div style="padding-top: 40px"></div>
                    </div>
                    <div class="w-100"></div>

                    <div class="col-4">Статус:</div>
                    <div class="col-8">
                        <input disabled type="text" class="form-control" placeholder="Статус"
                               value="${claimInfo.statusTitle}">
                    </div>
                    <div class="w-100"></div>
                    <hr>

                    <div class="col-4">ФИО:</div>
                    <div class="col-8">
                        <input
                                <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                type="text" class="form-control"
                                placeholder="ФИО" name="clientFIO"
                                value="${claimInfo.clientFIO}">
                    </div>

                    <div class="w-100"></div>
                    <hr>

                    <div class="col-4">Номер телефона:</div>
                    <div class="col-8">
                        <input disabled type="text"
                               class="phone_us form-control" placeholder="Номер телефона"
                               name="clientPhoneNumber"
                               value="${claimInfo.clientPhoneNumber}">

                        <input hidden type="text"
                               class="phone_us form-control" placeholder="Номер телефона"
                               name="clientPhoneNumber"
                               value="${claimInfo.clientPhoneNumber}">
                    </div>
                    <div class="w-100"></div>
                    <hr>

                    <div class="col-4">Пол/Возраст</div>
                    <div class="col-8">
                        <div class="row">
                            <div class="col-3">
                                <div class="form-check form-check-inline">
                                    <c:if test="${claimInfo.clientGender eq 1}">
                                        <input
                                                <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                                class="form-check-input" type="radio" name="genderId"
                                                id="genderM"
                                                value="1" checked>
                                    </c:if>
                                    <c:if test="${claimInfo.clientGender ne 1}">
                                        <input
                                                <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                                class="form-check-input" type="radio" name="genderId"
                                                id="genderM"
                                                value="1">
                                    </c:if>
                                    <label class="form-check-label" for="genderM">М</label>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="form-check form-check-inline">
                                    <c:if test="${claimInfo.clientGender eq 2}">
                                        <input
                                                <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                                class="form-check-input" type="radio" name="genderId"
                                                id="genderW"
                                                value="2" checked>
                                    </c:if>
                                    <c:if test="${claimInfo.clientGender ne 2}">
                                        <input
                                                <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                                class="form-check-input" type="radio" name="genderId"
                                                id="genderW"
                                                value="2">
                                    </c:if>
                                    <label class="form-check-label" for="genderW">Ж</label>
                                </div>
                            </div>
                            <div class="col-6">
                                <input
                                        <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                        type="number"
                                        class="form-control" placeholder="Возраст" name="clientAge"
                                        value="${claimInfo.clientAge}">
                            </div>
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <hr>

                    <div class="col-4">Город:</div>
                    <div class="col-8">
                        <div class="form-group">

                            <input
                                    <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                    type="text" name="cityTitle"
                                    id="cityTitle" list="json-cityList" placeholder="Город"
                                    class="form-control" onclick="loadCities()" onfocus="this.value=''"
                                    value="${claimInfo.cityTitle}">
                            <datalist id="json-cityList"></datalist>

                            <script>

                                function loadCities() {
                                    let dataList = document.getElementById('json-cityList');
                                    let input = document.getElementById('cityTitle');

                                    //dataList.clear();
                                    if (cityAlreadyLoad !== true) {
                                        cityAlreadyLoad = true;
                                        // Create a new XMLHttpRequest.
                                        let request = new XMLHttpRequest();

                                        // Handle state changes for the request.
                                        request.onreadystatechange = function (response) {
                                            if (request.readyState === 4) {
                                                if (request.status === 200) {
                                                    // Parse the JSON
                                                    let jsonOptions = JSON.parse(request.responseText);

                                                    // Loop over the JSON array.
                                                    jsonOptions.forEach(function (item) {
                                                        // Create a new <option> element.
                                                        let option = document.createElement('option');
                                                        // Set the value using the item in the JSON array.
                                                        option.value = item;
                                                        // Add the <option> element to the <datalist>.
                                                        dataList.appendChild(option);
                                                    });

                                                    // Update the placeholder text.
                                                    input.placeholder = "Город";
                                                } else {
                                                    // An error occured :(
                                                    input.placeholder = "Список городов не загружен :(";
                                                }
                                            }
                                        };


                                        // Update the placeholder text.
                                        input.placeholder = "Loading options...";

                                        // Set up and make the request.
                                        request.open('GET', 'getCityList', true);
                                        request.send();
                                    }
                                }
                            </script>
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <hr>

                    <div class="col-4">Отделение НП:</div>
                    <div class="col-8">
                        <div class="form-group">

                            <input
                                    <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                    type="text"
                                    name="warehouseTitle" id="warehouseTitle" list="json-warehouseList"
                                    placeholder="Отделение НП"
                                    class="form-control" onclick="loadWarehouses()" onfocus="this.value=''"
                                    value="${claimInfo.warehouseTitle}">
                            <datalist id="json-warehouseList"></datalist>

                            <script>

                                function loadWarehouses() {
                                    let dataList = document.getElementById('json-warehouseList');
                                    let input = document.getElementById('warehouseTitle');

                                    if (loadedCity !== document.getElementById("cityTitle").value) {
                                        loadedCity = document.getElementById("cityTitle").value;
                                        // Create a new XMLHttpRequest.
                                        let request = new XMLHttpRequest();

                                        // Handle state changes for the request.
                                        request.onreadystatechange = function (response) {
                                            if (request.readyState === 4) {
                                                if (request.status === 200) {
                                                    // Parse the JSON

                                                    let list = document.getElementById("json-warehouseList");

                                                    while (list.hasChildNodes()) {
                                                        list.removeChild(list.lastChild);
                                                    }

                                                    let jsonOptions = JSON.parse(request.responseText);

                                                    // Loop over the JSON array.
                                                    jsonOptions.forEach(function (item) {
                                                        // Create a new <option> element.
                                                        let option = document.createElement('option');
                                                        // Set the value using the item in the JSON array.
                                                        option.value = item;
                                                        // Add the <option> element to the <datalist>.
                                                        dataList.appendChild(option);
                                                    });

                                                    // Update the placeholder text.
                                                    input.placeholder = "Отделение НП";
                                                } else {
                                                    // An error occured :(
                                                    input.placeholder = "Список отделений НП не загружен :(";
                                                }
                                            }
                                        };

                                        // Update the placeholder text.
                                        input.placeholder = "Loading options...";

                                        // Set up and make the request.
                                        request.open('GET', 'getWarehouseList?city_title=' + document.getElementById("cityTitle").value, true);
//                                    request.setAttribute("city_title", 'Каменец-Подольский');
                                        request.send();
                                    }
                                }
                            </script>
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <hr>

                    <div class="col-4">Адрес:</div>
                    <div class="col-8">
                        <input
                                <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                type="text" class="form-control"
                                placeholder="Адрес" name="address"
                                value="${claimInfo.address}">
                    </div>
                    <div class="w-100"></div>
                    <hr>

                    <%--DateTimePicker--%>

                    <c:if test="${(claimInfo.statusId eq 3) or (claimInfo.statusId eq 4) or (claimInfo.statusId eq 5)}">
                        <div class="col-4">Время перезвона:</div>
                        <div class="col-8">
                            <div class="row">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control datetimepicker-input"
                                           placeholder="Время перезвона" name="recall_time" id="datetimepicker2"
                                           data-toggle="datetimepicker" data-target="#datetimepicker2"/>
                                </div>
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <hr>
                    </c:if>

                    <c:if test="${(claimInfo.statusId eq 3) or (claimInfo.statusId eq 4) or (claimInfo.statusId eq 5)}">
                        <div class="col-12">
                            <div class="row">
                                <div class="col">
                                    <button type="submit" class="btn btn-warning btn-block" name="NoConnectionButton"
                                            value="true">Нет связи
                                    </button>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-warning btn-block" name="NoAnswerButton"
                                            value="true">Нет ответа
                                    </button>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-warning btn-block" name="BusyButton"
                                            value="true">Занято
                                    </button>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-warning btn-block" name="ResetButton"
                                            value="true">Сброс
                                    </button>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-warning btn-block" name="RecallButton"
                                            value="true">Перезвонить
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <hr>
                    </c:if>

                    <c:if test="${(claimInfo.statusId eq 3) or (claimInfo.statusId eq 4)}">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary btn-block" name="ConsultButton"
                                    value="true">Консультация
                            </button>
                        </div>
                        <div class="w-100"></div>
                        <hr>
                    </c:if>

                    <c:if test="${(claimInfo.statusId eq 5) or (claimInfo.statusId eq 6)}">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary btn-block" name="SaveClientDataButton"
                                    value="true">Сохранить данные
                            </button>
                        </div>
                        <div class="w-100"></div>
                        <hr>
                    </c:if>

                    <c:if test="${claimInfo.statusId eq 6}">
                        <div class="col-12">
                            <button type="submit" class="btn btn-danger btn-block" name="AnnihilateClaimButton"
                                    value="true">Аннулировать оффер / Архив (отказ)
                            </button>
                        </div>
                        <div class="w-100"></div>
                        <hr>
                    </c:if>

                    <c:if test="${claimInfo.statusId eq 7}">
                        <div class="col-12">
                            <button type="submit" class="btn btn-success btn-block" name="BackToNewClaimButton"
                                    value="true">Вернуть заявку в работу
                            </button>
                        </div>
                        <div class="w-100"></div>
                        <hr>
                    </c:if>

                    <c:if test="${claimInfo.statusId eq 5}">
                        <div class="col-12">
                            <div class="row">
                                <div class="col">
                                    <button type="submit" class="btn btn-success btn-block" name="SendButton"
                                            value="true">Отправить
                                    </button>
                                </div>
                                <div class="col">
                                    <div class="btn-group dropup btn-block">
                                        <button type="submit" class="btn btn-danger btn-block dropdown-toggle"
                                                data-toggle="dropdown"
                                                aria-haspopup="true" aria-expanded="false" name="CancelButton">
                                            Отмена
                                        </button>
                                        <div class="dropdown-menu">
                                            <c:forEach var="refusingReasonCancelList"
                                                       items="${refusingReasonCancelList}">
                                                <a class="dropdown-item"
                                                   href="claim_info?CancelButton=true&claim_id=${claimInfo.claimId}&user_id=${userInfo.userId}&refusing_reason_id=${refusingReasonCancelList.refusingReasonId}">${refusingReasonCancelList.refusingReasonTitle}</a>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="btn-group dropup btn-block">
                                        <button type="submit" class="btn btn-dark btn-block dropdown-toggle"
                                                data-toggle="dropdown"
                                                aria-haspopup="true" aria-expanded="false" name="TrashButton">
                                            Треш (мусор)
                                        </button>
                                        <div class="dropdown-menu">
                                            <c:forEach var="refusingReasonTrashList"
                                                       items="${refusingReasonTrashList}">
                                                <a class="dropdown-item"
                                                   href="claim_info?TrashButton=true&claim_id=${claimInfo.claimId}&user_id=${userInfo.userId}&refusing_reason_id=${refusingReasonTrashList.refusingReasonId}">${refusingReasonTrashList.refusingReasonTitle}</a>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
                <%--</form>--%>
            </div>
            <div class="col">
                <form>
                    <input hidden type="text" class="form-control" name="claim_id" value="${claimInfo.claimId}"
                           title="ClaimID">
                    <input hidden type="text" class="form-control" name="user_id" value="${userInfo.userId}"
                           title="UserID">
                    <section>
                        <div class="container">
                            <%--<form>--%>
                            <div class="row">
                                <c:if test="${(claimInfo.statusId eq 3) or (claimInfo.statusId eq 4) or (claimInfo.statusId eq 5) or (claimInfo.statusId eq 6)or (claimInfo.statusId eq 7)}">
                                    <div class="col-12">
                                        <h4>Продукты</h4>
                                        <div style="padding-top: 40px"></div>
                                    </div>
                                    <div class="w-100"></div>

                                    <div class="col-4">Продукт</div>
                                    <div class="col-2">Цена</div>
                                    <div class="col-2">Количество</div>
                                    <div class="col-3">Сумма</div>
                                    <div class="col-1"></div>
                                    <div class="w-100"></div>
                                    <hr>

                                    <c:forEach var="orderList" items="${orderList}">
                                        <div class="col-4">${orderList.productTitle}</div>
                                        <div class="col-2">${orderList.productTitlePrice}</div>
                                        <div class="col-2">
                                            <input
                                                    <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                                    type="number"
                                                    class="form-control" placeholder="Количество"
                                                    name="productCount${orderList.orderId}"
                                                    value="${orderList.productCount}">
                                        </div>
                                        <div class="col-3">
                                            <input
                                                    <c:if test="${(claimInfo.statusId ne 5) and (claimInfo.statusId ne 6)}">disabled</c:if>
                                                    type="number"
                                                    class="form-control" placeholder="Сумма"
                                                    name="productFinalPrice${orderList.orderId}"
                                                    value="${orderList.finalPrice}">

                                        </div>
                                        <div class="col-1">
                                            <c:if test="${(claimInfo.statusId eq 5) or (claimInfo.statusId eq 6)}">
                                                <button type="submit" class="close" aria-label="Close"
                                                        name="DeleteProductButton"
                                                        value="${orderList.orderId}">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </c:if>
                                        </div>
                                        <div class="w-100"></div>
                                        <hr>
                                    </c:forEach>

                                    <c:if test="${(claimInfo.statusId eq 5) or (claimInfo.statusId eq 6)}">
                                        <%--Закомментировано, так как все будет сохраняться с одной кнопки--%>
                                        <%--<div class="col-11">--%>
                                        <%--<button type="submit" class="btn btn-primary btn-block"--%>
                                        <%--name="SaveProductsButton"--%>
                                        <%--value="true">Сохранить продукты--%>
                                        <%--</button>--%>
                                        <%--</div>--%>
                                        <%--<div class="w-100"></div>--%>
                                        <%--<hr>--%>

                                        <div class="col-6">
                                            <div class="form-group">
                                                <select class="custom-select" title="Продукт" name="productId">
                                                    <option value="" selected>Выберите продукт</option>
                                                    <c:forEach var="productList" items="${productList}">
                                                        <option value="${productList.productId}">${productList.productTitle}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-5">
                                            <button type="submit" class="btn btn-primary btn-block"
                                                    name="AddProductButton"
                                                    value="true">Добавить продукт
                                            </button>
                                        </div>
                                        <div class="w-100"></div>
                                        <hr>
                                    </c:if>
                                </c:if>

                                <div class="col-12">
                                    <!--for demo wrap-->
                                    <div class="tbl-header">
                                        <table cellpadding="0" cellspacing="0" border="0">
                                            <thead>
                                            <tr>
                                                <th>№</th>
                                                <th>Комментарий</th>
                                                <th>Время</th>
                                                <th>Пользователь</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div id="welcometext">
                                        <table cellpadding="0" cellspacing="0" border="0">
                                            <tbody>
                                            <c:forEach var="commentList" items="${commentList}">
                                                <tr>
                                                    <th>${commentList.rowNumber}</th>
                                                    <th>${commentList.commentText}</th>
                                                    <th>${commentList.dateCreate}</th>
                                                    <th>${commentList.userFIO}</th>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <%--</form>--%>
                            <c:if test="${(claimInfo.statusId eq 3) or (claimInfo.statusId eq 4) or (claimInfo.statusId ne 5) or (claimInfo.statusId ne 6)}">
                                <form id="commentSubmitForm">
                                    <div class="row">
                                        <div class="col-7">
                                            <input type="text" id="comment_text" class="form-control"
                                                   placeholder="Комментарий">
                                            <input hidden type="text" id="claim_id" value="${claimInfo.claimId}"/>
                                            <input hidden type="text" id="user_id" value="${userInfo.userId}"/>
                                        </div>
                                        <div class="col-4">
                                            <button type="button" id="submitComment" class="btn btn-primary btn-block">
                                                Добавить комментарий
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </c:if>
                        </div>
                    </section>
                    <%--</form>--%>
            </div>
        </div>
    </section>
</form>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4"></h1>
    </div>
</div>

</html>
