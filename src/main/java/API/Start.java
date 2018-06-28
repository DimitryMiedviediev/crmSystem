package API;

import dao.UtilsDAO;
import dao.UtilsDAOImpl;
import job.Job;
import logic.ConnectionDB;

import java.io.IOException;
import java.sql.Connection;

public class Start {
    public static void main(String[] args) {
//        Job job = new Job();
//
//        ConnectionDB connectionDB = new ConnectionDB();
//
//        Connection connection = connectionDB.getConnection();
//
//        try {
//            job.updateDataBaseWarehouseDictionary(connection);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        connectionDB.stopConnection(connection);

        UtilsDAO utilsDAO = new UtilsDAOImpl();

//        System.out.println(utilsDAO.getCityId("Киев"));
        System.out.println(utilsDAO.getWarehouseId("Отделение № 1: ул. Подлесная, 27"));
    }




}
