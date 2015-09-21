<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="templates/head.jsp" %>
        <script type="text/javascript" src="js/tinymce/tinymce.min.js"></script>
        <script type="text/javascript">
            tinymce.init({
                plugins: "preview, code, image, textcolor, emoticons",
                toolbar: "undo redo | bold italic |  fontsizeselect | forecolor backcolor | link image | preview | code | emoticons ",
                fontsize_formats: "8pt 10pt 12pt 14pt 18pt 24pt 36pt",
                language: "pt_BR",
                selector: "#mytextarea"

            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="templates/topo.jsp" %>

        <div class="row">
            <form action="editor" method="post">
                <div class="col-lg-9" style="width:60%;padding-left:3% ">
                    <h2>Editor</h2>

                    Título:
                    <input type="text" class="form-control" name="titulo" /><br/>

                    <textarea name="texto" style="height:250px;" id="mytextarea"></textarea>
                    <br/>

                    <button type="submit" class="btn btn-success">Publicar</button>
                    <button type="submit" class="btn btn-danger">Cancelar</button>

                </div>
                <div style="padding-top:5% " class="col-lg-3">

                    <p>Defina aqui o resumo que será exibido na página inicial</p>
                    Resumo:
                    <textarea name="resumo" class="form-control" style="height: 200px; width: 150%" ></textarea>
                </div>
            </form>
        </div>
        <%@include file="templates/rodape.jsp" %>
    </body> 
</html>
