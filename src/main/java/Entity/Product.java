package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/9 14:55
 */
public class Product {
    /*
product_id	int
product_name	varchar
product_oldprice	double
product_nowprice	double
product_remaining	int
product_category	int
product_image	varchar
product_desc	text


    * */
    private Integer productId;
    private String productUserId;
    private String productName;
    private Double productOldprice;
    private Double productNowprice;
    private Integer productRemaining;
    private Integer productCategory;
    private String productImage;
    private String productDesc;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productUserId='" + productUserId + '\'' +
                ", productName='" + productName + '\'' +
                ", productOldprice=" + productOldprice +
                ", productNowprice=" + productNowprice +
                ", productRemaining=" + productRemaining +
                ", productCategory=" + productCategory +
                ", productImage='" + productImage + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductUserId() {
        return productUserId;
    }

    public void setProductUserId(String productUserId) {
        this.productUserId = productUserId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductOldprice() {
        return productOldprice;
    }

    public void setProductOldprice(Double productOldprice) {
        this.productOldprice = productOldprice;
    }

    public Double getProductNowprice() {
        return productNowprice;
    }

    public void setProductNowprice(Double productNowprice) {
        this.productNowprice = productNowprice;
    }

    public Integer getProductRemaining() {
        return productRemaining;
    }

    public void setProductRemaining(Integer productRemaining) {
        this.productRemaining = productRemaining;
    }

    public Integer getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Integer productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Product(Integer productId, String productUserId, String productName, Double productOldprice, Double productNowprice, Integer productRemaining, Integer productCategory, String productImage, String productDesc) {
        this.productId = productId;
        this.productUserId = productUserId;
        this.productName = productName;
        this.productOldprice = productOldprice;
        this.productNowprice = productNowprice;
        this.productRemaining = productRemaining;
        this.productCategory = productCategory;
        this.productImage = productImage;
        this.productDesc = productDesc;
    }

    public Product() {
    }
}
