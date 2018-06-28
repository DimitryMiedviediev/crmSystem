package logic;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JDBCFrames {
    public CallableStatement sqlIntegerNull(CallableStatement statement, String parameterName, Integer parameterValue) throws SQLException {
        if (parameterValue != null) {
            statement.setInt(parameterName, parameterValue);
        } else {
            statement.setNull(parameterName, Types.NULL);
        }
        return statement;
    }

    public CallableStatement sqlStringNull(CallableStatement statement, String parameterName, String parameterValue) throws SQLException {
        if (parameterValue != null) {
            statement.setString(parameterName, parameterValue);
        } else {
            statement.setNull(parameterName, Types.NULL);
        }
        return statement;
    }

    public CallableStatement sqlTimestampNull(CallableStatement statement, String parameterName, Timestamp parameterValue) throws SQLException {
        if (parameterValue != null) {
            statement.setTimestamp(parameterName, parameterValue);
        } else {
            statement.setNull(parameterName, Types.NULL);
        }
        return statement;
    }

    public Integer integerNVL(Object o) throws SQLException {
        if (o != null) {
            return Integer.parseInt(o.toString());
        } else {
            return null;
        }
    }

    public String stringNVL(Object o) throws SQLException {
        if (o == null) {
            return null;
        } else {
            return o.toString();
        }
    }

}
