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
        <div class="container mt-4 col-lg-3 text-center">
            <div class="card text-center">
                <div class="card-body col-sm-10 text-center">
                    <form class="form-sign" action="Validate" method="POST">
                        <div class="form-group ">
                            <img src="img/online-shop.png" alt="100" width="100"/>
                            <h3>Login</h3>
                            <label>User</label>
                            <input type="text" name="txtUser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="txtPwd" class="form-control">
                        </div>
                        <div class="form-group mt-4"> 
                            <input type="submit" name="action" value="Ingresar" class="btn btn-primary btn-block">
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>
     
    </body>
</html>
