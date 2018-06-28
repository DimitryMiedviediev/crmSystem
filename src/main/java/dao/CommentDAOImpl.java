package dao;

import entity.Claim;
import entity.Comment;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();

    @Override
    public void createComment(Comment comment) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_CREATE_COMMENT(?,?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", comment.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_workorder_id", comment.getWorkorderId());
            statement = frames.sqlIntegerNull(statement, "p_user_id", comment.getUserId());
            statement = frames.sqlStringNull(statement, "p_comment_text", comment.getCommentText());
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
    public List<Comment> getCommentListByClaimId(Integer claimId) throws IOException {
        Connection connection = connectionDB.getConnection();
        List<Comment> commentList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_chat ch WHERE ch.claim_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, claimId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment(
                        frames.integerNVL(resultSet.getObject("id")),
                        resultSet.getTimestamp("date_create"),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.integerNVL(resultSet.getObject("workorder_id")),
                        frames.integerNVL(resultSet.getObject("workorder_code")),
                        frames.integerNVL(resultSet.getObject("user_id")),
                        frames.stringNVL(resultSet.getObject("user_fio")),
                        frames.stringNVL(resultSet.getObject("comment"))

                );
                commentList.add(comment);
            }

            int b = commentList.size();
            for (Comment aCommentList : commentList) {
                aCommentList.setRowNumber(b);
                b--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return commentList;
    }

    @Override
    public List<Comment> getCommentListByClaimCode(Integer claimCode) throws IOException {
        Connection connection = connectionDB.getConnection();
        List<Comment> commentList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_chat ch WHERE ch.claim_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, claimCode);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment(
                        frames.integerNVL(resultSet.getObject("id")),
                        resultSet.getTimestamp("date_create"),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.integerNVL(resultSet.getObject("workorder_id")),
                        frames.integerNVL(resultSet.getObject("workorder_code")),
                        frames.integerNVL(resultSet.getObject("user_id")),
                        frames.stringNVL(resultSet.getObject("user_fio")),
                        frames.stringNVL(resultSet.getObject("comment"))
                );
                commentList.add(comment);
            }

            int b = commentList.size();
            for (Comment aCommentList : commentList) {
                aCommentList.setRowNumber(b);
                b--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return commentList;
    }

    @Override
    public List<Comment> getCommentListByWorkorderId(Integer workorderId) throws IOException {
        Connection connection = connectionDB.getConnection();
        List<Comment> commentList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_chat ch WHERE ch.workorder_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, workorderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment(
                        frames.integerNVL(resultSet.getObject("id")),
                        resultSet.getTimestamp("date_create"),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.integerNVL(resultSet.getObject("workorder_id")),
                        frames.integerNVL(resultSet.getObject("workorder_code")),
                        frames.integerNVL(resultSet.getObject("user_id")),
                        frames.stringNVL(resultSet.getObject("user_fio")),
                        frames.stringNVL(resultSet.getObject("comment"))
                );
                commentList.add(comment);
            }

            int b = commentList.size();
            for (Comment aCommentList : commentList) {
                aCommentList.setRowNumber(b);
                b--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return commentList;
    }

    @Override
    public List<Comment> getCommentListByWorkorderCode(Integer workorderCode) throws IOException {
        Connection connection = connectionDB.getConnection();
        List<Comment> commentList = new ArrayList<>();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            String sqlSelectQuery = "SELECT * FROM v_chat ch WHERE ch.workorder_code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, workorderCode);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment(
                        frames.integerNVL(resultSet.getObject("id")),
                        resultSet.getTimestamp("date_create"),
                        frames.integerNVL(resultSet.getObject("claim_id")),
                        frames.integerNVL(resultSet.getObject("claim_code")),
                        frames.integerNVL(resultSet.getObject("workorder_id")),
                        frames.integerNVL(resultSet.getObject("workorder_code")),
                        frames.integerNVL(resultSet.getObject("user_id")),
                        frames.stringNVL(resultSet.getObject("user_fio")),
                        frames.stringNVL(resultSet.getObject("comment"))
                );
                commentList.add(comment);
            }

            int b = commentList.size();
            for (Comment aCommentList : commentList) {
                aCommentList.setRowNumber(b);
                b--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionDB.stopConnection(connection);
        return commentList;
    }
}
