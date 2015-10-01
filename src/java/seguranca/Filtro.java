/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguranca;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author John
 */
@WebFilter(urlPatterns = "/editor")
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Cookie[] c = req.getCookies();
        if (c != null) {
            System.out.println("Entrou aqui");
            for (Cookie cookie : c) {
                if (cookie.getName().equals("usuario")) {
                    //chama a página
                    System.out.println(cookie.getValue());
                    chain.doFilter(request, response);
                    return;
                }
            }
            resp.sendRedirect("login.jsp");
            System.out.println("Não tem ninguém logado chama página e login");
            return;
         
        } 
        System.out.println("Nâo encontrou nenhum cookie na sessão");
        
    }

    @Override
    public void destroy() {
    }

}
