package API.addressAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressAPI {

    private JsonNode getCitiesJSON() throws IOException {
        String payload = "{\n" +
                "\"modelName\": \"Address\",\n" +
                "\"calledMethod\": \"getCities\",\n" +
                "\"apiKey\": \"175384e3a9b005ca3d75371af2cbf97f\"\n" +
                "}";
        StringEntity requestEntity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://api.novaposhta.ua/v2.0/json/");
        request.setEntity(requestEntity);

        HttpResponse response = httpClient.execute(request);
        HttpEntity responseEntity = response.getEntity();

        String content = EntityUtils.toString(responseEntity);
        content = content.replace("\\u0410", "А");
        content = content.replace("\\u0411", "Б");
        content = content.replace("\\u0412", "В");
        content = content.replace("\\u0413", "Г");
        content = content.replace("\\u0414", "Д");
        content = content.replace("\\u0415", "Е");
        content = content.replace("\\u0416", "Ж");
        content = content.replace("\\u0417", "З");
        content = content.replace("\\u0418", "И");
        content = content.replace("\\u0419", "Й");
        content = content.replace("\\u041a", "К");
        content = content.replace("\\u041b", "Л");
        content = content.replace("\\u041c", "М");
        content = content.replace("\\u041d", "Н");
        content = content.replace("\\u041e", "О");
        content = content.replace("\\u041f", "П");

        content = content.replace("\\u0420", "Р");
        content = content.replace("\\u0421", "С");
        content = content.replace("\\u0422", "Т");
        content = content.replace("\\u0423", "У");
        content = content.replace("\\u0424", "Ф");
        content = content.replace("\\u0425", "Х");
        content = content.replace("\\u0426", "Ц");
        content = content.replace("\\u0427", "Ч");
        content = content.replace("\\u0428", "Ш");
        content = content.replace("\\u0429", "Щ");
        content = content.replace("\\u042a", "Ъ");
        content = content.replace("\\u042b", "Ы");
        content = content.replace("\\u042c", "Ь");
        content = content.replace("\\u042d", "Э");
        content = content.replace("\\u042e", "Ю");
        content = content.replace("\\u042f", "Я");

        content = content.replace("\\u0430", "а");
        content = content.replace("\\u0431", "б");
        content = content.replace("\\u0432", "в");
        content = content.replace("\\u0433", "г");
        content = content.replace("\\u0434", "д");
        content = content.replace("\\u0435", "е");
        content = content.replace("\\u0436", "ж");
        content = content.replace("\\u0437", "з");
        content = content.replace("\\u0438", "и");
        content = content.replace("\\u0439", "й");
        content = content.replace("\\u043a", "к");
        content = content.replace("\\u043b", "л");
        content = content.replace("\\u043c", "м");
        content = content.replace("\\u043d", "н");
        content = content.replace("\\u043e", "о");
        content = content.replace("\\u043f", "п");

        content = content.replace("\\u0440", "р");
        content = content.replace("\\u0441", "с");
        content = content.replace("\\u0442", "т");
        content = content.replace("\\u0443", "у");
        content = content.replace("\\u0444", "ф");
        content = content.replace("\\u0445", "х");
        content = content.replace("\\u0446", "ц");
        content = content.replace("\\u0447", "ч");
        content = content.replace("\\u0448", "ш");
        content = content.replace("\\u0449", "щ");
        content = content.replace("\\u044a", "ъ");
        content = content.replace("\\u044b", "ы");
        content = content.replace("\\u044c", "ь");
        content = content.replace("\\u044d", "э");
        content = content.replace("\\u044e", "ю");
        content = content.replace("\\u044f", "я");

        content = content.replace("\\u0406", "І");
        content = content.replace("\\u0456", "і");
        content = content.replace("\\u0407", "Ї");
        content = content.replace("\\u0457", "ї");

        String json = new Gson().toJson(content);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json);
    }

    public List<City> getCitiesList() throws IOException {
        JsonNode jsonNode = getCitiesJSON();

        List<City> cityList = new ArrayList<>();

        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        JsonElement jsonElement = parser.parse(jsonNode.textValue());
        JsonObject rootObject = jsonElement.getAsJsonObject();
        Boolean success = rootObject.get("success").getAsBoolean(); // get property "success"

        if (success) {
            JsonArray data = rootObject.get("data").getAsJsonArray(); // get array of json objects "data"

            JsonObject info = rootObject.getAsJsonObject("info"); // get json objects "info"
            int rowCount = info.get("totalCount").getAsInt();
            for (int i = 0; i < rowCount; i++) {
                City city;
                city = new City(
                        data.get(i).getAsJsonObject().get("CityID").getAsInt(),
                        data.get(i).getAsJsonObject().get("Description").getAsString(),
                        data.get(i).getAsJsonObject().get("DescriptionRu").getAsString(),
                        data.get(i).getAsJsonObject().get("Ref").getAsString(),
                        data.get(i).getAsJsonObject().get("Delivery1").getAsInt(),
                        data.get(i).getAsJsonObject().get("Delivery2").getAsInt(),
                        data.get(i).getAsJsonObject().get("Delivery3").getAsInt(),
                        data.get(i).getAsJsonObject().get("Delivery4").getAsInt(),
                        data.get(i).getAsJsonObject().get("Delivery5").getAsInt(),
                        data.get(i).getAsJsonObject().get("Delivery6").getAsInt(),
                        data.get(i).getAsJsonObject().get("Delivery7").getAsInt(),
                        data.get(i).getAsJsonObject().get("Area").getAsString(),
                        data.get(i).getAsJsonObject().get("IsBranch").getAsInt(),
                        data.get(i).getAsJsonObject().get("SettlementType").getAsString(),
                        data.get(i).getAsJsonObject().get("SettlementTypeDescription").getAsString(),
                        data.get(i).getAsJsonObject().get("SettlementTypeDescriptionRu").getAsString()
                );

                cityList.add(city);
            }
        }

        return cityList;
    }

    private JsonNode getWarehousesJSON() throws IOException {
        String payload = "{\n" +
                "\"modelName\": \"AddressGeneral\",\n" +
                "\"calledMethod\": \"getWarehouses\",\n" +
                "\"apiKey\": \"175384e3a9b005ca3d75371af2cbf97f\"\n" +
                "}";
        StringEntity requestEntity = new StringEntity(payload,
                ContentType.APPLICATION_FORM_URLENCODED);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://api.novaposhta.ua/v2.0/json/");
        request.setEntity(requestEntity);

        HttpResponse response = httpClient.execute(request);
        HttpEntity responseEntity = response.getEntity();

        String content = EntityUtils.toString(responseEntity);
        content = content.replace("\\u0410", "А");
        content = content.replace("\\u0411", "Б");
        content = content.replace("\\u0412", "В");
        content = content.replace("\\u0413", "Г");
        content = content.replace("\\u0414", "Д");
        content = content.replace("\\u0415", "Е");
        content = content.replace("\\u0416", "Ж");
        content = content.replace("\\u0417", "З");
        content = content.replace("\\u0418", "И");
        content = content.replace("\\u0419", "Й");
        content = content.replace("\\u041a", "К");
        content = content.replace("\\u041b", "Л");
        content = content.replace("\\u041c", "М");
        content = content.replace("\\u041d", "Н");
        content = content.replace("\\u041e", "О");
        content = content.replace("\\u041f", "П");

        content = content.replace("\\u0420", "Р");
        content = content.replace("\\u0421", "С");
        content = content.replace("\\u0422", "Т");
        content = content.replace("\\u0423", "У");
        content = content.replace("\\u0424", "Ф");
        content = content.replace("\\u0425", "Х");
        content = content.replace("\\u0426", "Ц");
        content = content.replace("\\u0427", "Ч");
        content = content.replace("\\u0428", "Ш");
        content = content.replace("\\u0429", "Щ");
        content = content.replace("\\u042a", "Ъ");
        content = content.replace("\\u042b", "Ы");
        content = content.replace("\\u042c", "Ь");
        content = content.replace("\\u042d", "Э");
        content = content.replace("\\u042e", "Ю");
        content = content.replace("\\u042f", "Я");

        content = content.replace("\\u0430", "а");
        content = content.replace("\\u0431", "б");
        content = content.replace("\\u0432", "в");
        content = content.replace("\\u0433", "г");
        content = content.replace("\\u0434", "д");
        content = content.replace("\\u0435", "е");
        content = content.replace("\\u0436", "ж");
        content = content.replace("\\u0437", "з");
        content = content.replace("\\u0438", "и");
        content = content.replace("\\u0439", "й");
        content = content.replace("\\u043a", "к");
        content = content.replace("\\u043b", "л");
        content = content.replace("\\u043c", "м");
        content = content.replace("\\u043d", "н");
        content = content.replace("\\u043e", "о");
        content = content.replace("\\u043f", "п");

        content = content.replace("\\u0440", "р");
        content = content.replace("\\u0441", "с");
        content = content.replace("\\u0442", "т");
        content = content.replace("\\u0443", "у");
        content = content.replace("\\u0444", "ф");
        content = content.replace("\\u0445", "х");
        content = content.replace("\\u0446", "ц");
        content = content.replace("\\u0447", "ч");
        content = content.replace("\\u0448", "ш");
        content = content.replace("\\u0449", "щ");
        content = content.replace("\\u044a", "ъ");
        content = content.replace("\\u044b", "ы");
        content = content.replace("\\u044c", "ь");
        content = content.replace("\\u044d", "э");
        content = content.replace("\\u044e", "ю");
        content = content.replace("\\u044f", "я");

        content = content.replace("\\u0406", "І");
        content = content.replace("\\u0456", "і");
        content = content.replace("\\u0407", "Ї");
        content = content.replace("\\u0457", "ї");

        String json = new Gson().toJson(content);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(json);
    }

    public List<Warehouse> getWarehousesList() throws IOException {
        JsonNode jsonNode = getWarehousesJSON();

        List<Warehouse> warehouseList = new ArrayList<>();

        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        JsonElement jsonElement = parser.parse(jsonNode.textValue());
        JsonObject rootObject = jsonElement.getAsJsonObject();
        Boolean success = rootObject.get("success").getAsBoolean(); // get property "success"

        if (success) {
            JsonArray data = rootObject.get("data").getAsJsonArray(); // get array of json objects "data"

            JsonObject info = rootObject.getAsJsonObject("info"); // get json objects "info"
            int rowCount = info.get("totalCount").getAsInt();
            for (int i = 0; i < rowCount; i++) {
                Warehouse warehouse;
                warehouse = new Warehouse(
                        data.get(i).getAsJsonObject().get("SiteKey").getAsInt(),
                        data.get(i).getAsJsonObject().get("Description").getAsString(),
                        data.get(i).getAsJsonObject().get("DescriptionRu").getAsString(),
                        data.get(i).getAsJsonObject().get("Phone").getAsString(),
                        data.get(i).getAsJsonObject().get("Ref").getAsString(),
                        data.get(i).getAsJsonObject().get("Number").getAsInt(),
                        data.get(i).getAsJsonObject().get("CityRef").getAsString()
                );

                warehouseList.add(warehouse);
            }
        }

        return warehouseList;
    }
}


