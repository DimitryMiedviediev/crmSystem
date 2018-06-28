package API.addressAPI;

public class City {
    private int cityId;
    private String descriptionUa;
    private String descriptionRu;
    private String ref;
    private int delivery1;
    private int delivery2;
    private int delivery3;
    private int delivery4;
    private int delivery5;
    private int delivery6;
    private int delivery7;
    private String area;
    private int isBranch;
    private String settlementType;
    private String settlementTypeDescriptionUa;
    private String settlementTypeDescriptionRu;

    public City() {
    }

    public City(int cityId, String descriptionUa, String descriptionRu, String ref, int delivery1, int delivery2, int delivery3, int delivery4, int delivery5, int delivery6, int delivery7, String area, int isBranch, String settlementType, String settlementTypeDescriptionUa, String settlementTypeDescriptionRu) {
        this.cityId = cityId;
        this.descriptionUa = descriptionUa;
        this.descriptionRu = descriptionRu;
        this.ref = ref;
        this.delivery1 = delivery1;
        this.delivery2 = delivery2;
        this.delivery3 = delivery3;
        this.delivery4 = delivery4;
        this.delivery5 = delivery5;
        this.delivery6 = delivery6;
        this.delivery7 = delivery7;
        this.area = area;
        this.isBranch = isBranch;
        this.settlementType = settlementType;
        this.settlementTypeDescriptionUa = settlementTypeDescriptionUa;
        this.settlementTypeDescriptionRu = settlementTypeDescriptionRu;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getDelivery1() {
        return delivery1;
    }

    public void setDelivery1(int delivery1) {
        this.delivery1 = delivery1;
    }

    public int getDelivery2() {
        return delivery2;
    }

    public void setDelivery2(int delivery2) {
        this.delivery2 = delivery2;
    }

    public int getDelivery3() {
        return delivery3;
    }

    public void setDelivery3(int delivery3) {
        this.delivery3 = delivery3;
    }

    public int getDelivery4() {
        return delivery4;
    }

    public void setDelivery4(int delivery4) {
        this.delivery4 = delivery4;
    }

    public int getDelivery5() {
        return delivery5;
    }

    public void setDelivery5(int delivery5) {
        this.delivery5 = delivery5;
    }

    public int getDelivery6() {
        return delivery6;
    }

    public void setDelivery6(int delivery6) {
        this.delivery6 = delivery6;
    }

    public int getDelivery7() {
        return delivery7;
    }

    public void setDelivery7(int delivery7) {
        this.delivery7 = delivery7;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getIsBranch() {
        return isBranch;
    }

    public void setIsBranch(int isBranch) {
        this.isBranch = isBranch;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public String getSettlementTypeDescriptionUa() {
        return settlementTypeDescriptionUa;
    }

    public void setSettlementTypeDescriptionUa(String settlementTypeDescriptionUa) {
        this.settlementTypeDescriptionUa = settlementTypeDescriptionUa;
    }

    public String getSettlementTypeDescriptionRu() {
        return settlementTypeDescriptionRu;
    }

    public void setSettlementTypeDescriptionRu(String settlementTypeDescriptionRu) {
        this.settlementTypeDescriptionRu = settlementTypeDescriptionRu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityId != city.cityId) return false;
        if (delivery1 != city.delivery1) return false;
        if (delivery2 != city.delivery2) return false;
        if (delivery3 != city.delivery3) return false;
        if (delivery4 != city.delivery4) return false;
        if (delivery5 != city.delivery5) return false;
        if (delivery6 != city.delivery6) return false;
        if (delivery7 != city.delivery7) return false;
        if (isBranch != city.isBranch) return false;
        if (descriptionUa != null ? !descriptionUa.equals(city.descriptionUa) : city.descriptionUa != null)
            return false;
        if (descriptionRu != null ? !descriptionRu.equals(city.descriptionRu) : city.descriptionRu != null)
            return false;
        if (ref != null ? !ref.equals(city.ref) : city.ref != null) return false;
        if (area != null ? !area.equals(city.area) : city.area != null) return false;
        if (settlementType != null ? !settlementType.equals(city.settlementType) : city.settlementType != null)
            return false;
        if (settlementTypeDescriptionUa != null ? !settlementTypeDescriptionUa.equals(city.settlementTypeDescriptionUa) : city.settlementTypeDescriptionUa != null)
            return false;
        return settlementTypeDescriptionRu != null ? settlementTypeDescriptionRu.equals(city.settlementTypeDescriptionRu) : city.settlementTypeDescriptionRu == null;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (descriptionUa != null ? descriptionUa.hashCode() : 0);
        result = 31 * result + (descriptionRu != null ? descriptionRu.hashCode() : 0);
        result = 31 * result + (ref != null ? ref.hashCode() : 0);
        result = 31 * result + delivery1;
        result = 31 * result + delivery2;
        result = 31 * result + delivery3;
        result = 31 * result + delivery4;
        result = 31 * result + delivery5;
        result = 31 * result + delivery6;
        result = 31 * result + delivery7;
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + isBranch;
        result = 31 * result + (settlementType != null ? settlementType.hashCode() : 0);
        result = 31 * result + (settlementTypeDescriptionUa != null ? settlementTypeDescriptionUa.hashCode() : 0);
        result = 31 * result + (settlementTypeDescriptionRu != null ? settlementTypeDescriptionRu.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", descriptionUa='" + descriptionUa + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", ref='" + ref + '\'' +
                ", delivery1=" + delivery1 +
                ", delivery2=" + delivery2 +
                ", delivery3=" + delivery3 +
                ", delivery4=" + delivery4 +
                ", delivery5=" + delivery5 +
                ", delivery6=" + delivery6 +
                ", delivery7=" + delivery7 +
                ", area='" + area + '\'' +
                ", isBranch=" + isBranch +
                ", settlementType='" + settlementType + '\'' +
                ", settlementTypeDescriptionUa='" + settlementTypeDescriptionUa + '\'' +
                ", settlementTypeDescriptionRu='" + settlementTypeDescriptionRu + '\'' +
                '}';
    }
}
