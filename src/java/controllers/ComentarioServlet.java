package controllers;

import dao.ComentarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author john
 */
@WebServlet(urlPatterns = "/comentario/incluir")
public class ComentarioServlet extends HttpServlet {

    ComentarioDao cd = new ComentarioDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String texto = req.getParameter("texto");
        String post = req.getParameter("id_post");
        String email = req.getParameter("email");
        String status= "";
        

        try {
           status =  cd.SalvarComentario(nome, email, texto, post);
           resp.sendRedirect("/blog/postagem?id="+post);
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
//        PrintWriter w = resp.getWriter();
//        System.out.println(nome + "" + texto);
//        w.print("<html><body>"+status+"</body></html>");
        
       
        
//        PrintWriter w = resp.getWriter();
//        System.out.println(nome + "" + texto);
//        w.print("<html><body>"+status+"</body></html>");

    }

}
