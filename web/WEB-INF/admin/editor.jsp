<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/blog-post.css" rel="stylesheet">

        <!-- Favicon -->
        <link rel="icon" href="img/favicon-java.png" />

        <script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/templates/topo.jsp" %>
        <div class="container" style="padding-top: 2%">
            <div class="row">
                <form action="editor" method="post">
                    <div class="col-lg-12">
                        <h3>Postagem</h3>

                        Título:
                        <input type="text" class="form-control" name="titulo" /><br/>

                        <textarea name="texto" style="height:900px;" id="myeditor"></textarea>
                        <br/>

                        <button type="submit" class="btn btn-success">Publicar</button>
                        <button type="submit" class="btn btn-danger">Cancelar</button>
                    </div>
                    <script>
                        CKEDITOR.replace('myeditor');
                    </script>
                </form>
            </div>
        </div>

    </body> 
</html>
