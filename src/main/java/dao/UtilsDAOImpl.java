package dao;

import API.addressAPI.Warehouse;
import entity.City;
import entity.CountClaim;
import entity.HeaderInfo;
import entity.RefusingReason;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilsDAOImpl implements UtilsDAO {

    ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();

    @Override
    public CountClaim getCountClaim() {
        Connection connection = connectionDB.getConnection();
        CountClaim countClaim = null;
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_GET_CLAIM_STATUS_COUNT(?,?,?,?,?,?,?)}");

            statement.execute();
            countClaim = new CountClaim(
                    statement.getInt("p_new_claim_count"),
                    statement.getInt("p_recall_claim_count"),
                    statement.getInt("p_consult_claim_count"),
                    statement.getInt("p_arch_success_claim_count"),
                    statement.getInt("p_arch_fail_claim_count"),
                    statement.getInt("p_trash_claim_count"),
                    statement.getInt("p_double_claim_count")
            );


        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return countClaim;
    }

    @Override
    public List<RefusingReason> getRefusingReasonList() {
        Connection connection = connectionDB.getConnection();
        List<RefusingReason> refusingReasonList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT rr.id, rr.title, rr.category FROM refusing_reason rr");
            while (resultSet.next()) {
                RefusingReason refusingReason = new RefusingReason(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("title")),
                        frames.stringNVL(resultSet.getObject("category"))
                        );
                refusingReasonList.add(refusingReason);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return refusingReasonList;
    }

    @Override
    public List<RefusingReason> getRefusingReasonTrashList() {
        Connection connection = connectionDB.getConnection();
        List<RefusingReason> refusingReasonList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT rr.id, rr.title, rr.category FROM refusing_reason rr WHERE rr.category = 'trash'");
            while (resultSet.next()) {
                RefusingReason refusingReason = new RefusingReason(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("title")),
                        frames.stringNVL(resultSet.getObject("category"))
                );
                refusingReasonList.add(refusingReason);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return refusingReasonList;
    }

    @Override
    public List<RefusingReason> getRefusingReasonCancelList() {
        Connection connection = connectionDB.getConnection();
        List<RefusingReason> refusingReasonList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT rr.id, rr.title, rr.category FROM refusing_reason rr WHERE rr.category = 'cancel' AND rr.id not in (25)");
            while (resultSet.next()) {
                RefusingReason refusingReason = new RefusingReason(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("title")),
                        frames.stringNVL(resultSet.getObject("category"))
                );
                refusingReasonList.add(refusingReason);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return refusingReasonList;
    }

    @Override
    public RefusingReason getRefusingReasonById(Integer refusingReasonId) {
        Connection connection = connectionDB.getConnection();
        RefusingReason refusingReason = new RefusingReason();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT rr.id, rr.title, rr.category FROM refusing_reason rr WHERE rr.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, refusingReasonId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                refusingReason = new RefusingReason(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("title")),
                        frames.stringNVL(resultSet.getObject("category"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return refusingReason;
    }

    @Override
    public List<City> getCityList() {
        Connection connection = connectionDB.getConnection();
        List<City> cityList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ct.id, ct.description_ru FROM city ct ORDER BY ct.description_ru");
            while (resultSet.next()) {
                City city = new City(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("description_ru"))
                );
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return cityList;
    }

    @Override
    public Integer getCityId(String cityTitle) {
        Connection connection = connectionDB.getConnection();
        Integer cityId = null;
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT ct.id FROM city ct WHERE ct.description_ru = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setString(1, cityTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                System.out.println(resultSet.getObject("description_ru"));
                cityId = frames.integerNVL(resultSet.getObject("id"));
//                city = new City(
//                        frames.integerNVL(resultSet.getObject("id")),
//                        frames.stringNVL(resultSet.getObject("description_ru"))
//                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return cityId;
    }

    @Override
    public List<Warehouse> getWarehouseList(String cityTitle) {
        Connection connection = connectionDB.getConnection();
        List<Warehouse> warehouseList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT wh.* FROM city ct LEFT JOIN warehouse wh ON ct.ref = wh.city_ref WHERE ct.description_ru = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setString(1, cityTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Warehouse warehouse = new Warehouse(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("description_ua")),
                        frames.stringNVL(resultSet.getObject("description_ru")),
                        frames.stringNVL(resultSet.getObject("phone")),
                        frames.stringNVL(resultSet.getObject("ref")),
                        frames.integerNVL(resultSet.getObject("number")),
                        frames.stringNVL(resultSet.getObject("city_ref"))
                );
                warehouseList.add(warehouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return warehouseList;
    }

    @Override
    public Integer getWarehouseId(String warehouseTitle) {
        Connection connection = connectionDB.getConnection();
        Integer warehouseId = null;
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT wh.id FROM warehouse wh WHERE wh.description_ru = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setString(1, warehouseTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                warehouseId = frames.integerNVL(resultSet.getObject("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return warehouseId;
    }

    @Override
    public HeaderInfo getHeaderInfo(Integer claimId) {
        Connection connection = connectionDB.getConnection();
        HeaderInfo headerInfo = null;
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_GET_CLAIM_HEADER_INFO(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claimId);

            statement.execute();
            headerInfo = new HeaderInfo(
                    statement.getString("p_script_info"),
                    statement.getString("p_answer_info"),
                    statement.getString("p_item_info"),
                    statement.getString("p_clinic_info"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return headerInfo;
    }

    @Override
    public java.util.Date getSysDate() {

        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();

        java.util.Date date = new java.util.Date();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT sysdate() sysdate FROM dual";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                date = (Date) resultSet.getObject("sysdate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);

        return new Date(date.getTime());
    }
}
