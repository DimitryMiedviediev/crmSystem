package entity;

public class City {

    private Integer cityId;
    private String cityTitle;

    public City() {
    }

    public City(Integer cityId, String cityTitle) {
        this.cityId = cityId;
        this.cityTitle = cityTitle;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityId != null ? !cityId.equals(city.cityId) : city.cityId != null) return false;
        return cityTitle != null ? cityTitle.equals(city.cityTitle) : city.cityTitle == null;
    }

    @Override
    public int hashCode() {
        int result = cityId != null ? cityId.hashCode() : 0;
        result = 31 * result + (cityTitle != null ? cityTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityTitle='" + cityTitle + '\'' +
                '}';
    }
}
