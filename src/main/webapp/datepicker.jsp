<%--<html>--%>
<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<title>Bootstrap 4 DatePicker</title>--%>
<%--<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/js/gijgo.min.js" type="text/javascript"></script>--%>
<%--<link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/css/gijgo.min.css" rel="stylesheet" type="text/css" />--%>
<%--</head>--%>
<%--<body>--%>
<%--<input id="datepicker" width="276" />--%>
<%--<script>--%>
<%--$('#datepicker').datepicker({--%>
<%--uiLibrary: 'bootstrap4'--%>
<%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>


<%--<HTML>--%>
<%--<head>--%>
<%--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/js/tempusdominus-bootstrap-4.min.js"></script>--%>
<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/css/tempusdominus-bootstrap-4.min.css" />--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--<div class="row">--%>
<%--<div class="col-sm-6">--%>
<%--<div class="form-group">--%>
<%--<div class="input-group date" id="datetimepicker1" data-target-input="nearest">--%>
<%--<input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>--%>
<%--<div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">--%>
<%--<div class="input-group-text"><i class="fa fa-calendar"></i></div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<script type="text/javascript">--%>
<%--$(function () {--%>
<%--$('#datetimepicker1').datetimepicker();--%>
<%--});--%>
<%--</script>--%>
<%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</HTML>--%>


<html>
<head>
    <!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>

    <!--Font Awesome (added because you use icons in your prepend/append)-->
    <link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css"/>

    <!-- Inline CSS based on choices in "Settings" tab -->
    <style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form {
        font-family: Arial, Helvetica, sans-serif;
        color: black
    }

    .bootstrap-iso form button, .bootstrap-iso form button:hover {
        color: white !important;
    }

    .asteriskField {
        color: red;
    }</style>

</head>
<body>
<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <form method="post">
                    <div class="form-group ">
                        <label class="control-label " for="date">
                            Date
                        </label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="fa fa-clock-o">
                                </i>
                            </div>
                            <input class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button class="btn btn-primary " name="submit" type="submit">
                                Submit
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
    $(document).ready(function () {
        var date_input = $('input[name="date"]'); //our date input has the name "date"
        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'mm/dd/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
    })
</script>
</body>
</html>