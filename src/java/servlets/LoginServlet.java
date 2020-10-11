
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 837033
 */
public class LoginServlet extends HttpServlet {
           
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("logout");
        if(action != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "You have successully logged out.");
        }
        
        if(session.getAttribute("login") == null ) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        request.setAttribute("username", session.getAttribute("login").toString());
        response.sendRedirect("/Week04Lab/home");             
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
