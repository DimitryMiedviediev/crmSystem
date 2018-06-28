package controller.utils;

import com.fasterxml.jackson.databind.JsonNode;
import dao.ClaimDAO;
import dao.ClaimDAOImpl;
import entity.Claim;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;

@WebServlet(
        name = "Create Claim",
        description = "Claim servlet",
        urlPatterns = {"/createClaim"}
)
public class NewClaim extends HttpServlet {

    private ClaimDAO claimDAO = new ClaimDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        if (req.getParameter("Create") != null) {
            if (req.getParameter("fio") != null && req.getParameter("phone_number") != null && req.getParameter("advertising_source_id") != null) {
                Claim newClaim = new Claim(req.getParameter("fio"), req.getParameter("phone_number"), Integer.parseInt(req.getParameter("advertising_source_id")));
                claimDAO.createClaim(newClaim);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/utils/create_claim.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/utils/create_claim.jsp");
            dispatcher.forward(req, resp);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("view/utils/create_claim.jsp");
        dispatcher.forward(req, resp);
    }
}
