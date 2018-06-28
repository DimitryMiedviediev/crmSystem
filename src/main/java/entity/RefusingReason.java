package entity;

public class RefusingReason {
    private Integer refusingReasonId;
    private String refusingReasonTitle;
    private String refusingReasonCategory;

    public RefusingReason() {
    }

    public RefusingReason(Integer refusingReasonId, String refusingReasonTitle, String refusingReasonCategory) {
        this.refusingReasonId = refusingReasonId;
        this.refusingReasonTitle = refusingReasonTitle;
        this.refusingReasonCategory = refusingReasonCategory;
    }

    public Integer getRefusingReasonId() {
        return refusingReasonId;
    }

    public void setRefusingReasonId(Integer refusingReasonId) {
        this.refusingReasonId = refusingReasonId;
    }

    public String getRefusingReasonTitle() {
        return refusingReasonTitle;
    }

    public void setRefusingReasonTitle(String refusingReasonTitle) {
        this.refusingReasonTitle = refusingReasonTitle;
    }

    public String getRefusingReasonCategory() {
        return refusingReasonCategory;
    }

    public void setRefusingReasonCategory(String refusingReasonCategory) {
        this.refusingReasonCategory = refusingReasonCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefusingReason that = (RefusingReason) o;

        if (refusingReasonId != null ? !refusingReasonId.equals(that.refusingReasonId) : that.refusingReasonId != null)
            return false;
        if (refusingReasonTitle != null ? !refusingReasonTitle.equals(that.refusingReasonTitle) : that.refusingReasonTitle != null)
            return false;
        return refusingReasonCategory != null ? refusingReasonCategory.equals(that.refusingReasonCategory) : that.refusingReasonCategory == null;
    }

    @Override
    public int hashCode() {
        int result = refusingReasonId != null ? refusingReasonId.hashCode() : 0;
        result = 31 * result + (refusingReasonTitle != null ? refusingReasonTitle.hashCode() : 0);
        result = 31 * result + (refusingReasonCategory != null ? refusingReasonCategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RefusingReason{" +
                "refusingReasonId=" + refusingReasonId +
                ", refusingReasonTitle='" + refusingReasonTitle + '\'' +
                ", refusingReasonCategory='" + refusingReasonCategory + '\'' +
                '}';
    }
}
