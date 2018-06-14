<!doctype html>
<html>
<meta charset = "utf-8">
<meta http-equiv = "X-UA-Compatible" content = "IE = edge">
<meta name = "viewport" content = "width = device-width, initial-scale = 1">


<!-- Bootstrap -->
<link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<head>
    <title>Crear Usuario</title>
    <H1>Crear Usuario</H1>
</head>

<body>
<form action="/agregarUsuario" method="post" >
    <div>
        <label for="username">Username:
            <div>
                <input type="text" name="username">
            </div>
    </div>
    <div>
        <div>
            <label for="nombre">Nombre:
                <div>
                    <input type="text" name="nombre">
                </div>
        </div>
        <div>
        <label for="password">Password:   </label>
        <div>
            <input type="password" name="password">
        </div>
    </div>
    <div>
        <label for="adimistrator">Es Admin?  </label>
        <div>
            <input type="checkbox" name="administrator" checked="checked">
        </div>
    </div>
    <div>
        <label for="autor">Es Autor? </label>
        <div>
            <input type="checkbox" name="autor">
        </div>

    </div>
    <button type="submit">
        Agregar
    </button>
</form>

</body>

</html>