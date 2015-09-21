package servlets;

import entidades.Post;
import dao.PostagemDao;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author john
 */
@WebServlet(urlPatterns = "/busca")
public class BuscaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostagemDao pd = new PostagemDao();
        ResultSet resultado = pd.buscaPorSimilaridade(req.getParameter("filtro"));

        try {
            List<Post> postagens = new ArrayList<>();
            postagens = pd.listarPostagens(resultado);

            if (!postagens.isEmpty()) {
                req.setAttribute("postagens", postagens);
                RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
                rd.forward(req, resp);
                System.out.println("postagens encontradas: "+ postagens.size());

            } else {
                PrintWriter w = resp.getWriter();
                w.write("Nenhum resultado");

            }

        } catch (Exception e) {
        }

    }

}
