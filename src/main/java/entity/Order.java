package entity;

public class Order {
    private Integer orderId;
    private Integer productId;
    private String productTitle;
    private Integer productTitlePrice;
    private Integer productCount;
    private Integer finalPrice;
    private Integer claimId;
    private Integer claimCode;
    private Integer workorderId;
    private Integer workorderCode;

    public Order() {
    }

    public Order(Integer orderId, Integer productId, String productTitle, Integer productTitlePrice, Integer productCount, Integer finalPrice, Integer claimId, Integer claimCode, Integer workorderId, Integer workorderCode) {
        this.orderId = orderId;
        this.productId = productId;
        this.productTitle = productTitle;
        this.productTitlePrice = productTitlePrice;
        this.productCount = productCount;
        this.finalPrice = finalPrice;
        this.claimId = claimId;
        this.claimCode = claimCode;
        this.workorderId = workorderId;
        this.workorderCode = workorderCode;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getProductTitlePrice() {
        return productTitlePrice;
    }

    public void setProductTitlePrice(Integer productTitlePrice) {
        this.productTitlePrice = productTitlePrice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (productId != null ? !productId.equals(order.productId) : order.productId != null) return false;
        if (productTitle != null ? !productTitle.equals(order.productTitle) : order.productTitle != null) return false;
        if (productTitlePrice != null ? !productTitlePrice.equals(order.productTitlePrice) : order.productTitlePrice != null)
            return false;
        if (productCount != null ? !productCount.equals(order.productCount) : order.productCount != null) return false;
        if (finalPrice != null ? !finalPrice.equals(order.finalPrice) : order.finalPrice != null) return false;
        if (claimId != null ? !claimId.equals(order.claimId) : order.claimId != null) return false;
        if (claimCode != null ? !claimCode.equals(order.claimCode) : order.claimCode != null) return false;
        if (workorderId != null ? !workorderId.equals(order.workorderId) : order.workorderId != null) return false;
        return workorderCode != null ? workorderCode.equals(order.workorderCode) : order.workorderCode == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
        result = 31 * result + (productTitlePrice != null ? productTitlePrice.hashCode() : 0);
        result = 31 * result + (productCount != null ? productCount.hashCode() : 0);
        result = 31 * result + (finalPrice != null ? finalPrice.hashCode() : 0);
        result = 31 * result + (claimId != null ? claimId.hashCode() : 0);
        result = 31 * result + (claimCode != null ? claimCode.hashCode() : 0);
        result = 31 * result + (workorderId != null ? workorderId.hashCode() : 0);
        result = 31 * result + (workorderCode != null ? workorderCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productTitlePrice=" + productTitlePrice +
                ", productCount=" + productCount +
                ", finalPrice=" + finalPrice +
                ", claimId=" + claimId +
                ", claimCode=" + claimCode +
                ", workorderId=" + workorderId +
                ", workorderCode=" + workorderCode +
                '}';
    }
}
