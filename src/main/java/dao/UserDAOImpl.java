package dao;

import entity.User;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();

    @Override
    public void createUser(User user) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_CREATE_USER(?,?,?,?,?,?,?,?,?,?,?)}");

            statement = frames.sqlStringNull(statement, "p_login", user.getLogin());
            statement = frames.sqlStringNull(statement, "p_password", user.getPassword());
            statement = frames.sqlIntegerNull(statement, "p_status_id", user.getStatusId());
            statement = frames.sqlIntegerNull(statement, "p_position_id", user.getPositionId());
            statement = frames.sqlStringNull(statement, "p_fio", user.getFio());
            statement = frames.sqlIntegerNull(statement, "p_percent_type", user.getPercentTypeId());
            statement = frames.sqlIntegerNull(statement, "p_role_id", user.getRoleId());
            statement = frames.sqlIntegerNull(statement, "p_salary", user.getSalary());
            statement = frames.sqlIntegerNull(statement, "p_head_user_id", user.getHeadUserId());

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
    public User getUser(Integer id) throws IOException {
        Connection connection = connectionDB.getConnection();
        User user = new User();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM user WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("login")),
                        frames.stringNVL(resultSet.getObject("password")),
                        frames.integerNVL(resultSet.getObject("position_id")),
                        frames.stringNVL(resultSet.getObject("fio")),
                        frames.integerNVL(resultSet.getObject("sales_percent")),
                        frames.integerNVL(resultSet.getObject("percent_type_id")),
                        frames.integerNVL(resultSet.getObject("role_id")),
                        frames.integerNVL(resultSet.getObject("status_id")),
                        frames.integerNVL(resultSet.getObject("head_user_id")),
                        frames.integerNVL(resultSet.getObject("salary"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return user;
    }

    @Override
    public User getUser(String login) throws IOException {
        Connection connection = connectionDB.getConnection();
        User user = new User();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM user WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("login")),
                        frames.stringNVL(resultSet.getObject("password")),
                        frames.integerNVL(resultSet.getObject("position_id")),
                        frames.stringNVL(resultSet.getObject("fio")),
                        frames.integerNVL(resultSet.getObject("sales_percent")),
                        frames.integerNVL(resultSet.getObject("percent_type_id")),
                        frames.integerNVL(resultSet.getObject("role_id")),
                        frames.integerNVL(resultSet.getObject("status_id")),
                        frames.integerNVL(resultSet.getObject("head_user_id")),
                        frames.integerNVL(resultSet.getObject("salary"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return user;
    }

    @Override
    public List<User> getUserList() throws IOException {
        Connection connection = connectionDB.getConnection();
        List<User> userList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE user.id not in (1, 2, 6)");
            while (resultSet.next()) {
                User user = new User(
                        frames.integerNVL(resultSet.getObject("id")),
                        frames.stringNVL(resultSet.getObject("login")),
                        frames.stringNVL(resultSet.getObject("password")),
                        frames.integerNVL(resultSet.getObject("position_id")),
                        frames.stringNVL(resultSet.getObject("fio")),
                        frames.integerNVL(resultSet.getObject("sales_percent")),
                        frames.integerNVL(resultSet.getObject("percent_type_id")),
                        frames.integerNVL(resultSet.getObject("role_id")),
                        frames.integerNVL(resultSet.getObject("status_id")),
                        frames.integerNVL(resultSet.getObject("head_user_id")),
                        frames.integerNVL(resultSet.getObject("salary"))
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return userList;
    }

    @Override
    public void updateUser(User user) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_UPDATE_USER(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_id", user.getUserId());
            statement = frames.sqlStringNull(statement, "p_login", user.getLogin());
            statement = frames.sqlStringNull(statement, "p_password", user.getPassword());
            statement = frames.sqlIntegerNull(statement, "p_status_id", user.getStatusId());
            statement = frames.sqlIntegerNull(statement, "p_position_id", user.getPositionId());
            statement = frames.sqlStringNull(statement, "p_fio", user.getFio());
            statement = frames.sqlIntegerNull(statement, "p_sales_percent", user.getPercentTypeId());
            statement = frames.sqlIntegerNull(statement, "p_percent_type", user.getPercentTypeId());
            statement = frames.sqlIntegerNull(statement, "p_role_id", user.getRoleId());
            statement = frames.sqlIntegerNull(statement, "p_salary", user.getSalary());
            statement = frames.sqlIntegerNull(statement, "p_head_user_id", user.getHeadUserId());

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
