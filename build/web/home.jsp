<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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
                    <!-- Blog Post -->

                    <c:forEach var="p" items="${postagens}">
                        <!-- Title -->
                        <h1><a href="postagem?id=${p.id}"> ${p.titulo}</a></h1>

                        <!-- Author -->
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
                            ${p.resumo}
                        </p>
                        <hr>
                        <a href="postagem?id=${p.id}" class="btn btn-primary btn-sm" >Ler mais...</a>
                    </c:forEach>
                </div>


                <!-- Blog Sidebar Widgets Column -->
                <div class="col-md-4">
                    <%@include file="templates/lateral.jsp" %>
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
