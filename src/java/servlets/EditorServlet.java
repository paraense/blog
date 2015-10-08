/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.PostagemDao;
import java.io.IOException;
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
@WebServlet(urlPatterns = "/editor")
public class EditorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/admin/editor.jsp");
        rd.forward(req, resp);
    
    }
   
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostagemDao pd = new PostagemDao();
        //encode para acentuação
        req.setCharacterEncoding("UTF8");
        resp.sendRedirect(pd.incluirPost(req.getParameter("texto"), req.getParameter("titulo"), req.getParameter("resumo")));
    }
    
    
    
}
