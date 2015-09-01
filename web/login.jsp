<%-- 
    Document   : login
    Created on : 01/09/2015, 12:50:06
    Author     : john
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="templates/head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <img src="http://dri1.img.digitalrivercontent.net/Storefront/Site/msusa/images/promo/en-US/msstore_400x400.jpg" />
                </div>
                <div class="col-lg-4">
                    <form action="login" style="padding-top: 30%;" method="POST">
                        <h2>login</h2>
                        Login:
                        <input type="text" class="form-control" name="login" />
                        Senha:
                        <input type="password" class="form-control" name="login" />
                        <br/>
                        <button class="btn btn-primary" >Entrar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
