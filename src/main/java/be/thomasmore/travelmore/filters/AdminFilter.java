package be.thomasmore.travelmore.filters;

import be.thomasmore.travelmore.controller.GebruikerController;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        GebruikerController user =  (GebruikerController)request.getSession().getAttribute("GebruikerController");
        if(user.getAangemeldeGebruiker().getSoortGebruiker().getId() == 1){ //If user is already authenticated
            response.sendRedirect("/travelmore/admin/boekingen.xhtml");
        } else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
