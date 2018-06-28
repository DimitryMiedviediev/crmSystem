package dao;

import entity.Claim;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class StatusDAOImpl implements StatusDAO {
    ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();

    @Override
    public void claimSetStatusRecall(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_STATUS(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", 4);
            statement = frames.sqlTimestampNull(statement, "p_date_return_to_new", new java.sql.Timestamp(claim.getDateReturnToNew().getTime()));
//            java.sql.Timestamp(date.getTime())
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
    public void claimSetStatusConsult(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_STATUS(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", 5);
            statement = frames.sqlTimestampNull(statement, "p_date_return_to_new", null);

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
    public void claimSetStatusArchSuccess(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_STATUS(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", 6);
            statement = frames.sqlTimestampNull(statement, "p_date_return_to_new", null);

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
    public void claimSetStatusArchFail(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_STATUS(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", 7);
            statement = frames.sqlTimestampNull(statement, "p_date_return_to_new", null);

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
    public void claimSetStatusTrash(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_STATUS(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", 8);
            statement = frames.sqlTimestampNull(statement, "p_date_return_to_new", null);

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
    public void claimSetStatusDouble(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_STATUS(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", 21);
            statement = frames.sqlTimestampNull(statement, "p_date_return_to_new", null);

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
    public void claimSetStatusNew(Claim claim) throws IOException {
        Connection connection = connectionDB.getConnection();
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            CallableStatement statement = connection.prepareCall("{call P_SET_CLAIM_STATUS(?,?,?,?,?)}");

            statement = frames.sqlIntegerNull(statement, "p_claim_id", claim.getClaimId());
            statement = frames.sqlIntegerNull(statement, "p_status_id", 3);
            statement = frames.sqlTimestampNull(statement, "p_date_return_to_new", null);

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
