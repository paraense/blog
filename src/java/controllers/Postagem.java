package controllers;

import banco.ConexaoJDBC;
import beans.Categoria;
import beans.Comentario;
import beans.Post;
import dao.PostagemDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author John
 */
@WebServlet("/postagem")
public class Postagem extends HttpServlet {

    Connection c = null;
    PostagemDao pd;
    Post postagem;
    Categoria categoria;
    Comentario comentario;
    ResultSet resultado;
    List<Post> posts;
    List<ComentarioServlet> comentarios;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            pd = new PostagemDao();
            posts = new ArrayList<>();

            //Realiza busca da postagem por ID
            resultado = pd.getPostagem(id);
            while (resultado.next()) {
                postagem = new Post();
                postagem.setId(resultado.getInt("id"));
                postagem.setTitulo(resultado.getString("titulo"));
                postagem.setTexto(resultado.getString("texto"));
                postagem.setData(resultado.getDate("data"));

                //Realiza a busca dos comentários
                ResultSet rsc = pd.getComentarios(id);
                while (rsc.next()) {
                    comentario = new Comentario();
                    comentario.setNome(rsc.getString("nome"));
                    comentario.setTexto(rsc.getString("texto"));
                    comentario.setDatahora(rsc.getDate("data"));

                    postagem.getComentarios().add(comentario);
                }
                
                posts.add(postagem);
            }
            req.setAttribute("postagens", posts);
            resultado.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            

        }

        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);

    }

}
