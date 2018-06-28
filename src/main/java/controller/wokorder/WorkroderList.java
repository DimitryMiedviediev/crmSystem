package controller.wokorder;

import dao.ClaimDAO;
import dao.ClaimDAOImpl;
import dao.UtilsDAO;
import dao.UtilsDAOImpl;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "Workorder list",
        description = "This is workorder_list servlet",
        urlPatterns = {"/workorder_list"}
)
public class WorkroderList extends HttpServlet {

    private UtilsDAO utilsDAO = new UtilsDAOImpl();
    private ClaimDAO claimDAO = new ClaimDAOImpl();

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
            if (user == null) {
                resp.sendRedirect("authorization");
                return;
            }
        } catch (NullPointerException e) {
            resp.sendRedirect("authorization");
            return;
        }

        if (req.getParameter("claim_status") != null && req.getParameter("claim_status").equals("New")) {
            req.setAttribute("claimList", claimDAO.getClaimListNew());
        } else if (req.getParameter("claim_status") != null && req.getParameter("claim_status").equals("Recall")) {
            req.setAttribute("claimList", claimDAO.getClaimListRecall());
        } else if (req.getParameter("claim_status") != null && req.getParameter("claim_status").equals("Consult")) {
            req.setAttribute("claimList", claimDAO.getClaimListConsult());
        } else if (req.getParameter("claim_status") != null && req.getParameter("claim_status").equals("ArchSuccess")) {
            req.setAttribute("claimList", claimDAO.getClaimListArchSuccess());
        } else if (req.getParameter("claim_status") != null && req.getParameter("claim_status").equals("ArchFail")) {
            req.setAttribute("claimList", claimDAO.getClaimListArchFail());
        } else if (req.getParameter("claim_status") != null && req.getParameter("claim_status").equals("Trash")) {
            req.setAttribute("claimList", claimDAO.getClaimListTrash());
        } else if (req.getParameter("claim_status") != null && req.getParameter("claim_status").equals("Double")) {
            req.setAttribute("claimList", claimDAO.getClaimListDouble());
        } else {
            req.setAttribute("claimList", claimDAO.getClaimListNew());
        }

        req.setAttribute("claimsCount", utilsDAO.getCountClaim());
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/claim/claim_list.jsp");
        dispatcher.forward(req, resp);
    }
}
