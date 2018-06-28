package entity;

import java.util.Date;

public class Comment {
    private Integer id;
    private Integer rowNumber;
    private Date dateCreate;
    private Integer claimId;
    private Integer claimCode;
    private Integer workorderId;
    private Integer workorderCode;
    private Integer userId;
    private String userFIO;
    private String commentText;

    public Comment() {
    }

    public Comment(Integer id, Date dateCreate, Integer claimId, Integer claimCode, Integer workorderId, Integer workorderCode, Integer userId, String userFIO, String commentText) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.claimId = claimId;
        this.claimCode = claimCode;
        this.workorderId = workorderId;
        this.workorderCode = workorderCode;
        this.userId = userId;
        this.userFIO = userFIO;
        this.commentText = commentText;
    }

    public Comment(Integer id, Integer rowNumber, Date dateCreate, Integer claimId, Integer claimCode, Integer workorderId, Integer workorderCode, Integer userId, String userFIO, String commentText) {
        this.id = id;
        this.rowNumber = rowNumber;
        this.dateCreate = dateCreate;
        this.claimId = claimId;
        this.claimCode = claimCode;
        this.workorderId = workorderId;
        this.workorderCode = workorderCode;
        this.userId = userId;
        this.userFIO = userFIO;
        this.commentText = commentText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFIO() {
        return userFIO;
    }

    public void setUserFIO(String userFIO) {
        this.userFIO = userFIO;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (rowNumber != null ? !rowNumber.equals(comment.rowNumber) : comment.rowNumber != null) return false;
        if (dateCreate != null ? !dateCreate.equals(comment.dateCreate) : comment.dateCreate != null) return false;
        if (claimId != null ? !claimId.equals(comment.claimId) : comment.claimId != null) return false;
        if (claimCode != null ? !claimCode.equals(comment.claimCode) : comment.claimCode != null) return false;
        if (workorderId != null ? !workorderId.equals(comment.workorderId) : comment.workorderId != null) return false;
        if (workorderCode != null ? !workorderCode.equals(comment.workorderCode) : comment.workorderCode != null)
            return false;
        if (userId != null ? !userId.equals(comment.userId) : comment.userId != null) return false;
        if (userFIO != null ? !userFIO.equals(comment.userFIO) : comment.userFIO != null) return false;
        return commentText != null ? commentText.equals(comment.commentText) : comment.commentText == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rowNumber != null ? rowNumber.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (claimId != null ? claimId.hashCode() : 0);
        result = 31 * result + (claimCode != null ? claimCode.hashCode() : 0);
        result = 31 * result + (workorderId != null ? workorderId.hashCode() : 0);
        result = 31 * result + (workorderCode != null ? workorderCode.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userFIO != null ? userFIO.hashCode() : 0);
        result = 31 * result + (commentText != null ? commentText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", rowNumber=" + rowNumber +
                ", dateCreate=" + dateCreate +
                ", claimId=" + claimId +
                ", claimCode=" + claimCode +
                ", workorderId=" + workorderId +
                ", workorderCode=" + workorderCode +
                ", userId=" + userId +
                ", userFIO='" + userFIO + '\'' +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
