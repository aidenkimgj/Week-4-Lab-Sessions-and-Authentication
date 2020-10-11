
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 837033
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            String userName = session.getAttribute("login").toString();
            User user = new User();
            user.setUsername(userName);
            request.setAttribute("username", user);
        
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        response.sendRedirect("/Week04Lab/login");
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountService service = new AccountService();
        User user = service.login(request.getParameter("username"), request.getParameter("password"));
        if(user == null) {
            request.setAttribute("message", "Invalid login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        session.setAttribute("login", user);
        request.setAttribute("username", user);  
            
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
