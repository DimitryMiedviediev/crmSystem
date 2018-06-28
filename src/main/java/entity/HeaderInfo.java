package entity;

public class HeaderInfo {
    private String scriptInfo;
    private String answerInfo;
    private String itemInfo;
    private String clinicInfo;

    public HeaderInfo() {
    }

    public HeaderInfo(String scriptInfo, String answerInfo, String itemInfo, String clinicInfo) {
        this.scriptInfo = scriptInfo;
        this.answerInfo = answerInfo;
        this.itemInfo = itemInfo;
        this.clinicInfo = clinicInfo;
    }

    public String getScriptInfo() {
        return scriptInfo;
    }

    public void setScriptInfo(String scriptInfo) {
        this.scriptInfo = scriptInfo;
    }

    public String getAnswerInfo() {
        return answerInfo;
    }

    public void setAnswerInfo(String answerInfo) {
        this.answerInfo = answerInfo;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public String getClinicInfo() {
        return clinicInfo;
    }

    public void setClinicInfo(String clinicInfo) {
        this.clinicInfo = clinicInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeaderInfo that = (HeaderInfo) o;

        if (scriptInfo != null ? !scriptInfo.equals(that.scriptInfo) : that.scriptInfo != null) return false;
        if (answerInfo != null ? !answerInfo.equals(that.answerInfo) : that.answerInfo != null) return false;
        if (itemInfo != null ? !itemInfo.equals(that.itemInfo) : that.itemInfo != null) return false;
        return clinicInfo != null ? clinicInfo.equals(that.clinicInfo) : that.clinicInfo == null;
    }

    @Override
    public int hashCode() {
        int result = scriptInfo != null ? scriptInfo.hashCode() : 0;
        result = 31 * result + (answerInfo != null ? answerInfo.hashCode() : 0);
        result = 31 * result + (itemInfo != null ? itemInfo.hashCode() : 0);
        result = 31 * result + (clinicInfo != null ? clinicInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HeaderInfo{" +
                "scriptInfo='" + scriptInfo + '\'' +
                ", answerInfo='" + answerInfo + '\'' +
                ", itemInfo='" + itemInfo + '\'' +
                ", clinicInfo='" + clinicInfo + '\'' +
                '}';
    }
}
