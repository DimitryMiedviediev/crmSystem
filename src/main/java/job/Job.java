package job;

import API.addressAPI.AddressAPI;
import API.addressAPI.City;
import API.addressAPI.Warehouse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import logic.ConnectionDB;
import logic.JDBCFrames;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Job {

    private AddressAPI addressAPI = new AddressAPI();
    private ConnectionDB connectionDB = new ConnectionDB();
    private JDBCFrames frames = new JDBCFrames();


    public JsonNode updateDataBaseCityDictionary(Connection connection) throws IOException {
        List<HashMap<String, String>> list = new ArrayList<>();
        List<City> cityList = addressAPI.getCitiesList();
        HashMap<String, String> pair = new HashMap<>();
        int row = 0;
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            for (int i = 0; i < cityList.size(); i ++){
                row = i;
                CallableStatement statement = connection.prepareCall("{call J_IU_CITY_DICTIONARY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                statement = frames.sqlIntegerNull(statement, "p_id", cityList.get(i).getCityId());
                statement = frames.sqlStringNull(statement, "p_description_ua", cityList.get(i).getDescriptionUa());
                statement = frames.sqlStringNull(statement, "p_description_ru", cityList.get(i).getDescriptionRu());
                statement = frames.sqlStringNull(statement, "p_ref", cityList.get(i).getRef());
                statement = frames.sqlIntegerNull(statement, "p_delivery1", cityList.get(i).getDelivery1());
                statement = frames.sqlIntegerNull(statement, "p_delivery2", cityList.get(i).getDelivery2());
                statement = frames.sqlIntegerNull(statement, "p_delivery3", cityList.get(i).getDelivery3());
                statement = frames.sqlIntegerNull(statement, "p_delivery4", cityList.get(i).getDelivery4());
                statement = frames.sqlIntegerNull(statement, "p_delivery5", cityList.get(i).getDelivery5());
                statement = frames.sqlIntegerNull(statement, "p_delivery6", cityList.get(i).getDelivery6());
                statement = frames.sqlIntegerNull(statement, "p_delivery7", cityList.get(i).getDelivery7());
                statement = frames.sqlStringNull(statement, "p_area", cityList.get(i).getArea());
                statement = frames.sqlIntegerNull(statement, "p_is_branch", cityList.get(i).getIsBranch());
                statement = frames.sqlStringNull(statement, "p_settlement_type", cityList.get(i).getSettlementType());
                statement = frames.sqlStringNull(statement, "p_settlement_type_desctiption_ua", cityList.get(i).getSettlementTypeDescriptionUa());
                statement = frames.sqlStringNull(statement, "p_settlement_type_desctiption_ru", cityList.get(i).getSettlementTypeDescriptionRu());
                statement.execute();
                if (!statement.getString("p_response_code").equals("1")){
                    pair.put("responseCode", statement.getString("p_response_code"));
                    pair.put("responseMessage", statement.getString("p_response_message"));
                    list.add(pair);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data Base Error for line:");
            System.out.println(cityList.get(row));
        }
        String json = new Gson().toJson(list);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json);

    }

    public JsonNode updateDataBaseWarehouseDictionary(Connection connection) throws IOException {
        List<HashMap<String, String>> list = new ArrayList<>();
        List<Warehouse> warehouseList = addressAPI.getWarehousesList();
        HashMap<String, String> pair = new HashMap<>();
        int row = 0;
        try {
            connection.setCatalog(connectionDB.getSCHEMA_NAME());
            for (int i = 0; i < warehouseList.size(); i ++){
                row = i;
                CallableStatement statement = connection.prepareCall("{call J_IU_WAREHOUSE_DICTIONARY(?,?,?,?,?,?,?,?,?)}");
                statement = frames.sqlIntegerNull(statement, "p_id", warehouseList.get(i).getWarehouseID());
                statement = frames.sqlStringNull(statement, "p_description_ua", warehouseList.get(i).getDescriptionUa().replace("\"", "\'"));
                statement = frames.sqlStringNull(statement, "p_description_ru", warehouseList.get(i).getDescriptionRu().replace("\"", "\'"));
                statement = frames.sqlStringNull(statement, "p_phone", warehouseList.get(i).getPhone());
                statement = frames.sqlStringNull(statement, "p_ref", warehouseList.get(i).getRef());
                statement = frames.sqlIntegerNull(statement, "p_number", warehouseList.get(i).getNumber());
                statement = frames.sqlStringNull(statement, "p_city_ref", warehouseList.get(i).getCity_ref());
                statement.execute();
                if (!statement.getString("p_response_code").equals("1")){
                    pair.put("responseCode", statement.getString("p_response_code"));
                    pair.put("responseMessage", statement.getString("p_response_message"));
                    list.add(pair);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Data Base Error for line:");
            System.out.println(warehouseList.get(row));
        }
        String json = new Gson().toJson(list);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json);

    }

}
