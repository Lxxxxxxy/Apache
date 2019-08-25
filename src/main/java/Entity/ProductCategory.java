package Entity;

/**
 * @author lxxxxxxy
 * @time 2019/4/10 19:29
 */
public class ProductCategory {
    /*
    product_category_id	int
product_category_name	varchar

    * */
    private String productCategoryId;
    private Integer productBigCategoryId;
    private String productCategoryName;

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getProductBigCategoryId() {
        return productBigCategoryId;
    }

    public void setProductBigCategoryId(Integer productBigCategoryId) {
        this.productBigCategoryId = productBigCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", productBigCategoryId=" + productBigCategoryId +
                ", productCategoryName='" + productCategoryName + '\'' +
                '}';
    }

    public ProductCategory(String productCategoryId, Integer productBigCategoryId, String productCategoryName) {
        this.productCategoryId = productCategoryId;
        this.productBigCategoryId = productBigCategoryId;
        this.productCategoryName = productCategoryName;
    }

    public ProductCategory() {
    }
}
