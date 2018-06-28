package logic;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerFrames {
    public Integer integerNVL(Object o) throws NumberFormatException {
        if (o != null) {
            try {
                return Integer.parseInt(o.toString());
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public String stringNVL(Object o) {
        if (o == null) {
            return null;
        } else if (o.toString().equals("")) {
            return null;
        } else {
            return o.toString();
        }
    }

    public java.util.Date getDateFromString(String string) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
