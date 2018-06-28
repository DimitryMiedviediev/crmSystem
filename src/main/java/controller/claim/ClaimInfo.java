package controller.claim;

import dao.*;
import entity.*;
import logic.ControllerFrames;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(
        name = "Claim info",
        description = "This is claim_info servlet",
        urlPatterns = {"/claim_info"}
)
public class ClaimInfo extends HttpServlet {
    private Order order;
    private UserDAO userDAO = new UserDAOImpl();
    private UtilsDAO utilsDAO = new UtilsDAOImpl();
    private ClaimDAO claimDAO = new ClaimDAOImpl();
    private ProductDAO productDAO = new ProductDAOImpl();
    private CommentDAO commentDAO = new CommentDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();
    private StatusDAO statusDAO = new StatusDAOImpl();
    private ControllerFrames frames = new ControllerFrames();

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

        if (req.getParameter("NoConnectionButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Нет связи");
            commentDAO.createComment(comment);
//            statusDAO.claimSetStatusRecall(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            Claim claim = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
            claim.setDateReturnToNew(new Date(utilsDAO.getSysDate().getTime() + (1000 * 60 * 60)));
            statusDAO.claimSetStatusRecall(claim);
        }

        if (req.getParameter("NoAnswerButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Нет ответа");
            commentDAO.createComment(comment);
//            statusDAO.claimSetStatusRecall(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            Claim claim = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
            claim.setDateReturnToNew(new Date(utilsDAO.getSysDate().getTime() + (1000 * 60 * 60)));
            statusDAO.claimSetStatusRecall(claim);
        }

        if (req.getParameter("BusyButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Занято");
            commentDAO.createComment(comment);
//            statusDAO.claimSetStatusRecall(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            Claim claim = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
            claim.setDateReturnToNew(new Date(utilsDAO.getSysDate().getTime() + (1000 * 60 * 10)));
            statusDAO.claimSetStatusRecall(claim);
        }

        if (req.getParameter("ResetButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Сброс");
            commentDAO.createComment(comment);
//            statusDAO.claimSetStatusRecall(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            Claim claim = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
            claim.setDateReturnToNew(new Date(utilsDAO.getSysDate().getTime() + (1000 * 60 * 30)));
            statusDAO.claimSetStatusRecall(claim);
        }

        if (req.getParameter("RecallButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Перезвонить");
            commentDAO.createComment(comment);
            if (!req.getParameter("recall_time").equals("")) {
                Claim claim = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
                Date date = frames.getDateFromString(req.getParameter("recall_time"));
                claim.setDateReturnToNew(date);
                statusDAO.claimSetStatusRecall(claim);
            } else {
                Claim claim = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
                claim.setDateReturnToNew(new Date(utilsDAO.getSysDate().getTime() + (1000 * 60 * 60)));
                statusDAO.claimSetStatusRecall(claim);
            }
        }

        if (req.getParameter("SaveClientDataButton") != null) {
            Claim newClaimData = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
            newClaimData.setClientFIO(frames.stringNVL(req.getParameter("clientFIO")));
            newClaimData.setClientPhoneNumber(frames.stringNVL(req.getParameter("clientPhoneNumber")));
            newClaimData.setClientGender(frames.integerNVL(req.getParameter("genderId")));
            newClaimData.setClientAge(frames.integerNVL(req.getParameter("clientAge")));
            newClaimData.setCityId(frames.integerNVL(utilsDAO.getCityId(req.getParameter("cityTitle"))));
            newClaimData.setAddress(frames.stringNVL(req.getParameter("address")));
            newClaimData.setWarehouseId(frames.integerNVL(utilsDAO.getWarehouseId(req.getParameter("warehouseTitle"))));
            claimDAO.updateClaim(newClaimData);

            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            for (Order anOrderList : orderList) {
                Order order = orderDAO.getOrder(anOrderList.getOrderId());
                if (req.getParameter("productCount" + order.getOrderId()) != null && !req.getParameter("productCount" + order.getOrderId()).equals("")) {
                    order.setProductCount(Integer.parseInt(req.getParameter("productCount" + order.getOrderId())));
                }
                if (req.getParameter("productFinalPrice" + order.getOrderId()) != null && !req.getParameter("productFinalPrice" + order.getOrderId()).equals("")) {
                    order.setFinalPrice(Integer.parseInt(req.getParameter("productFinalPrice" + order.getOrderId())));
                }
                orderDAO.updateOrder(order);
            }

        }

