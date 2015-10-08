package servlets;

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
@WebServlet(urlPatterns = "/comentario")
public class ComentarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ComentarioDao cd = new ComentarioDao();
            cd.inserirComentario(req.getParameter("nome"), req.getParameter("email"),
                    req.getParameter("texto"), req.getParameter("id_post"));

            resp.sendRedirect("/blog/postagem?id=" + req.getParameter("id_post"));

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
