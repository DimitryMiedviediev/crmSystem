package API;

import dao.ClaimDAO;
import dao.ClaimDAOImpl;
import entity.Claim;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "API",
        description = "This is api servlet",
        urlPatterns = {"/create_claim"}
)
public class APIForClaim extends HttpServlet {

    private ClaimDAO claimDAO = new ClaimDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (req.getParameter("name") != null && req.getParameter("phone") != null && req.getParameter("advertising_source_id") != null) {
            Claim newClaim = new Claim(req.getParameter("name"), req.getParameter("phone"), Integer.parseInt(req.getParameter("advertising_source_id")));
            claimDAO.createClaim(newClaim);

            resp.sendRedirect("http://188.166.147.232:8090/minusize/1");
        } else {
            resp.sendRedirect("http://188.166.147.232:8090/minusize/1");
        }
    }
}
