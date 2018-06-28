<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Claim</title>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css'>
    <link rel="stylesheet" href="../../resources/css/authentication.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://unpkg.com/jquery-input-mask-phone-number@1.0.0/dist/jquery-input-mask-phone-number.js"></script>

    <script>

        $(document).ready(function () {
            $('#yourphone').usPhoneFormat({
                format: '(xxx) xxx-xxxx',
            });

            $('#yourphone2').usPhoneFormat();
        });

    </script>

    <script>
        var ip = Request.UserHostAddress;
        var hostname = Request.UserHostName;
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row vertical-center">
        <form class="col-xs-8 col-xs-offset-2  col-sm-6 col-sm-offset-3 col-md-4 col-sm-offset-4 col-lg-2 col-lg-offset-5">
            <select class="custom-select" title="Источник заявки" name="advertising_source_id">
                <option value="1" selected>Лендинг с продуктом №1</option>
                <option value="2">Лендинг с продуктом №2</option>
            </select>
            <p>
                <input class="form-control" type="text" name="fio" placeholder="FIO" required
                       autofocus>
            </p>

            <p>
                <input id="yourphone" class="phone_us form-control" type="text" name="phone_number"
                       placeholder="Phone Number"
                       required>
            </p>
            <button class="btn btn-primary btn-block" type="submit" name="Create" value="true">Создать</button>
            <p></p>
        </form>
    </div>
</div>

</body>
</html>