        if (req.getParameter("ConsultButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Консультация");
            commentDAO.createComment(comment);

            claimDAO.setUserInClaim(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))), userDAO.getUser(Integer.valueOf(req.getParameter("user_id"))));
            statusDAO.claimSetStatusConsult(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        }

        if (req.getParameter("SendButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Отправить");
            commentDAO.createComment(comment);

//            System.out.println(req.getParameter("clientFIO"));

            // Если нажимаешь отравить - должны сохраняться данные клиента
            Claim newClaimData = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
            newClaimData.setClientFIO(frames.stringNVL(req.getParameter("clientFIO")));
            newClaimData.setClientPhoneNumber(frames.stringNVL(req.getParameter("clientPhoneNumber")));
            newClaimData.setClientGender(frames.integerNVL(req.getParameter("genderId")));
            newClaimData.setClientAge(frames.integerNVL(req.getParameter("clientAge")));
            newClaimData.setCityId(frames.integerNVL(utilsDAO.getCityId(req.getParameter("cityTitle"))));
            newClaimData.setAddress(frames.stringNVL(req.getParameter("address")));
            newClaimData.setWarehouseId(frames.integerNVL(utilsDAO.getWarehouseId(req.getParameter("warehouseTitle"))));
            claimDAO.updateClaim(newClaimData);

            // Если нажимаешь отравить - должны сохраняться продукты
            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            for (Order anOrderList : orderList) {
                Order order = orderDAO.getOrder(anOrderList.getOrderId());
                if (req.getParameter("productCount" + order.getOrderId()) != null && !req.getParameter("productCount" + order.getOrderId()).equals("")) {
                    order.setProductCount(Integer.parseInt(req.getParameter("productCount" + order.getOrderId())));
                }
                if (req.getParameter("productFinalPrice" + order.getOrderId()) != null && !req.getParameter("productFinalPrice" + order.getOrderId()).equals("")) {
                    order.setFinalPrice(Integer.parseInt(req.getParameter("productFinalPrice" + order.getOrderId())));
                }
                orderDAO.updateOrder(order);
            }

            statusDAO.claimSetStatusArchSuccess(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        }

        if (req.getParameter("CancelButton") != null && req.getParameter("refusing_reason_id") != null && !req.getParameter("refusing_reason_id").equals("")) {
            RefusingReason refusingReason = utilsDAO.getRefusingReasonById(Integer.parseInt(req.getParameter("refusing_reason_id")));
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Отмена - Причина: " + refusingReason.getRefusingReasonTitle());
            commentDAO.createComment(comment);

//            System.out.println(req.getParameter("clientFIO"));
//
//            // Если нажимаешь отравить - должны сохраняться данные клиента
//            Claim newClaimData = claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")));
//            newClaimData.setClientFIO(frames.stringNVL(req.getParameter("clientFIO")));
//            newClaimData.setClientPhoneNumber(frames.stringNVL(req.getParameter("clientPhoneNumber")));
//            newClaimData.setClientGender(frames.integerNVL(req.getParameter("genderId")));
//            newClaimData.setClientAge(frames.integerNVL(req.getParameter("clientAge")));
//            newClaimData.setCityId(frames.integerNVL(utilsDAO.getCityId(req.getParameter("cityTitle"))));
//            newClaimData.setAddress(frames.stringNVL(req.getParameter("address")));
//            newClaimData.setWarehouseId(frames.integerNVL(utilsDAO.getWarehouseId(req.getParameter("warehouseTitle"))));
//            claimDAO.updateClaim(newClaimData);
//
//            // Если нажимаешь отравить - должны сохраняться продукты
//            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
//            for (Order anOrderList : orderList) {
//                Order order = orderDAO.getOrder(anOrderList.getOrderId());
//                if (req.getParameter("productCount" + order.getOrderId()) != null && !req.getParameter("productCount" + order.getOrderId()).equals("")) {
//                    order.setProductCount(Integer.parseInt(req.getParameter("productCount" + order.getOrderId())));
//                }
//                if (req.getParameter("productFinalPrice" + order.getOrderId()) != null && !req.getParameter("productFinalPrice" + order.getOrderId()).equals("")) {
//                    order.setFinalPrice(Integer.parseInt(req.getParameter("productFinalPrice" + order.getOrderId())));
//                }
//                orderDAO.updateOrder(order);
//            }

            statusDAO.claimSetStatusArchFail(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        }

        if (req.getParameter("TrashButton") != null && req.getParameter("refusing_reason_id") != null && !req.getParameter("refusing_reason_id").equals("")) {
            RefusingReason refusingReason = utilsDAO.getRefusingReasonById(Integer.parseInt(req.getParameter("refusing_reason_id")));
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Треш - Причина: " + refusingReason.getRefusingReasonTitle());
            commentDAO.createComment(comment);

            //claimDAO.setUserInClaim(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))), userDAO.getUser(Integer.valueOf(req.getParameter("user_id"))));

            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            for (Order anOrderList : orderList) {
                Order order = orderDAO.getOrder(anOrderList.getOrderId());
                orderDAO.deleteOrder(order);
            }

            statusDAO.claimSetStatusTrash(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        }

        if (req.getParameter("DoubleButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Дубль");
            commentDAO.createComment(comment);

            claimDAO.setUserInClaim(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))), userDAO.getUser(Integer.valueOf(req.getParameter("user_id"))));

            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            for (Order anOrderList : orderList) {
                Order order = orderDAO.getOrder(anOrderList.getOrderId());
                orderDAO.deleteOrder(order);
            }

            statusDAO.claimSetStatusDouble(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        }

        if (req.getParameter("DeleteProductButton") != null) {
            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            for (Order anOrderList : orderList) {
                Order order = orderDAO.getOrder(anOrderList.getOrderId());
                if (req.getParameter("productCount" + order.getOrderId()) != null && !req.getParameter("productCount" + order.getOrderId()).equals("")) {
                    order.setProductCount(Integer.parseInt(req.getParameter("productCount" + order.getOrderId())));
                }
                if (req.getParameter("productFinalPrice" + order.getOrderId()) != null && !req.getParameter("productFinalPrice" + order.getOrderId()).equals("")) {
                    order.setFinalPrice(Integer.parseInt(req.getParameter("productFinalPrice" + order.getOrderId())));
                }
                orderDAO.updateOrder(order);
            }
            orderDAO.deleteOrder(orderDAO.getOrder(Integer.parseInt(req.getParameter("DeleteProductButton"))));
        }

//        if (req.getParameter("SaveProductsButton") != null) {
//            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
//            for (Order anOrderList : orderList) {
//                Order order = orderDAO.getOrder(anOrderList.getOrderId());
//                if (req.getParameter("productCount" + order.getOrderId()) != null && !req.getParameter("productCount" + order.getOrderId()).equals("")) {
//                    order.setProductCount(Integer.parseInt(req.getParameter("productCount" + order.getOrderId())));
//                }
//                if (req.getParameter("productFinalPrice" + order.getOrderId()) != null && !req.getParameter("productFinalPrice" + order.getOrderId()).equals("")) {
//                    order.setFinalPrice(Integer.parseInt(req.getParameter("productFinalPrice" + order.getOrderId())));
//                }
//                orderDAO.updateOrder(order);
//            }
//        }

        if (req.getParameter("AddProductButton") != null && !req.getParameter("productId").equals("")) {
            List<Order> orderList = orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
            for (Order anOrderList : orderList) {
                Order order = orderDAO.getOrder(anOrderList.getOrderId());
                if (req.getParameter("productCount" + order.getOrderId()) != null && !req.getParameter("productCount" + order.getOrderId()).equals("")) {
                    order.setProductCount(Integer.parseInt(req.getParameter("productCount" + order.getOrderId())));
                }
                if (req.getParameter("productFinalPrice" + order.getOrderId()) != null && !req.getParameter("productFinalPrice" + order.getOrderId()).equals("")) {
                    order.setFinalPrice(Integer.parseInt(req.getParameter("productFinalPrice" + order.getOrderId())));
                }
                orderDAO.updateOrder(order);
            }
            Order order = new Order();
            order.setClaimId(Integer.parseInt(req.getParameter("claim_id")));
            order.setProductId(Integer.parseInt(req.getParameter("productId")));
            orderDAO.createOrder(order);
        }

        if (req.getParameter("ChangeOperator") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Назначен новый оператор : " + userDAO.getUser(Integer.valueOf(req.getParameter("operatorId"))).getFio());
            commentDAO.createComment(comment);
            claimDAO.changeUserInClaim(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))), userDAO.getUser(Integer.valueOf(req.getParameter("operatorId"))));
        }

        if (req.getParameter("AnnihilateClaimButton") != null) {
            RefusingReason refusingReason = utilsDAO.getRefusingReasonById(25);
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Отмена - Причина: " + refusingReason.getRefusingReasonTitle());
            commentDAO.createComment(comment);

            statusDAO.claimSetStatusArchFail(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        }

        if (req.getParameter("BackToNewClaimButton") != null) {
            Comment comment = new Comment();
            comment.setClaimId(Integer.valueOf(req.getParameter("claim_id")));
            comment.setUserId(Integer.valueOf(req.getParameter("user_id")));
            comment.setCommentText("Возврат заявки из статуса Архив(отказ)");
            commentDAO.createComment(comment);

            statusDAO.claimSetStatusNew(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        }

        req.setAttribute("orderList", orderDAO.getOrderList(claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id")))));
        req.setAttribute("productList", productDAO.getProductList());
        req.setAttribute("headerInfo", utilsDAO.getHeaderInfo(Integer.parseInt(req.getParameter("claim_id"))));
        req.setAttribute("userInfo", (User) session.getAttribute("UserInfo"));
        req.setAttribute("userList", userDAO.getUserList());
        req.setAttribute("commentList", commentDAO.getCommentListByClaimId(Integer.parseInt(req.getParameter("claim_id"))));
        req.setAttribute("cityList", utilsDAO.getCityList());
        req.setAttribute("refusingReasonList", utilsDAO.getRefusingReasonList());
        req.setAttribute("refusingReasonTrashList", utilsDAO.getRefusingReasonTrashList());
        req.setAttribute("refusingReasonCancelList", utilsDAO.getRefusingReasonCancelList());
        req.setAttribute("claimInfo", claimDAO.getClaim(Integer.parseInt(req.getParameter("claim_id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/claim/claim_info.jsp");
        dispatcher.forward(req, resp);
    }
}
