package controllers;

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
    List<Post> posts;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeDao hd = new HomeDao();
        posts = new ArrayList<>();

        try {
            ResultSet postagens = hd.listarPostagens();
            while (postagens.next()) {
                postagem = new Post();
                postagem.setTitulo(postagens.getString("titulo"));
                postagem.setTexto(postagens.getString("texto"));
                posts.add(postagem);
            }
            hd.fechaConexao();
            req.setAttribute("postagens", posts);
            System.out.println("Número de postagens: "+posts.size());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);

    }

}
