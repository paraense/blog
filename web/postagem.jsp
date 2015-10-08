<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!--Imports css, meta etc..-->
        <%@include file="templates/head.jsp" %>
    </head>

    <body>
        <!--Barra de menu - topo -->
        <%@include file="templates/topo.jsp" %>  

        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <!-- Blog Post Content Column -->
                <div class="col-lg-8">
                    <!--Post-->

                    <c:forEach var="p" items="${postagens}">
                        <!-- Titulo -->
                        <h1><a href="postagem?id=${p.id}"> ${p.titulo}</a></h1>

                        <!-- Autor -->
                        <p class="lead">
                            by <a href="#">John Gomes</a>
                        </p>
                        <hr>
                        <!-- Date/Time -->
                        <p><span class="glyphicon glyphicon-time"></span> Posted on August 24, 2013 at 9:00 PM</p>

                        <hr>
                        <!-- Preview Image -->
                        <img class="img-responsive" src="http://www.eddic.cn/images/banner_java_se_7_programming.png" alt="">
                        <hr>
                        <!-- Post Content -->
                        <p>
                            ${p.texto}
                        </p>
                        <hr>
                        <!-- Blog Comments -->
                        
                        <!-- Comentários -->
                        <c:forEach var="c" items="${p.comentarios}">
                            <!-- Comment -->
                            <div class="media">
                                <a class="pull-left" href="#">
                                    <img class="media-object" src="http://www.iwtraining.com.br/images/Produtos/livre/JAVA_icone.jpg" alt="">
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading">${c.nome}
                                        <small>${c.datahora}</small>
                                    </h4>
                                    ${c.texto}
                                </div>
                            </div>
                            <br/>
                        </c:forEach>
                                  <!-- Formulário de comentários -->
                    <div class="well">
                        <h4>Deixe um comentário:</h4>
                        <form role="form" action="comentario" method="POST">
                            <div class="form-group">
                                Nome:
                                <input type="text" name="nome" class="form-control" rows="3" required>
                            </div>
                            <div class="form-group">
                                Email:
                                <input type="email" name="email" class="form-control" rows="3" required>
                            </div>
                            <div class="form-group">
                                Comentário:
                                <textarea class="form-control" name="texto" rows="3"></textarea>
                                <input type="hidden" name="id_post" value="${p.id}" />
                            </div>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>
                    </div>                            
                    </c:forEach>
                    <hr>
              

                </div>

                <!-- Menu lateral -->
                <div class="col-md-4">
                    <%@include file="templates/lateral.jsp" %>
                </div>

            </div><!-- /.row -->
            <hr>

            <!-- Footer -->
            <%@include file="templates/rodape.jsp" %>

        </div><!-- /.container -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
