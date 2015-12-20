<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!--Imports css, meta etc..-->
        <%@include file="templates/head.jsp" %>

    </head>
    <body>
        <%@include  file="templates/topo.jsp" %>
        <div class="container" style="width: 70%;">
            
            <div class="row">
                <!--BIO -->
                <div class="col-md-2" style="position: fixed; padding-top:4%;">
                    <div class="col-md-9">

                        <div class="page-head">
                            <img src="https://scontent-mia1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12075039_938027346264339_3949987739955544799_n.jpg?oh=91fa2067c6bbb4cb03558a84eeace0e8&oe=56EDFD01" style="width: 120px; heigth:170px;"></img>
                        </div>
                        <p style="font-size:9px; text-align: justify"><b style="font-size:14px;">John Gomes</b><br/>
                            Programador Java. Cursou Análise e Desenvolvimento de sistemas. Atualmente trabalha com desenvolvimento de soluções coorporativas utilizando a plataforma Java.
                        </p>
                    </div>
                </div>
                <!--fim Bio-->

                <!--Corpo do Texto-->
                <div class="col-md-10 pull-right" style="padding-left:4%; padding-top:4%" >
                    <c:forEach var="p" items="${postagens}"> 
                        <div class="page-head">
                            <h1><a href="postagem?id=${p.id}" >${p.titulo}</a></h1>
                        </div>
                        <p class="lead">${p.resumo}</p>
                        <br/>                        
                        <a href="postagem?id=${p.id}">Ler postagem completa</a>
                        <hr>
                    </c:forEach>
                </div><!--fim texto -->         
            </div><!--fim row-->

            <hr>
            <!-- Footer -->
            <%@include file="templates/rodape.jsp" %>
        </div><!--fim container-->




        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>


    </body>
</html>

