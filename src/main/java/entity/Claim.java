package entity;

import java.util.Date;

public class Claim {
    private Integer claimId;
    private Integer claimCode;
    private Date dateCreate;
    private Date dateReturnToNew;
    private Integer countReturnToNew;
    private Date dateClose;
    private Integer currentUserId;
    private String currentUserTitle;
    private Integer statusId;
    private String statusTitle;
    private Integer priorityId;
    private String priorityTitle;
    private Integer refusingReasonId;
    private String refusingReasonTitle;
    private Integer advertisingSourceId;
    private String advertisingSourceTitle;
    private String productTitle;
    private String clientFIO;
    private String clientPhoneNumber;
    private Integer clientAge;
    private Integer clientGender;
    private Integer cityId;
    private String cityTitle;
    private Integer warehouseId;
    private String warehouseTitle;
    private String address;
    private Integer workorderId;
    private Integer workorderCode;
    private String lastComment;

    public Claim() {
    }

    public Claim(String clientFIO, String clientPhoneNumber, Integer advertisingSourceId) {
        this.clientFIO = clientFIO;
        this.clientPhoneNumber = clientPhoneNumber;
        this.advertisingSourceId = advertisingSourceId;
    }

    public Claim(Integer statusId, Integer priorityId, String clientFIO, String clientPhoneNumber) {
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.clientFIO = clientFIO;
        this.clientPhoneNumber = clientPhoneNumber;
    }

//    public Claim(Integer claimId, Integer claimCode, Date dateCreate, Date dateClose, Integer currentUserId, String currentUserTitle, Integer statusId, String statusTitle, Integer priorityId, String priorityTitle, Integer refusingReasonId, String refusingReasonTitle, Integer advertisingSourceId, String advertisingSourceTitle, String productTitle, String clientFIO, String clientPhoneNumber, Integer clientAge, Integer clientGender, Integer cityId, String cityTitle, Integer warehouseId, String address, Integer workorderId, Integer workorderCode) {
//        this.claimId = claimId;
//        this.claimCode = claimCode;
//        this.dateCreate = dateCreate;
//        this.dateClose = dateClose;
//        this.currentUserId = currentUserId;
//        this.currentUserTitle = currentUserTitle;
//        this.statusId = statusId;
//        this.statusTitle = statusTitle;
//        this.priorityId = priorityId;
//        this.priorityTitle = priorityTitle;
//        this.refusingReasonId = refusingReasonId;
//        this.refusingReasonTitle = refusingReasonTitle;
//        this.advertisingSourceId = advertisingSourceId;
//        this.advertisingSourceTitle = advertisingSourceTitle;
//        this.productTitle = productTitle;
//        this.clientFIO = clientFIO;
//        this.clientPhoneNumber = clientPhoneNumber;
//        this.clientAge = clientAge;
//        this.clientGender = clientGender;
//        this.cityId = cityId;
//        this.cityTitle = cityTitle;
//        this.warehouseId = warehouseId;
//        this.address = address;
//        this.workorderId = workorderId;
//        this.workorderCode = workorderCode;
//    }

//    public Claim(Integer claimId, Integer claimCode, Date dateCreate, Date dateClose, Integer currentUserId, String currentUserTitle, Integer statusId, String statusTitle, Integer priorityId, String priorityTitle, Integer refusingReasonId, String refusingReasonTitle, Integer advertisingSourceId, String advertisingSourceTitle, String productTitle, String clientFIO, String clientPhoneNumber, Integer clientAge, Integer clientGender, Integer cityId, String cityTitle, Integer warehouseId, String address, Integer workorderId, Integer workorderCode, String lastComment) {
//        this.claimId = claimId;
//        this.claimCode = claimCode;
//        this.dateCreate = dateCreate;
//        this.dateClose = dateClose;
//        this.currentUserId = currentUserId;
//        this.currentUserTitle = currentUserTitle;
//        this.statusId = statusId;
//        this.statusTitle = statusTitle;
//        this.priorityId = priorityId;
//        this.priorityTitle = priorityTitle;
//        this.refusingReasonId = refusingReasonId;
//        this.refusingReasonTitle = refusingReasonTitle;
//        this.advertisingSourceId = advertisingSourceId;
//        this.advertisingSourceTitle = advertisingSourceTitle;
//        this.productTitle = productTitle;
//        this.clientFIO = clientFIO;
//        this.clientPhoneNumber = clientPhoneNumber;
//        this.clientAge = clientAge;
//        this.clientGender = clientGender;
//        this.cityId = cityId;
//        this.cityTitle = cityTitle;
//        this.warehouseId = warehouseId;
//        this.address = address;
//        this.workorderId = workorderId;
//        this.workorderCode = workorderCode;
//        this.lastComment = lastComment;
//    }


