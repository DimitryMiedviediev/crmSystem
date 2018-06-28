package dao;

import entity.Claim;
import entity.User;
import entity.Workorder;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkorderDAOImpl implements WorkorderDAO {
    ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();

    @Override
    public void createWorkorder(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_CREATE_WORKORDER(?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());

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
    public Workorder getWorkorder(Integer id) throws IOException {
        Connection connection = connectionDB.getConnection();
        Workorder workorder = new Workorder();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_workorder WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                workorder = new Workorder(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.integerNVL(resultSet.getObject("code")),
                        resultSet.getDate("date_create"),
                        resultSet.getDate("date_close"),
                        frames.stringNVL(resultSet.getObject("postal_invoice_number")),
                        frames.integerNVL(resultSet.getObject("workorder_current_user_id")),
                        frames.stringNVL(resultSet.getObject("workorder_current_user_title")),
                        frames.integerNVL(resultSet.getObject("claim_current_user_id")),
                        frames.stringNVL(resultSet.getObject("claim_current_user_title")),
                        frames.integerNVL(resultSet.getObject("status_id")),
                        frames.stringNVL(resultSet.getObject("status_title")),
                        frames.integerNVL(resultSet.getObject("priority_id")),
                        frames.stringNVL(resultSet.getObject("priority_title")),
                        frames.stringNVL(resultSet.getObject("product_title")),
                        frames.stringNVL(resultSet.getObject("client_fio")),
                        frames.stringNVL(resultSet.getObject("client_phone_number")),
                        frames.integerNVL(resultSet.getObject("city_id")),
                        frames.stringNVL(resultSet.getObject("city_title")),
                        frames.integerNVL(resultSet.getObject("warehouse_id")),
                        frames.stringNVL(resultSet.getObject("warehouse_title")),
                        frames.stringNVL(resultSet.getObject("address")),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.stringNVL(resultSet.getObject("last_comment"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return workorder;
    }

    @Override
    public void setWorkorderCurrentUser(Workorder workorder) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_WORKORDER_CURRENT_USER(?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_id", workorder.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_current_user_id", workorder.getWorkorderCurrentUserId());

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
    public void setWorkorderStatus(Workorder workorder) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_WORKORDER_STATUS(?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_id", workorder.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", workorder.getStatusId());

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
    public void setWorkorderPostalInvoiceNumber(Workorder workorder) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_WORKORDER_STATUS(?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_id", workorder.getClaimId());
            statement = frames.sqlStringNull(statement, "p_postal_invoice_number", workorder.getPostalInvoiceNumber());

            statement.execute();
            if (statement.getInt("p_response_code") != 1) {
                throw new SQLException(statement.getString("p_response_message"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
    }
//
//    @Override
//    public List<Claim> getClaimListNew() throws IOException {
//        Connection connection = connectionDB.getConnection();
//        List<Claim> claimList = new ArrayList<>();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_claim cl WHERE cl.status_id = 3");
//            while (resultSet.next()) {
//                Claim claim = new Claim(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.integerNVL(resultSet.getObject("code")),
//                        resultSet.getTimestamp("date_create"),
//                        resultSet.getTimestamp("date_close"),
//                        frames.integerNVL(resultSet.getObject("current_user_id")),
//                        frames.stringNVL(resultSet.getObject("current_user_title")),
//                        frames.integerNVL(resultSet.getObject("status_id")),
//                        frames.stringNVL(resultSet.getObject("status_title")),
//                        frames.integerNVL(resultSet.getObject("priority_id")),
//                        frames.stringNVL(resultSet.getObject("priority_title")),
//                        frames.integerNVL(resultSet.getObject("refusing_reason_id")),
//                        frames.stringNVL(resultSet.getObject("refusing_reason_title")),
//                        frames.integerNVL(resultSet.getObject("advertising_source_id")),
//                        frames.stringNVL(resultSet.getObject("advertising_source_title")),
//                        frames.stringNVL(resultSet.getObject("product_title")),
//                        frames.stringNVL(resultSet.getObject("client_fio")),
//                        frames.stringNVL(resultSet.getObject("client_phone_number")),
//                        frames.integerNVL(resultSet.getObject("client_age")),
//                        frames.integerNVL(resultSet.getObject("client_gender")),
//                        frames.integerNVL(resultSet.getObject("city_id")),
//                        frames.stringNVL(resultSet.getObject("city_title")),
//                        frames.integerNVL(resultSet.getObject("warehouse_id")),
//                        frames.stringNVL(resultSet.getObject("warehouse_title")),
//                        frames.stringNVL(resultSet.getObject("address")),
//                        frames.integerNVL(resultSet.getObject("workorder_id")),
//                        frames.integerNVL(resultSet.getObject("workorder_code")),
//                        frames.stringNVL(resultSet.getObject("last_comment"))
//                );
//                claimList.add(claim);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//        return claimList;
//    }
//
//    @Override
//    public List<Claim> getClaimListRecall() throws IOException {
//        Connection connection = connectionDB.getConnection();
//        List<Claim> claimList = new ArrayList<>();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_claim cl WHERE cl.status_id = 4");
//            while (resultSet.next()) {
//                Claim claim = new Claim(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.integerNVL(resultSet.getObject("code")),
//                        resultSet.getTimestamp("date_create"),
//                        resultSet.getTimestamp("date_close"),
//                        frames.integerNVL(resultSet.getObject("current_user_id")),
//                        frames.stringNVL(resultSet.getObject("current_user_title")),
//                        frames.integerNVL(resultSet.getObject("status_id")),
//                        frames.stringNVL(resultSet.getObject("status_title")),
//                        frames.integerNVL(resultSet.getObject("priority_id")),
//                        frames.stringNVL(resultSet.getObject("priority_title")),
//                        frames.integerNVL(resultSet.getObject("refusing_reason_id")),
//                        frames.stringNVL(resultSet.getObject("refusing_reason_title")),
//                        frames.integerNVL(resultSet.getObject("advertising_source_id")),
//                        frames.stringNVL(resultSet.getObject("advertising_source_title")),
//                        frames.stringNVL(resultSet.getObject("product_title")),
//                        frames.stringNVL(resultSet.getObject("client_fio")),
//                        frames.stringNVL(resultSet.getObject("client_phone_number")),
//                        frames.integerNVL(resultSet.getObject("client_age")),
//                        frames.integerNVL(resultSet.getObject("client_gender")),
//                        frames.integerNVL(resultSet.getObject("city_id")),
//                        frames.stringNVL(resultSet.getObject("city_title")),
//                        frames.integerNVL(resultSet.getObject("warehouse_id")),
//                        frames.stringNVL(resultSet.getObject("warehouse_title")),
//                        frames.stringNVL(resultSet.getObject("address")),
//                        frames.integerNVL(resultSet.getObject("workorder_id")),
//                        frames.integerNVL(resultSet.getObject("workorder_code")),
//                        frames.stringNVL(resultSet.getObject("last_comment"))
//                );
//                claimList.add(claim);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//        return claimList;
//    }
//
//    @Override
//    public List<Claim> getClaimListConsult() throws IOException {
//        Connection connection = connectionDB.getConnection();
//        List<Claim> claimList = new ArrayList<>();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_claim cl WHERE cl.status_id = 5");
//            while (resultSet.next()) {
//                Claim claim = new Claim(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.integerNVL(resultSet.getObject("code")),
//                        resultSet.getTimestamp("date_create"),
//                        resultSet.getTimestamp("date_close"),
//                        frames.integerNVL(resultSet.getObject("current_user_id")),
//                        frames.stringNVL(resultSet.getObject("current_user_title")),
//                        frames.integerNVL(resultSet.getObject("status_id")),
//                        frames.stringNVL(resultSet.getObject("status_title")),
//                        frames.integerNVL(resultSet.getObject("priority_id")),
//                        frames.stringNVL(resultSet.getObject("priority_title")),
//                        frames.integerNVL(resultSet.getObject("refusing_reason_id")),
//                        frames.stringNVL(resultSet.getObject("refusing_reason_title")),
//                        frames.integerNVL(resultSet.getObject("advertising_source_id")),
//                        frames.stringNVL(resultSet.getObject("advertising_source_title")),
//                        frames.stringNVL(resultSet.getObject("product_title")),
//                        frames.stringNVL(resultSet.getObject("client_fio")),
//                        frames.stringNVL(resultSet.getObject("client_phone_number")),
//                        frames.integerNVL(resultSet.getObject("client_age")),
//                        frames.integerNVL(resultSet.getObject("client_gender")),
//                        frames.integerNVL(resultSet.getObject("city_id")),
//                        frames.stringNVL(resultSet.getObject("city_title")),
//                        frames.integerNVL(resultSet.getObject("warehouse_id")),
//                        frames.stringNVL(resultSet.getObject("warehouse_title")),
//                        frames.stringNVL(resultSet.getObject("address")),
//                        frames.integerNVL(resultSet.getObject("workorder_id")),
//                        frames.integerNVL(resultSet.getObject("workorder_code")),
//                        frames.stringNVL(resultSet.getObject("last_comment"))
//                );
//                claimList.add(claim);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//        return claimList;
//    }
//
//    @Override
//    public List<Claim> getClaimListArchSuccess() throws IOException {
//        Connection connection = connectionDB.getConnection();
//        List<Claim> claimList = new ArrayList<>();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_claim cl WHERE cl.status_id = 6");
//            while (resultSet.next()) {
//                Claim claim = new Claim(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.integerNVL(resultSet.getObject("code")),
//                        resultSet.getTimestamp("date_create"),
//                        resultSet.getTimestamp("date_close"),
//                        frames.integerNVL(resultSet.getObject("current_user_id")),
//                        frames.stringNVL(resultSet.getObject("current_user_title")),
//                        frames.integerNVL(resultSet.getObject("status_id")),
//                        frames.stringNVL(resultSet.getObject("status_title")),
//                        frames.integerNVL(resultSet.getObject("priority_id")),
//                        frames.stringNVL(resultSet.getObject("priority_title")),
//                        frames.integerNVL(resultSet.getObject("refusing_reason_id")),
//                        frames.stringNVL(resultSet.getObject("refusing_reason_title")),
//                        frames.integerNVL(resultSet.getObject("advertising_source_id")),
//                        frames.stringNVL(resultSet.getObject("advertising_source_title")),
//                        frames.stringNVL(resultSet.getObject("product_title")),
//                        frames.stringNVL(resultSet.getObject("client_fio")),
//                        frames.stringNVL(resultSet.getObject("client_phone_number")),
//                        frames.integerNVL(resultSet.getObject("client_age")),
//                        frames.integerNVL(resultSet.getObject("client_gender")),
//                        frames.integerNVL(resultSet.getObject("city_id")),
//                        frames.stringNVL(resultSet.getObject("city_title")),
//                        frames.integerNVL(resultSet.getObject("warehouse_id")),
//                        frames.stringNVL(resultSet.getObject("warehouse_title")),
//                        frames.stringNVL(resultSet.getObject("address")),
//                        frames.integerNVL(resultSet.getObject("workorder_id")),
//                        frames.integerNVL(resultSet.getObject("workorder_code")),
//                        frames.stringNVL(resultSet.getObject("last_comment"))
//                );
//                claimList.add(claim);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//        return claimList;
//    }
//
//    @Override
//    public List<Claim> getClaimListArchFail() throws IOException {
//        Connection connection = connectionDB.getConnection();
//        List<Claim> claimList = new ArrayList<>();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_claim cl WHERE cl.status_id = 7");
//            while (resultSet.next()) {
//                Claim claim = new Claim(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.integerNVL(resultSet.getObject("code")),
//                        resultSet.getTimestamp("date_create"),
//                        resultSet.getTimestamp("date_close"),
//                        frames.integerNVL(resultSet.getObject("current_user_id")),
//                        frames.stringNVL(resultSet.getObject("current_user_title")),
//                        frames.integerNVL(resultSet.getObject("status_id")),
//                        frames.stringNVL(resultSet.getObject("status_title")),
//                        frames.integerNVL(resultSet.getObject("priority_id")),
//                        frames.stringNVL(resultSet.getObject("priority_title")),
//                        frames.integerNVL(resultSet.getObject("refusing_reason_id")),
//                        frames.stringNVL(resultSet.getObject("refusing_reason_title")),
//                        frames.integerNVL(resultSet.getObject("advertising_source_id")),
//                        frames.stringNVL(resultSet.getObject("advertising_source_title")),
//                        frames.stringNVL(resultSet.getObject("product_title")),
//                        frames.stringNVL(resultSet.getObject("client_fio")),
//                        frames.stringNVL(resultSet.getObject("client_phone_number")),
//                        frames.integerNVL(resultSet.getObject("client_age")),
//                        frames.integerNVL(resultSet.getObject("client_gender")),
//                        frames.integerNVL(resultSet.getObject("city_id")),
//                        frames.stringNVL(resultSet.getObject("city_title")),
//                        frames.integerNVL(resultSet.getObject("warehouse_id")),
//                        frames.stringNVL(resultSet.getObject("warehouse_title")),
//                        frames.stringNVL(resultSet.getObject("address")),
//                        frames.integerNVL(resultSet.getObject("workorder_id")),
//                        frames.integerNVL(resultSet.getObject("workorder_code")),
//                        frames.stringNVL(resultSet.getObject("last_comment"))
//                );
//                claimList.add(claim);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//        return claimList;
//    }
//
//    @Override
//    public List<Claim> getClaimListTrash() throws IOException {
//        Connection connection = connectionDB.getConnection();
//        List<Claim> claimList = new ArrayList<>();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_claim cl WHERE cl.status_id = 8");
//            while (resultSet.next()) {
//                Claim claim = new Claim(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.integerNVL(resultSet.getObject("code")),
//                        resultSet.getTimestamp("date_create"),
//                        resultSet.getTimestamp("date_close"),
//                        frames.integerNVL(resultSet.getObject("current_user_id")),
//                        frames.stringNVL(resultSet.getObject("current_user_title")),
//                        frames.integerNVL(resultSet.getObject("status_id")),
//                        frames.stringNVL(resultSet.getObject("status_title")),
//                        frames.integerNVL(resultSet.getObject("priority_id")),
//                        frames.stringNVL(resultSet.getObject("priority_title")),
//                        frames.integerNVL(resultSet.getObject("refusing_reason_id")),
//                        frames.stringNVL(resultSet.getObject("refusing_reason_title")),
//                        frames.integerNVL(resultSet.getObject("advertising_source_id")),
//                        frames.stringNVL(resultSet.getObject("advertising_source_title")),
//                        frames.stringNVL(resultSet.getObject("product_title")),
//                        frames.stringNVL(resultSet.getObject("client_fio")),
//                        frames.stringNVL(resultSet.getObject("client_phone_number")),
//                        frames.integerNVL(resultSet.getObject("client_age")),
//                        frames.integerNVL(resultSet.getObject("client_gender")),
//                        frames.integerNVL(resultSet.getObject("city_id")),
//                        frames.stringNVL(resultSet.getObject("city_title")),
//                        frames.integerNVL(resultSet.getObject("warehouse_id")),
//                        frames.stringNVL(resultSet.getObject("warehouse_title")),
//                        frames.stringNVL(resultSet.getObject("address")),
//                        frames.integerNVL(resultSet.getObject("workorder_id")),
//                        frames.integerNVL(resultSet.getObject("workorder_code")),
//                        frames.stringNVL(resultSet.getObject("last_comment"))
//                );
//                claimList.add(claim);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//        return claimList;
//    }
//
//    @Override
//    public List<Claim> getClaimListDouble() throws IOException {
//        Connection connection = connectionDB.getConnection();
//        List<Claim> claimList = new ArrayList<>();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM v_claim cl WHERE cl.status_id = 21");
//            while (resultSet.next()) {
//                Claim claim = new Claim(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.integerNVL(resultSet.getObject("code")),
//                        resultSet.getTimestamp("date_create"),
//                        resultSet.getTimestamp("date_close"),
//                        frames.integerNVL(resultSet.getObject("current_user_id")),
//                        frames.stringNVL(resultSet.getObject("current_user_title")),
//                        frames.integerNVL(resultSet.getObject("status_id")),
//                        frames.stringNVL(resultSet.getObject("status_title")),
//                        frames.integerNVL(resultSet.getObject("priority_id")),
//                        frames.stringNVL(resultSet.getObject("priority_title")),
//                        frames.integerNVL(resultSet.getObject("refusing_reason_id")),
//                        frames.stringNVL(resultSet.getObject("refusing_reason_title")),
//                        frames.integerNVL(resultSet.getObject("advertising_source_id")),
//                        frames.stringNVL(resultSet.getObject("advertising_source_title")),
//                        frames.stringNVL(resultSet.getObject("product_title")),
//                        frames.stringNVL(resultSet.getObject("client_fio")),
//                        frames.stringNVL(resultSet.getObject("client_phone_number")),
//                        frames.integerNVL(resultSet.getObject("client_age")),
//                        frames.integerNVL(resultSet.getObject("client_gender")),
//                        frames.integerNVL(resultSet.getObject("city_id")),
//                        frames.stringNVL(resultSet.getObject("city_title")),
//                        frames.integerNVL(resultSet.getObject("warehouse_id")),
//                        frames.stringNVL(resultSet.getObject("warehouse_title")),
//                        frames.stringNVL(resultSet.getObject("address")),
//                        frames.integerNVL(resultSet.getObject("workorder_id")),
//                        frames.integerNVL(resultSet.getObject("workorder_code")),
//                        frames.stringNVL(resultSet.getObject("last_comment"))
//                );
//                claimList.add(claim);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//        return claimList;
//    }
//
//    @Override
//    public void updateClaim(Claim claim) throws IOException {
//        Connection connection = connectionDB.getConnection();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            CallableStatement statement = connection.prepareCall("{call P_UPDATE_CLAIM(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//
//            statement = frames.sqlIntegerNull(statement, "p_id", claim.getClaimId());
//            statement = frames.sqlIntegerNull(statement, "p_priority_id", claim.getPriorityId());
//            statement = frames.sqlIntegerNull(statement, "p_status_id", claim.getStatusId());
//            statement = frames.sqlIntegerNull(statement, "p_refusing_reason_id", claim.getRefusingReasonId());
//            statement = frames.sqlIntegerNull(statement, "p_client_age", claim.getClientAge());
//            statement = frames.sqlIntegerNull(statement, "p_client_gender", claim.getClientGender());
//            statement = frames.sqlIntegerNull(statement, "p_city_id", claim.getCityId());
//            statement = frames.sqlIntegerNull(statement, "p_warehouse_id", claim.getWarehouseId());
//            statement = frames.sqlStringNull(statement, "p_address", claim.getAddress());
//            statement = frames.sqlStringNull(statement, "p_fio", claim.getClientFIO());
//            statement = frames.sqlStringNull(statement, "p_phone_number", claim.getClientPhoneNumber());
//
//            statement.execute();
//            if (statement.getInt("p_response_code") != 1) {
//                throw new SQLException(statement.getString("p_response_message"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//    }
//
//    @Override
//    public void setUserInClaim(Claim claim, User user) throws IOException {
//        Connection connection = connectionDB.getConnection();
//        try {
//            connection.setCatalog(connectionDB.getSCHEMA_NAME());
//            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_USER(?,?,?,?)}");
//
//            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
//            statement = frames.sqlIntegerNull(statement, "p_user_id", user.getUserId());
//
//            statement.execute();
//            if (statement.getInt("p_response_code") != 1) {
//                throw new SQLException(statement.getString("p_response_message"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connectionDB.stopConnection(connection);
//    }
}
