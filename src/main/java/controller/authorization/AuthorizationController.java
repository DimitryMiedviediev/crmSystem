package controller.authorization;

import entity.User;
import service.AuthenticationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "Authorization",
        description = "This is authorization servlet",
        urlPatterns = {"/authorization"}
)
public class AuthorizationController extends HttpServlet {

    private AuthenticationService authenticationService = new AuthenticationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(true);
        try {
            User user = (User) session.getAttribute("UserInfo");
            if (user != null) {
                resp.sendRedirect("claim_list");
                return;
            }
        } catch (NullPointerException ignored) {
        }

        if (req.getParameter("SignIn") != null) {
            Boolean bool = authenticationService.validateUser(req.getParameter("login"), req.getParameter("password"));
            User userInfo = authenticationService.getUserInfo(req.getParameter("login"));
            if (bool) {
                session.setAttribute("UserInfo", userInfo);
                resp.sendRedirect("claim_list?claim_status=New");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/authentication/authorization.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/authentication/authorization.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
