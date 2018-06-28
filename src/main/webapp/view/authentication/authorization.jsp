<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Sign In</title>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css'>
    <link rel="stylesheet" href="../../resources/css/authentication.css">

</head>

<body>
<div class="container-fluid">
    <div class="row vertical-center">
        <form class="col-xs-8 col-xs-offset-2  col-sm-6 col-sm-offset-3 col-md-4 col-sm-offset-4 col-lg-2 col-lg-offset-5">
            <p>
                <label class="sr-only" for="login">Login</label>
                <input id="login" class="form-control" type="text" name="login" placeholder="Login" required
                       autofocus>
            </p>
            <p>
                <label class="sr-only" for="password">Password</label>
                <input id="password" class="form-control" type="password" name="password" placeholder="Password"
                       required>
            </p>
            <button class="btn btn-primary btn-block" type="submit" name="SignIn" value="true">Sign In</button>
            <p></p>
        </form>
    </div>
</div>


<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js'></script>

</body>

</html>