    public Claim(Integer claimId, Integer claimCode, Date dateCreate, Date dateClose, Integer currentUserId, String currentUserTitle, Integer statusId, String statusTitle, Integer priorityId, String priorityTitle, Integer refusingReasonId, String refusingReasonTitle, Integer advertisingSourceId, String advertisingSourceTitle, String productTitle, String clientFIO, String clientPhoneNumber, Integer clientAge, Integer clientGender, Integer cityId, String cityTitle, Integer warehouseId, String warehouseTitle, String address, Integer workorderId, Integer workorderCode, String lastComment) {
        this.claimId = claimId;
        this.claimCode = claimCode;
        this.dateCreate = dateCreate;
        this.dateClose = dateClose;
        this.currentUserId = currentUserId;
        this.currentUserTitle = currentUserTitle;
        this.statusId = statusId;
        this.statusTitle = statusTitle;
        this.priorityId = priorityId;
        this.priorityTitle = priorityTitle;
        this.refusingReasonId = refusingReasonId;
        this.refusingReasonTitle = refusingReasonTitle;
        this.advertisingSourceId = advertisingSourceId;
        this.advertisingSourceTitle = advertisingSourceTitle;
        this.productTitle = productTitle;
        this.clientFIO = clientFIO;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientAge = clientAge;
        this.clientGender = clientGender;
        this.cityId = cityId;
        this.cityTitle = cityTitle;
        this.warehouseId = warehouseId;
        this.warehouseTitle = warehouseTitle;
        this.address = address;
        this.workorderId = workorderId;
        this.workorderCode = workorderCode;
        this.lastComment = lastComment;
    }

