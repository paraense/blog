package servlets;

import banco.ConexaoJDBC;
import entidades.Categoria;
import entidades.Comentario;
import entidades.Post;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PostagemDao pd = new PostagemDao();
            req.setAttribute("postagens", pd.listarPostagens(pd.buscaPostagemPorId(req.getParameter("id"))));

        } catch (Exception e) {
        }

        RequestDispatcher rd = req.getRequestDispatcher("/postagem.jsp");
        rd.forward(req, resp);

    }

}
