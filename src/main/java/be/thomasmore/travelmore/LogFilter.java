package be.thomasmore.travelmore;

import be.thomasmore.travelmore.controller.GebruikerController;
import be.thomasmore.travelmore.domain.Gebruiker;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Timestamp;
import java.util.Date;
import java.util.Map;

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {
    @Inject
    private GebruikerController gebruikerController;
    public void destroy() {
    }
    private ServletContext context;
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        GebruikerController user =  (GebruikerController)request.getSession().getAttribute("GebruikerController");
/*        this.context.log((user.getAangemeldeGebruiker().getNaam()));*/
        this.context.log(("DIT IS EEN TEST " + gebruikerController.getAangemeld().toString()));
        System.out.println(gebruikerController.getAangemeld());
/*        this.context.log("DIT IS VAN DE INJECT" + gebruikerController.getAangemeldeGebruiker().getNaam());*/
        if(!user.getAangemeld()){ //If user is already authenticated
            response.sendRedirect("/travelmore/index.xhtml");
        } else{
            chain.doFilter(req, resp);
        }
    }
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

}
