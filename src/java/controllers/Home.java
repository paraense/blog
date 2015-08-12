package controllers;

import beans.Categoria;
import beans.Comentario;
import beans.Post;
import dao.HomeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/principal")
public class Home extends HttpServlet {

    Post postagem;
    Categoria categoria;
    Comentario comentario;
    List<Post> posts;
    List<Comentario> comentarios;
    List<Categoria> categorias;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeDao hd = new HomeDao();
        posts = new ArrayList<>();
        categorias = new ArrayList<>();

        try {
            //Carregar postagens
            ResultSet postagens = hd.listarPostagens();
            while (postagens.next()) {
                postagem = new Post();
                postagem.setTitulo(postagens.getString("titulo"));
                postagem.setTexto(postagens.getString("texto"));

                //Carrega comentários
                ResultSet coment = hd.listarComentarios(String.valueOf(postagens.getInt("id")));
                if (coment != null) {

                    while (coment.next()) {
                        comentario = new Comentario();
                        comentario.setNome(coment.getString("nome"));
                        comentario.setEmail(coment.getString("email"));
                        comentario.setTexto(coment.getString("texto"));
                        comentario.setDatahora(coment.getDate("data"));
                        postagem.getComentarios().add(comentario);
                    }
                }
                posts.add(postagem);
            }
          
            //lista categorias
            ResultSet cat = hd.listarCategorias();
            while (cat.next()) {
                categoria = new Categoria();
                categoria.setNome(cat.getString("nome"));
                categorias.add(categoria);
            }

            //fecha conexão
            hd.fechaConexao();
            req.setAttribute("postagens", posts);
            System.out.println("Número de postagens: " + posts.size());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);

    }

}
