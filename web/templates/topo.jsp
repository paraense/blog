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
            <a class="navbar-brand" href="/blog">Blog do John</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="autor.jsp">Sobre o autor</a>
                </li>
                <li>
                    <a href="sobre.jsp">Sobre o Blog</a>
                </li>
                <li>
                    <a href="#">Contato</a>
                </li>
            </ul>

            <form action="busca" class="navbar-form navbar-right" role="search">
                <div class="input-group" style="width: 300px;" >
                    <input type="text" name="filtro" class="form-control" placeholder="Pesquisar">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div> <!-- /.input-group -->
            </form>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

