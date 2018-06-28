package dao;

import entity.Claim;
import entity.Order;
import entity.Workorder;

import java.io.IOException;
import java.util.List;

public interface OrderDAO {

    void createOrder(Order order) throws IOException;

    Order getOrder(Integer orderId) throws IOException;

    List<Order> getOrderList(Claim claim) throws IOException;

    List<Order> getOrderList(Workorder workorder) throws IOException;

    void updateOrder(Order order) throws IOException;

    void deleteOrder(Order order) throws IOException;

}
