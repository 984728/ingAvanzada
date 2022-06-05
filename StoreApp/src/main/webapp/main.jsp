<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>StoreApp</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Menú</a>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controller?action=customers" target="myFrame">Customers</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controller?action=products" target="myFrame">Products</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controller?actio=sales" target="myFrame">Sales</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controller?action=users" target="myFrame">Users</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                    <div class="dropdown text-center align-content-end">
                        <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            User Active${userO.getUser()}
                        </button>
                        <ul class="dropdown-menu text-center " aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#"></a><img src="img/user.png" alt="60" width="60"/></li>
                            <li><a class="dropdown-item" href="#">user</a></li>
                            <li><a class="dropdown-item" href="#">email@mail.com</a></li>
                            <div class="dropdown-divider" ></div>
                            <li><a class="dropdown-item" href="#">Salir</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 1000px">
            <iframe name="myFrame" style="height: 100%;width: 100%">

            </iframe>

        </div>


    </body>
</html>