    public Claim(Integer claimId, Integer claimCode, Date dateCreate, Date dateReturnToNew, Integer countReturnToNew, Date dateClose, Integer currentUserId, String currentUserTitle, Integer statusId, String statusTitle, Integer priorityId, String priorityTitle, Integer refusingReasonId, String refusingReasonTitle, Integer advertisingSourceId, String advertisingSourceTitle, String productTitle, String clientFIO, String clientPhoneNumber, Integer clientAge, Integer clientGender, Integer cityId, String cityTitle, Integer warehouseId, String warehouseTitle, String address, Integer workorderId, Integer workorderCode, String lastComment) {
        this.claimId = claimId;
        this.claimCode = claimCode;
        this.dateCreate = dateCreate;
        this.dateReturnToNew = dateReturnToNew;
        this.countReturnToNew = countReturnToNew;
        this.dateClose = dateClose;
        this.currentUserId = currentUserId;
        this.currentUserTitle = currentUserTitle;
        this.statusId = statusId;
        this.statusTitle = statusTitle;
        this.priorityId = priorityId;
        this.priorityTitle = priorityTitle;
        this.refusingReasonId = refusingReasonId;
        this.refusingReasonTitle = refusingReasonTitle;
        this.advertisingSourceId = advertisingSourceId;
        this.advertisingSourceTitle = advertisingSourceTitle;
        this.productTitle = productTitle;
        this.clientFIO = clientFIO;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientAge = clientAge;
        this.clientGender = clientGender;
        this.cityId = cityId;
        this.cityTitle = cityTitle;
        this.warehouseId = warehouseId;
        this.warehouseTitle = warehouseTitle;
        this.address = address;
        this.workorderId = workorderId;
        this.workorderCode = workorderCode;
        this.lastComment = lastComment;
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateReturnToNew() {
        return dateReturnToNew;
    }

    public void setDateReturnToNew(Date dateReturnToNew) {
        this.dateReturnToNew = dateReturnToNew;
    }

    public Integer getCountReturnToNew() {
        return countReturnToNew;
    }

    public void setCountReturnToNew(Integer countReturnToNew) {
        this.countReturnToNew = countReturnToNew;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public Integer getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }

    public String getCurrentUserTitle() {
        return currentUserTitle;
    }

    public void setCurrentUserTitle(String currentUserTitle) {
        this.currentUserTitle = currentUserTitle;
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

    public Integer getAdvertisingSourceId() {
        return advertisingSourceId;
    }

    public void setAdvertisingSourceId(Integer advertisingSourceId) {
        this.advertisingSourceId = advertisingSourceId;
    }

    public String getAdvertisingSourceTitle() {
        return advertisingSourceTitle;
    }

    public void setAdvertisingSourceTitle(String advertisingSourceTitle) {
        this.advertisingSourceTitle = advertisingSourceTitle;
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

    public Integer getClientAge() {
        return clientAge;
    }

    public void setClientAge(Integer clientAge) {
        this.clientAge = clientAge;
    }

    public Integer getClientGender() {
        return clientGender;
    }

    public void setClientGender(Integer clientGender) {
        this.clientGender = clientGender;
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

        Claim claim = (Claim) o;

        if (claimId != null ? !claimId.equals(claim.claimId) : claim.claimId != null) return false;
        if (claimCode != null ? !claimCode.equals(claim.claimCode) : claim.claimCode != null) return false;
        if (dateCreate != null ? !dateCreate.equals(claim.dateCreate) : claim.dateCreate != null) return false;
        if (dateReturnToNew != null ? !dateReturnToNew.equals(claim.dateReturnToNew) : claim.dateReturnToNew != null)
            return false;
        if (countReturnToNew != null ? !countReturnToNew.equals(claim.countReturnToNew) : claim.countReturnToNew != null)
            return false;
        if (dateClose != null ? !dateClose.equals(claim.dateClose) : claim.dateClose != null) return false;
        if (currentUserId != null ? !currentUserId.equals(claim.currentUserId) : claim.currentUserId != null)
            return false;
        if (currentUserTitle != null ? !currentUserTitle.equals(claim.currentUserTitle) : claim.currentUserTitle != null)
            return false;
        if (statusId != null ? !statusId.equals(claim.statusId) : claim.statusId != null) return false;
        if (statusTitle != null ? !statusTitle.equals(claim.statusTitle) : claim.statusTitle != null) return false;
        if (priorityId != null ? !priorityId.equals(claim.priorityId) : claim.priorityId != null) return false;
        if (priorityTitle != null ? !priorityTitle.equals(claim.priorityTitle) : claim.priorityTitle != null)
            return false;
        if (refusingReasonId != null ? !refusingReasonId.equals(claim.refusingReasonId) : claim.refusingReasonId != null)
            return false;
        if (refusingReasonTitle != null ? !refusingReasonTitle.equals(claim.refusingReasonTitle) : claim.refusingReasonTitle != null)
            return false;
        if (advertisingSourceId != null ? !advertisingSourceId.equals(claim.advertisingSourceId) : claim.advertisingSourceId != null)
            return false;
        if (advertisingSourceTitle != null ? !advertisingSourceTitle.equals(claim.advertisingSourceTitle) : claim.advertisingSourceTitle != null)
            return false;
        if (productTitle != null ? !productTitle.equals(claim.productTitle) : claim.productTitle != null) return false;
        if (clientFIO != null ? !clientFIO.equals(claim.clientFIO) : claim.clientFIO != null) return false;
        if (clientPhoneNumber != null ? !clientPhoneNumber.equals(claim.clientPhoneNumber) : claim.clientPhoneNumber != null)
            return false;
        if (clientAge != null ? !clientAge.equals(claim.clientAge) : claim.clientAge != null) return false;
        if (clientGender != null ? !clientGender.equals(claim.clientGender) : claim.clientGender != null) return false;
        if (cityId != null ? !cityId.equals(claim.cityId) : claim.cityId != null) return false;
        if (cityTitle != null ? !cityTitle.equals(claim.cityTitle) : claim.cityTitle != null) return false;
        if (warehouseId != null ? !warehouseId.equals(claim.warehouseId) : claim.warehouseId != null) return false;
        if (warehouseTitle != null ? !warehouseTitle.equals(claim.warehouseTitle) : claim.warehouseTitle != null)
            return false;
        if (address != null ? !address.equals(claim.address) : claim.address != null) return false;
        if (workorderId != null ? !workorderId.equals(claim.workorderId) : claim.workorderId != null) return false;
        if (workorderCode != null ? !workorderCode.equals(claim.workorderCode) : claim.workorderCode != null)
            return false;
        return lastComment != null ? lastComment.equals(claim.lastComment) : claim.lastComment == null;
    }

    @Override
    public int hashCode() {
        int result = claimId != null ? claimId.hashCode() : 0;
        result = 31 * result + (claimCode != null ? claimCode.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateReturnToNew != null ? dateReturnToNew.hashCode() : 0);
        result = 31 * result + (countReturnToNew != null ? countReturnToNew.hashCode() : 0);
        result = 31 * result + (dateClose != null ? dateClose.hashCode() : 0);
        result = 31 * result + (currentUserId != null ? currentUserId.hashCode() : 0);
        result = 31 * result + (currentUserTitle != null ? currentUserTitle.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (statusTitle != null ? statusTitle.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        result = 31 * result + (priorityTitle != null ? priorityTitle.hashCode() : 0);
        result = 31 * result + (refusingReasonId != null ? refusingReasonId.hashCode() : 0);
        result = 31 * result + (refusingReasonTitle != null ? refusingReasonTitle.hashCode() : 0);
        result = 31 * result + (advertisingSourceId != null ? advertisingSourceId.hashCode() : 0);
        result = 31 * result + (advertisingSourceTitle != null ? advertisingSourceTitle.hashCode() : 0);
        result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
        result = 31 * result + (clientFIO != null ? clientFIO.hashCode() : 0);
        result = 31 * result + (clientPhoneNumber != null ? clientPhoneNumber.hashCode() : 0);
        result = 31 * result + (clientAge != null ? clientAge.hashCode() : 0);
        result = 31 * result + (clientGender != null ? clientGender.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (cityTitle != null ? cityTitle.hashCode() : 0);
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        result = 31 * result + (warehouseTitle != null ? warehouseTitle.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (workorderId != null ? workorderId.hashCode() : 0);
        result = 31 * result + (workorderCode != null ? workorderCode.hashCode() : 0);
        result = 31 * result + (lastComment != null ? lastComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", claimCode=" + claimCode +
                ", dateCreate=" + dateCreate +
                ", dateReturnToNew=" + dateReturnToNew +
                ", countReturnToNew=" + countReturnToNew +
                ", dateClose=" + dateClose +
                ", currentUserId=" + currentUserId +
                ", currentUserTitle='" + currentUserTitle + '\'' +
                ", statusId=" + statusId +
                ", statusTitle='" + statusTitle + '\'' +
                ", priorityId=" + priorityId +
                ", priorityTitle='" + priorityTitle + '\'' +
                ", refusingReasonId=" + refusingReasonId +
                ", refusingReasonTitle='" + refusingReasonTitle + '\'' +
                ", advertisingSourceId=" + advertisingSourceId +
                ", advertisingSourceTitle='" + advertisingSourceTitle + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", clientFIO='" + clientFIO + '\'' +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", clientAge=" + clientAge +
                ", clientGender=" + clientGender +
                ", cityId=" + cityId +
                ", cityTitle='" + cityTitle + '\'' +
                ", warehouseId=" + warehouseId +
                ", warehouseTitle='" + warehouseTitle + '\'' +
                ", address='" + address + '\'' +
                ", workorderId=" + workorderId +
                ", workorderCode=" + workorderCode +
                ", lastComment='" + lastComment + '\'' +
                '}';
    }
}