/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
    PostagemDao pd = new PostagemDao();
    Post postagem;
    Categoria categoria;
    Comentario comentario;
    List<Post> posts;
    List<ComentarioServlet> comentarios;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("id postagem"+ id);
        try {
            pd = new PostagemDao();
            ResultSet rs = pd.getPostagem(id);
            posts = new ArrayList<>();
            while (rs.next()) {
                postagem = new Post();
                postagem.setTitulo(rs.getString("titulo"));
                postagem.setTexto(rs.getString("texto"));
                postagem.setData(rs.getDate("data"));
                System.out.println("postagem: "+ postagem.getTitulo());

                ResultSet rsc = pd.getComentarios(id);

                while (rsc.next()) {
                    comentario = new Comentario();
                    comentario.setNome(rsc.getString("nome"));
                    comentario.setTexto(rsc.getString("texto"));
                    comentario.setDatahora(rsc.getDate("data"));
                    
                    System.out.println("Comentário: "+ comentario.getNome());
                    
                    postagem.getComentarios().add(comentario);
                }
                posts.add(postagem);
                System.out.println("número de comentarios de comentários: "+posts.get(0).getComentarios().size());
               
              req.setAttribute("postagens", posts);
              
            }

        } catch (Exception e) {
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);
        

    }

}
