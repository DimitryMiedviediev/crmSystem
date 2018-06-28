package controller.included;

import dao.CommentDAO;
import dao.CommentDAOImpl;
import entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(
        name = "Comment servlet",
        description = "This is comment_text servlet",
        urlPatterns = {"/CommentServlet"}
)
public class ActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CommentDAO commentDAO = new CommentDAOImpl();

    public ActionServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=ISO-8859-1");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("ISO-8859-1");
        PrintWriter out = resp.getWriter();

        Comment comment = new Comment();
        comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
        comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
        comment.setCommentText(req.getParameter("comment_text"));
        commentDAO.createComment(comment);

        List<Comment> commentList = commentDAO.getCommentListByClaimId(Integer.valueOf(req.getParameter("claim_id")));
//        System.out.println(commentList);

        out.println("<div>");
        out.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">");
        out.println("<tbody>");
        for (int i = 0; i < commentList.size(); i++){
            out.println("<tr>");
            out.println("<th>" + commentList.get(i).getRowNumber() + "</th>");
            out.println("<th>" + commentList.get(i).getCommentText() + "</th>");
            out.println("<th>" + commentList.get(i).getDateCreate() + "</th>");
            out.println("<th>" + commentList.get(i).getUserFIO() + "</th>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
