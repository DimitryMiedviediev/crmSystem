package dao;

import entity.Claim;
import entity.Order;
import entity.Workorder;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();

    @Override
    public void createOrder(Order order) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_CREATE_ORDER(?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_product_id", order.getProductId());
            statement = frames.sqlIntegerNull(statement, "p_claim_id", order.getClaimId());

            statement.execute();
            if (statement.getInt("p_response_code") != 1) {
                throw new SQLException(statement.getString("p_response_message"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
    }

    @Override
    public Order getOrder(Integer orderId) throws IOException {
        Connection connection = connectionDB.getConnection();
        Order order = new Order();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_order WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.integerNVL(resultSet.getObject("product_id")),
                        frames.stringNVL(resultSet.getObject("product_title")),
                        frames.integerNVL(resultSet.getObject("product_title_price")),
                        frames.integerNVL(resultSet.getObject("product_count")),
                        frames.integerNVL(resultSet.getObject("final_price")),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.integerNVL(resultSet.getObject("workorder_id")),
                        frames.integerNVL(resultSet.getObject("workorder_code"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return order;
    }

    @Override
    public List<Order> getOrderList(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        List<Order> orderList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_order od WHERE od.claim_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, claim.getClaimId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.integerNVL(resultSet.getObject("product_id")),
                        frames.stringNVL(resultSet.getObject("product_title")),
                        frames.integerNVL(resultSet.getObject("product_title_price")),
                        frames.integerNVL(resultSet.getObject("product_count")),
                        frames.integerNVL(resultSet.getObject("final_price")),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.integerNVL(resultSet.getObject("workorder_id")),
                        frames.integerNVL(resultSet.getObject("workorder_code"))
                );
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return orderList;
    }

    @Override
    public List<Order> getOrderList(Workorder workorder) throws IOException {
        Connection connection = connectionDB.getConnection();
        List<Order> orderList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_order od WHERE od.workorder_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, workorder.getWorkorderId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.integerNVL(resultSet.getObject("product_id")),
                        frames.stringNVL(resultSet.getObject("product_title")),
                        frames.integerNVL(resultSet.getObject("product_title_price")),
                        frames.integerNVL(resultSet.getObject("product_count")),
                        frames.integerNVL(resultSet.getObject("final_price")),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.integerNVL(resultSet.getObject("workorder_id")),
                        frames.integerNVL(resultSet.getObject("workorder_code"))
                );
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return orderList;
    }

    @Override
    public void updateOrder(Order order) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_UPDATE_ORDER(?,?,?,?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_id", order.getOrderId());
            statement = frames.sqlIntegerNull(statement, "p_product_id", order.getProductId());
            statement = frames.sqlIntegerNull(statement, "p_product_count", order.getProductCount());
            statement = frames.sqlIntegerNull(statement, "p_final_price", order.getFinalPrice());
            statement = frames.sqlIntegerNull(statement, "p_claim_id", order.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_workorder_id", order.getWorkorderId());

            statement.execute();
            if (statement.getInt("p_response_code") != 1) {
                throw new SQLException(statement.getString("p_response_message"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
    }

    @Override
    public void deleteOrder(Order order) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_DELETE_ORDER(?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_id", order.getOrderId());

            statement.execute();
            if (statement.getInt("p_response_code") != 1) {
                throw new SQLException(statement.getString("p_response_message"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
    }
}
