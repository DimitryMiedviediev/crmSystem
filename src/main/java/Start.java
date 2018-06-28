import API.addressAPI.Warehouse;
import dao.*;
import entity.*;
import logic.ConnectionDB;
import logic.ControllerFrames;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Start {
    public static void main(String[] args) throws IOException, ParseException {

        ClaimDAO claimDAO = new ClaimDAOImpl();
        UtilsDAO utilsDAO = new UtilsDAOImpl();
//        String rrror;
//        int code;
//        Claim claim = claimDAO.getClaim(1);

        WorkorderDAO workorderDAO = new WorkorderDAOImpl();

//        workorderDAO.createWorkorder(claim);

        System.out.println(claimDAO.getClaimListNew());
        System.out.println(utilsDAO.getCountClaim());


    }

}

