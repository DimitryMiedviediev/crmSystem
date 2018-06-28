package entity;

import java.util.Date;

public class Workorder {
    private Integer workorderId;
    private Integer workorderCode;
    private Date dateCreate;
    private Date dateClose;
    private String postalInvoiceNumber;
    private Integer workorderCurrentUserId;
    private String workorderCurrentUserTitle;
    private Integer claimCurrentUserId;
    private String claimCurrentUserTitle;
    private Integer statusId;
    private String statusTitle;
    private Integer priorityId;
    private String priorityTitle;
    private String productTitle;
    private String clientFIO;
    private String clientPhoneNumber;
    private Integer cityId;
    private String cityTitle;
    private Integer warehouseId;
    private String warehouseTitle;
    private String address;
    private Integer claimId;
    private Integer claimCode;
    private String lastComment;

    public Workorder() {
    }

    public Workorder(Integer workorderId, Integer workorderCode, Date dateCreate, Date dateClose, String postalInvoiceNumber, Integer workorderCurrentUserId, String workorderCurrentUserTitle, Integer claimCurrentUserId, String claimCurrentUserTitle, Integer statusId, String statusTitle, Integer priorityId, String priorityTitle, String productTitle, String clientFIO, String clientPhoneNumber, Integer cityId, String cityTitle, Integer warehouseId, String warehouseTitle, String address, Integer claimId, Integer claimCode, String lastComment) {
        this.workorderId = workorderId;
        this.workorderCode = workorderCode;
        this.dateCreate = dateCreate;
        this.dateClose = dateClose;
        this.postalInvoiceNumber = postalInvoiceNumber;
        this.workorderCurrentUserId = workorderCurrentUserId;
        this.workorderCurrentUserTitle = workorderCurrentUserTitle;
        this.claimCurrentUserId = claimCurrentUserId;
        this.claimCurrentUserTitle = claimCurrentUserTitle;
        this.statusId = statusId;
        this.statusTitle = statusTitle;
        this.priorityId = priorityId;
        this.priorityTitle = priorityTitle;
        this.productTitle = productTitle;
        this.clientFIO = clientFIO;
        this.clientPhoneNumber = clientPhoneNumber;
        this.cityId = cityId;
        this.cityTitle = cityTitle;
        this.warehouseId = warehouseId;
        this.warehouseTitle = warehouseTitle;
        this.address = address;
        this.claimId = claimId;
        this.claimCode = claimCode;
        this.lastComment = lastComment;
    }

