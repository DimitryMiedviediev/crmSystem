<jsp:useBean id="claimsCount" scope="request" type="entity.CountClaim"/>
<jsp:useBean id="claimList" scope="request" type="java.util.ArrayList<entity.Claim>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Home</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/table.css">


    <script src="https://code.jquery.com/jquery-3.2.1.slim.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.js"></script>

    <script>
        jQuery(document).ready(function ($) {
            $(".clickable-row").click(function () {
                window.location = $(this).data("href");
            });
        });
    </script>

</head>
<body>
<jsp:include page="/view/included_parts/fixed_top_navbar.jsp"/>
<%--<div class="container">--%>
<section>
    <div class="row">
        <div class="col">
            <a href="claim_list?claim_status=New" role="button" class="btn btn-info btn-lg btn-block"
               aria-pressed="true">
                Новые <span class="badge badge-pill badge-light">${claimsCount.newClaim}</span>
            </a>
        </div>
        <div class="col">
            <a href="claim_list?claim_status=Recall" role="button" class="btn btn-warning btn-lg btn-block"
               aria-pressed="true">
                Перезвонить <span class="badge badge-light">${claimsCount.recallClaim}</span>
            </a>
        </div>
        <div class="col">
            <a href="claim_list?claim_status=Consult" role="button" class="btn btn-primary btn-lg btn-block"
               aria-pressed="true">
                Консультация <span class="badge badge-light">${claimsCount.consultClaim}</span>
            </a>
        </div>
        <div class="col">
            <a href="claim_list?claim_status=ArchSuccess" role="button" class="btn btn-success btn-lg btn-block"
               aria-pressed="true">
                Архив(успех) <span class="badge badge-light">${claimsCount.archSuccessClaim}</span>
            </a>
        </div>
        <div class="col">
            <a href="claim_list?claim_status=ArchFail" role="button" class="btn btn-danger btn-lg btn-block"
               aria-pressed="true">
                Архив(отказ) <span class="badge badge-light">${claimsCount.archFailClaim}</span>
            </a>
        </div>
        <div class="col">
            <a href="claim_list?claim_status=Trash" role="button" class="btn btn-dark btn-lg btn-block"
               aria-pressed="true">
                Треш(мусор) <span class="badge badge-light">${claimsCount.trashClaim}</span>
            </a>
        </div>
        <div class="col">
            <a href="claim_list?claim_status=Double" role="button" class="btn btn-secondary btn-lg btn-block"
               aria-pressed="true">
                Дубли <span class="badge badge-light">${claimsCount.doubleClaim}</span>
            </a>
        </div>
    </div>
</section>
<%--</div>--%>
<div style="margin-top: 2%"></div>
<section>
    <!--for demo wrap-->
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>Номер заявки</th>
                <th>Время</th>
                <th>Продукт на лендинге</th>
                <th>ФИО</th>
                <th>Телефон</th>
                <th>Статус</th>
                <th>Комментарий</th>
            </tr>
            </thead>
        </table>
    </div>
    <div>
        <table class="table table-hover" cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach var="claimList" items="${claimList}">
                <tr class='clickable-row' data-href='claim_info?claim_id=${claimList.claimId}'>
                    <th scope="col">${claimList.claimCode}</th>
                    <th scope="col">${claimList.dateCreate}</th>
                    <th scope="col">${claimList.productTitle}</th>
                    <th scope="col">${claimList.clientFIO}</th>
                    <th scope="col">${claimList.clientPhoneNumber}</th>
                    <th scope="col">${claimList.statusTitle}</th>
                    <th scope="col">${claimList.lastComment}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4"></h1>
    </div>
</div>

</html>
