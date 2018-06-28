package entity;

public class Product {

    private Integer productId;
    private String productTitle;
    private Integer productPrice;
    private Integer productFinalPrice;

    public Product() {
    }

    public Product(Integer productId, String productTitle, Integer productPrice, Integer productFinalPrice) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productFinalPrice = productFinalPrice;
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

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductFinalPrice() {
        return productFinalPrice;
    }

    public void setProductFinalPrice(Integer productFinalPrice) {
        this.productFinalPrice = productFinalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (productTitle != null ? !productTitle.equals(product.productTitle) : product.productTitle != null)
            return false;
        if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null)
            return false;
        return productFinalPrice != null ? productFinalPrice.equals(product.productFinalPrice) : product.productFinalPrice == null;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productFinalPrice != null ? productFinalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productPrice=" + productPrice +
                ", productFinalPrice=" + productFinalPrice +
                '}';
    }
}
