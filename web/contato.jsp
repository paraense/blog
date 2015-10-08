<%-- 
    Document   : contato
    Created on : 08/10/2015, 01:44:14
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Imports css, meta etc..-->
        <%@include file="templates/head.jsp" %>
    </head>
    <body>
           <!--Barra de menu - topo -->
        <%@include file="templates/topo.jsp" %> 
        <div class="row">
            <div class="container" >
                <div class="col-lg-6">
                    <h3>Enviar uma mensagem</h3>
                    <form class="form-group">
                        Nome:
                        <input type="text" class="form-control" name="nome" />
                        E-mail:
                        <input type="text" class="form-control" name="email" />
                        Assunto:
                        <input type="text" class="form-control" name="assunto" />
                        Mensagem:
                        <textarea name="texto" style="height: 200px;" class="form-control" ></textarea>
                        <br/>
                        <button class="btn btn-primary">Enviar</button>
                    </form>
                </div>
                <div class="col-lg-6">
                    <img src="img/facebook53.png" />
                    <img src="img/linkedin11.png" />
                    <img src="img/twitter12.png" />
                    <img src="img/youtube21.png" />
                    
                </div>
            </div>

        </div>
    </body>
</html>
