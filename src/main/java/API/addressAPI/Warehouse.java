package API.addressAPI;

public class Warehouse {
    private int warehouseID;
    private String descriptionUa;
    private String descriptionRu;
    private String phone;
    private String ref;
    private int number;
    private String city_ref;

    public Warehouse() {
    }

    public Warehouse(int warehouseID, String descriptionUa, String descriptionRu, String phone, String ref, int number, String city_ref) {
        this.warehouseID = warehouseID;
        this.descriptionUa = descriptionUa;
        this.descriptionRu = descriptionRu;
        this.phone = phone;
        this.ref = ref;
        this.number = number;
        this.city_ref = city_ref;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getDescriptionUa() {
        return descriptionUa;
    }

    public void setDescriptionUa(String descriptionUa) {
        this.descriptionUa = descriptionUa;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity_ref() {
        return city_ref;
    }

    public void setCity_ref(String city_ref) {
        this.city_ref = city_ref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (warehouseID != warehouse.warehouseID) return false;
        if (number != warehouse.number) return false;
        if (descriptionUa != null ? !descriptionUa.equals(warehouse.descriptionUa) : warehouse.descriptionUa != null)
            return false;
        if (descriptionRu != null ? !descriptionRu.equals(warehouse.descriptionRu) : warehouse.descriptionRu != null)
            return false;
        if (phone != null ? !phone.equals(warehouse.phone) : warehouse.phone != null) return false;
        if (ref != null ? !ref.equals(warehouse.ref) : warehouse.ref != null) return false;
        return city_ref != null ? city_ref.equals(warehouse.city_ref) : warehouse.city_ref == null;
    }

    @Override
    public int hashCode() {
        int result = warehouseID;
        result = 31 * result + (descriptionUa != null ? descriptionUa.hashCode() : 0);
        result = 31 * result + (descriptionRu != null ? descriptionRu.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (ref != null ? ref.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (city_ref != null ? city_ref.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseID=" + warehouseID +
                ", descriptionUa='" + descriptionUa + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", phone='" + phone + '\'' +
                ", ref='" + ref + '\'' +
                ", number=" + number +
                ", city_ref='" + city_ref + '\'' +
                '}';
    }
}
