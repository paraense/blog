package servlets;

import dao.UsuarioDao;
import entidades.Usuario;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author John
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    UsuarioDao ud;
    ResultSet resultado;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ud = new UsuarioDao();
        Usuario usuario;
        try {
            resultado = ud.validaUsuario(req.getParameter("login"), req.getParameter("senha"));

            if (resultado.next()) {
                usuario = new Usuario();
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));

                Cookie c = new Cookie("usuario", usuario.getLogin());
                resp.addCookie(c);
                
              
            } else {
                System.out.println("Nenhum usuário encontrado");
            }

            resp.sendRedirect("editor");
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()+"###ERRO").log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("******CAIU NO FINALLY****");
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