    public Integer getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Integer workorderId) {
        this.workorderId = workorderId;
    }

    public Integer getWorkorderCode() {
        return workorderCode;
    }

    public void setWorkorderCode(Integer workorderCode) {
        this.workorderCode = workorderCode;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public String getPostalInvoiceNumber() {
        return postalInvoiceNumber;
    }

    public void setPostalInvoiceNumber(String postalInvoiceNumber) {
        this.postalInvoiceNumber = postalInvoiceNumber;
    }

    public Integer getWorkorderCurrentUserId() {
        return workorderCurrentUserId;
    }

    public void setWorkorderCurrentUserId(Integer workorderCurrentUserId) {
        this.workorderCurrentUserId = workorderCurrentUserId;
    }

    public String getWorkorderCurrentUserTitle() {
        return workorderCurrentUserTitle;
    }

    public void setWorkorderCurrentUserTitle(String workorderCurrentUserTitle) {
        this.workorderCurrentUserTitle = workorderCurrentUserTitle;
    }

    public Integer getClaimCurrentUserId() {
        return claimCurrentUserId;
    }

    public void setClaimCurrentUserId(Integer claimCurrentUserId) {
        this.claimCurrentUserId = claimCurrentUserId;
    }

    public String getClaimCurrentUserTitle() {
        return claimCurrentUserTitle;
    }

    public void setClaimCurrentUserTitle(String claimCurrentUserTitle) {
        this.claimCurrentUserTitle = claimCurrentUserTitle;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityTitle() {
        return priorityTitle;
    }

    public void setPriorityTitle(String priorityTitle) {
        this.priorityTitle = priorityTitle;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getClientFIO() {
        return clientFIO;
    }

    public void setClientFIO(String clientFIO) {
        this.clientFIO = clientFIO;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
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

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseTitle() {
        return warehouseTitle;
    }

    public void setWarehouseTitle(String warehouseTitle) {
        this.warehouseTitle = warehouseTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public Integer getClaimCode() {
        return claimCode;
    }

    public void setClaimCode(Integer claimCode) {
        this.claimCode = claimCode;
    }

    public String getLastComment() {
        return lastComment;
    }

    public void setLastComment(String lastComment) {
        this.lastComment = lastComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workorder workorder = (Workorder) o;

        if (workorderId != null ? !workorderId.equals(workorder.workorderId) : workorder.workorderId != null)
            return false;
        if (workorderCode != null ? !workorderCode.equals(workorder.workorderCode) : workorder.workorderCode != null)
            return false;
        if (dateCreate != null ? !dateCreate.equals(workorder.dateCreate) : workorder.dateCreate != null) return false;
        if (dateClose != null ? !dateClose.equals(workorder.dateClose) : workorder.dateClose != null) return false;
        if (postalInvoiceNumber != null ? !postalInvoiceNumber.equals(workorder.postalInvoiceNumber) : workorder.postalInvoiceNumber != null)
            return false;
        if (workorderCurrentUserId != null ? !workorderCurrentUserId.equals(workorder.workorderCurrentUserId) : workorder.workorderCurrentUserId != null)
            return false;
        if (workorderCurrentUserTitle != null ? !workorderCurrentUserTitle.equals(workorder.workorderCurrentUserTitle) : workorder.workorderCurrentUserTitle != null)
            return false;
        if (claimCurrentUserId != null ? !claimCurrentUserId.equals(workorder.claimCurrentUserId) : workorder.claimCurrentUserId != null)
            return false;
        if (claimCurrentUserTitle != null ? !claimCurrentUserTitle.equals(workorder.claimCurrentUserTitle) : workorder.claimCurrentUserTitle != null)
            return false;
        if (statusId != null ? !statusId.equals(workorder.statusId) : workorder.statusId != null) return false;
        if (statusTitle != null ? !statusTitle.equals(workorder.statusTitle) : workorder.statusTitle != null)
            return false;
        if (priorityId != null ? !priorityId.equals(workorder.priorityId) : workorder.priorityId != null) return false;
        if (priorityTitle != null ? !priorityTitle.equals(workorder.priorityTitle) : workorder.priorityTitle != null)
            return false;
        if (productTitle != null ? !productTitle.equals(workorder.productTitle) : workorder.productTitle != null)
            return false;
        if (clientFIO != null ? !clientFIO.equals(workorder.clientFIO) : workorder.clientFIO != null) return false;
        if (clientPhoneNumber != null ? !clientPhoneNumber.equals(workorder.clientPhoneNumber) : workorder.clientPhoneNumber != null)
            return false;
        if (cityId != null ? !cityId.equals(workorder.cityId) : workorder.cityId != null) return false;
        if (cityTitle != null ? !cityTitle.equals(workorder.cityTitle) : workorder.cityTitle != null) return false;
        if (warehouseId != null ? !warehouseId.equals(workorder.warehouseId) : workorder.warehouseId != null)
            return false;
        if (warehouseTitle != null ? !warehouseTitle.equals(workorder.warehouseTitle) : workorder.warehouseTitle != null)
            return false;
        if (address != null ? !address.equals(workorder.address) : workorder.address != null) return false;
        if (claimId != null ? !claimId.equals(workorder.claimId) : workorder.claimId != null) return false;
        if (claimCode != null ? !claimCode.equals(workorder.claimCode) : workorder.claimCode != null) return false;
        return lastComment != null ? lastComment.equals(workorder.lastComment) : workorder.lastComment == null;
    }

    @Override
    public int hashCode() {
        int result = workorderId != null ? workorderId.hashCode() : 0;
        result = 31 * result + (workorderCode != null ? workorderCode.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateClose != null ? dateClose.hashCode() : 0);
        result = 31 * result + (postalInvoiceNumber != null ? postalInvoiceNumber.hashCode() : 0);
        result = 31 * result + (workorderCurrentUserId != null ? workorderCurrentUserId.hashCode() : 0);
        result = 31 * result + (workorderCurrentUserTitle != null ? workorderCurrentUserTitle.hashCode() : 0);
        result = 31 * result + (claimCurrentUserId != null ? claimCurrentUserId.hashCode() : 0);
        result = 31 * result + (claimCurrentUserTitle != null ? claimCurrentUserTitle.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (statusTitle != null ? statusTitle.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        result = 31 * result + (priorityTitle != null ? priorityTitle.hashCode() : 0);
        result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
        result = 31 * result + (clientFIO != null ? clientFIO.hashCode() : 0);
        result = 31 * result + (clientPhoneNumber != null ? clientPhoneNumber.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (cityTitle != null ? cityTitle.hashCode() : 0);
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        result = 31 * result + (warehouseTitle != null ? warehouseTitle.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (claimId != null ? claimId.hashCode() : 0);
        result = 31 * result + (claimCode != null ? claimCode.hashCode() : 0);
        result = 31 * result + (lastComment != null ? lastComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Workorder{" +
                "workorderId=" + workorderId +
                ", workorderCode=" + workorderCode +
                ", dateCreate=" + dateCreate +
                ", dateClose=" + dateClose +
                ", postalInvoiceNumber='" + postalInvoiceNumber + '\'' +
                ", workorderCurrentUserId=" + workorderCurrentUserId +
                ", workorderCurrentUserTitle='" + workorderCurrentUserTitle + '\'' +
                ", claimCurrentUserId=" + claimCurrentUserId +
                ", claimCurrentUserTitle='" + claimCurrentUserTitle + '\'' +
                ", statusId=" + statusId +
                ", statusTitle='" + statusTitle + '\'' +
                ", priorityId=" + priorityId +
                ", priorityTitle='" + priorityTitle + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", clientFIO='" + clientFIO + '\'' +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", cityId=" + cityId +
                ", cityTitle='" + cityTitle + '\'' +
                ", warehouseId=" + warehouseId +
                ", warehouseTitle='" + warehouseTitle + '\'' +
                ", address='" + address + '\'' +
                ", claimId=" + claimId +
                ", claimCode=" + claimCode +
                ", lastComment='" + lastComment + '\'' +
                '}';
    }
}
