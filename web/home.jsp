<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Javeiro</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/blog-post.css" rel="stylesheet">
    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Blog do Javeiro</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#">Sobre o autor</a>
                        </li>
                        <li>
                            <a href="#">Sobre o Blog</a>
                        </li>
                        <li>
                            <a href="#">Contato</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Content -->
        <div class="container">
            <div class="row">

                <!-- Blog Post Content Column -->
                <div class="col-lg-8">

                    <!-- Blog Post -->
                    <c:forEach var="p" items="${postagens}">
                        <!-- Title -->
                        <h1>${p.titulo}</h1>

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
                            ${p.texto}
                        </p>
                        <hr>
                        <!-- Blog Comments -->
                        <!-- Comments Form -->
                        <div class="well">
                            <h4>Deixe um comentário:</h4>
                            <form role="form">
                                <div class="form-group">
                                    Nome:
                                    <input type="text" name="nome" class="form-control" rows="3">
                                </div>
                                <div class="form-group">
                                    Comentário:
                                    <textarea class="form-control" rows="3"></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary">Enviar</button>
                            </form>
                        </div>
                        <hr>

                        <!-- Posted Comments -->
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
                    </c:forEach>
                </div>


                <!-- Blog Sidebar Widgets Column -->
                <div class="col-md-4">
                    <!-- form pesquisa -->
                    <div class="well">
                        <h4>Pesquisar</h4>
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div> <!-- /.input-group -->
                    </div>
                    <!--Lista de categorias-->
                    <div class="well">
                        <h4>Categorias</h4>
                        <div class="row">
                            <div class="col-lg-6">
                                <ul class="list-unstyled">
                                    <li><a href="#">Category Name</a>
                                    </li>
                                    <li><a href="#">Category Name</a>
                                    </li>
                                    <li><a href="#">Category Name</a>
                                    </li>
                                    <li><a href="#">Category Name</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-lg-6">
                                <ul class="list-unstyled">
                                    <li><a href="#">Category Name</a>
                                    </li>
                                    <li><a href="#">Category Name</a>
                                    </li>
                                    <li><a href="#">Category Name</a>
                                    </li>
                                    <li><a href="#">Category Name</a>
                                    </li>
                                </ul>
                            </div>
                        </div> <!-- /.row -->
                    </div>
                    <!-- Side Widget Well -->
                    <div class="well">
                        <h4>Sobre o autor</h4>
                        <p>Brasileiro, pai de Luiza Gomes.
                            Trabalha com informática desde 2006, estudou de Análise e Desenvolvimento de Sistemas.
                            Atualmente trabalha como Programador.
                            Gosta da futebol, música , cinema, e informática é sua paixão.</p>
                    </div>
                </div>
            </div>
        </div><!-- /.row -->
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; John Gomes 2015</p>
                </div>
            </div><!-- /.row -->
        </footer>
    </div><!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
